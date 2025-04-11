package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.repository.ServiceRepository;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.*;
import com.tecno_comfenalco.easywashproject.records.TypeAdapterConfig;

public class ServiceRepositoryImpl implements ServiceRepository {

    private final JsonFileRepository<Service> jsonRepository;

    public ServiceRepositoryImpl() {
        List<TypeAdapterConfig<?>> adapters = List.of(
            new TypeAdapterConfig<>(LocalTime.class, new JsonDeserializer<LocalTime>() {
                public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                        throws JsonParseException {
                    return LocalTime.parse(json.getAsString());
                }
            }),
            new TypeAdapterConfig<>(LocalTime.class, new JsonSerializer<LocalTime>() {
                public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(src.toString());
                }
            })
        );

        Type listType = new TypeToken<List<Service>>() {}.getType();
        this.jsonRepository = new JsonFileRepository<>("services.json", listType, adapters);
    }

    @Override
    public Service create(Service s) {
        List<Service> list = jsonRepository.load();
        list.add(s);
        jsonRepository.save(list);
        return s;
    }

    @Override
    public List<Service> readAll() {
        return jsonRepository.load();
    }

    @Override
    public Service read(Service key) {
        return jsonRepository.load().stream()
                .filter(s -> s.getName().equalsIgnoreCase(key.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Service update(Service s) {
        List<Service> list = jsonRepository.load();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(s.getName())) {
                list.set(i, s);
                jsonRepository.save(list);
                return s;
            }
        }
        return null;
    }

    @Override
    public void delete(Service s) {
        List<Service> list = jsonRepository.load();
        list.removeIf(existing -> existing.getName().equalsIgnoreCase(s.getName()));
        jsonRepository.save(list);
    }
}
