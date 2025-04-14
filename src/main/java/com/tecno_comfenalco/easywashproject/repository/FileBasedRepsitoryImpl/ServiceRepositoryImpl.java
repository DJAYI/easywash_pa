package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import java.lang.reflect.Type;
import java.time.LocalTime;
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
        List<TypeAdapterConfig<?>> adapters = List.of(
            
            new TypeAdapterConfig<>(LocalTime.class, (JsonDeserializer<LocalTime>) (JsonElement json, Type typeOfT, JsonDeserializationContext context) -> LocalTime.parse(json.getAsString())),

            new TypeAdapterConfig<>(LocalTime.class, (JsonSerializer<LocalTime>) (LocalTime src, Type typeOfSrc, JsonSerializationContext context) -> new JsonPrimitive(src.toString()))
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
    public Service update(Service s, Service j) {
        List<Service> list = jsonRepository.load();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(s.getName())) {
                list.set(i, j);
                jsonRepository.save(list);
                return j;
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
