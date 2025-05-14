package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.records.TypeAdapterConfig;
import com.tecno_comfenalco.easywashproject.repository.ServiceRepository;

public class ServiceRepositoryImpl implements ServiceRepository {

    private final JsonFileRepository<Service> jsonRepository;

    public ServiceRepositoryImpl() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Lista de adaptadores
        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(Duration.class,
                        (JsonDeserializer<Duration>) (JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) -> {
                            String timeStr = json.getAsString();
                            LocalTime lt = LocalTime.parse(timeStr, timeFormatter);
                            return Duration.ofHours(lt.getHour()).plusMinutes(lt.getMinute())
                                    .plusSeconds(lt.getSecond());
                        }),
                new TypeAdapterConfig<>(Duration.class, (JsonSerializer<Duration>) (Duration src, Type typeOfSrc,
                        JsonSerializationContext context) -> {
                    long seconds = src.getSeconds();
                    long absSeconds = Math.abs(seconds);
                    String formatted = String.format("%02d:%02d:%02d",
                            absSeconds / 3600,
                            (absSeconds % 3600) / 60,
                            absSeconds % 60);
                    return new JsonPrimitive(formatted);
                }));

        // Define el tipo de la lista de servicios
        Type listType = new TypeToken<List<Service>>() {
        }.getType();
        this.jsonRepository = new JsonFileRepository<>("services.json", listType, adapters);
    }

    @Override
    public Service create(Service s) {
        try {
            List<Service> list = jsonRepository.load();
            list.add(s);

            jsonRepository.save(list);
            return s;

        } catch (Exception e) {
            System.out.println("No se ha podido insertar el servicio en el sistema");
            return null;
        }
    }

    @Override
    public List<Service> readAll() {
        try {
            return jsonRepository.load();

        } catch (Exception e) {
            System.out.println("No se ha podido obtener la información de los servicios");
            return null;
        }
    }

    @Override
    public Service read(Service key) {
        try {
            return jsonRepository.load().stream()
                    .filter(s -> s.getName().equalsIgnoreCase(key.getName()))
                    .findFirst()
                    .orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información del servicio solicitado");
            return null;
        }
    }

    @Override
    public Service update(Service s, Service j) {
        try {
            List<Service> list = jsonRepository.load();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equalsIgnoreCase(s.getName())) {
                    list.set(i, j);
                    jsonRepository.save(list);
                    return j;
                }
            }
            return null;

        } catch (Exception e) {
            System.out.println("No se ha podido modificar la información del servicio solicitado");
            return null;
        }
    }

    @Override
    public void delete(Service s) {
        try {
            List<Service> list = jsonRepository.load();
            list.removeIf(existing -> existing.getName().equalsIgnoreCase(s.getName()));
            jsonRepository.save(list);

        } catch (Exception e) {
            System.out.println("No se ha podido eliminar al servicio");
        }
    }

    @Override
    public Service findById(Long id) {
        try {
            return jsonRepository.load().stream()
                    .filter(s -> s.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el servicio por id");
            return null;
        }
    }
}
