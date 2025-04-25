package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

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
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {

    private final JsonFileRepository<Service> jsonRepository;

    public ServiceRepositoryImpl() {
        // Lista de adaptadores
        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(Duration.class, (JsonDeserializer<Duration>) (JsonElement json, Type typeOfT, JsonDeserializationContext context) -> Duration.parse(json.getAsString())),
                new TypeAdapterConfig<>(Duration.class, (JsonSerializer<Duration>) (Duration src, Type typeOfSrc, JsonSerializationContext context) -> new JsonPrimitive(src.toString()))
        );

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
}
