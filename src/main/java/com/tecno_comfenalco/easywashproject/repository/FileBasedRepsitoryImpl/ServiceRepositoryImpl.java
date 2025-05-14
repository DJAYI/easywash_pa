package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.List;

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

    private final JsonFileRepository<Service> jsonFileRepository;

    public ServiceRepositoryImpl() {
        Type listType = new TypeToken<List<Service>>() {
        }.getType();

        // Custom TypeAdapter for Duration
        JsonSerializer<Duration> durationSerializer = (src, typeOfSrc, context) -> new JsonPrimitive(src.toString());
        JsonDeserializer<Duration> durationDeserializer = (json, typeOfT, context) -> Duration
                .parse(json.getAsString());

        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(Duration.class, durationSerializer),
                new TypeAdapterConfig<>(Duration.class, durationDeserializer));

        this.jsonFileRepository = new JsonFileRepository<Service>("services.json", listType, adapters);
    }

    @Override
    public Service update(Service k, Service j) {
        try {
            List<Service> services = jsonFileRepository.load();
            for (int i = 0; i < services.size(); i++) {
                if (services.get(i).equals(k)) {
                    services.set(i, j);
                    jsonFileRepository.save(services);
                    return j;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido modificar el servicio");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Service k) {
        try {
            List<Service> services = jsonFileRepository.load();
            services.remove(k);
            jsonFileRepository.save(services);
        } catch (Exception e) {
            System.out.println("No se ha podido eliminar el servicio");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Service> readAll() {
        try {
            List<Service> services = jsonFileRepository.load();
            if (services == null) {
                return java.util.Collections.emptyList();
            }
            // Filtra servicios inválidos y captura errores de duración
            services.removeIf(s -> {
                try {
                    // Si la duración no es válida, Duration.parse lanzará excepción
                    Duration d = s.getDuration();
                    d.toMinutes(); // fuerza acceso para detectar errores de parseo
                    return false;
                } catch (Exception ex) {
                    System.out.println("Error al parsear la duración de un servicio: " + ex.getMessage());
                    return true;
                }
            });
            return services;
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información de los servicios");
            System.out.println(e.getMessage());
            return java.util.Collections.emptyList();
        }
    }

    @Override
    public Service read(Service k) {
        try {
            List<Service> services = readAll();
            if (services == null || services.isEmpty()) {
                return null;
            }
            if (k.getId() != null) {
                return services.stream()
                        .filter(s -> s.getId().equals(k.getId()))
                        .findFirst()
                        .orElse(null);
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el servicio");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Service create(Service k) {
        try {
            List<Service> services = readAll();
            if (services == null) {
                services = new java.util.ArrayList<>();
            }
            services.add(k);
            jsonFileRepository.save(services);
            return k;
        } catch (Exception e) {
            System.out.println("No se ha podido crear el servicio");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Service findById(Long id) {
        try {
            List<Service> services = readAll();
            if (services == null || services.isEmpty()) {
                return null;
            }
            return services.stream()
                    .filter(s -> s.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el servicio por id");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
