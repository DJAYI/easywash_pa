/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tecno_comfenalco.easywashproject.records.TypeAdapterConfig;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danil
 */
public class JsonFileRepository<T> {

    private final Gson gson;
    private final String filePath;
    private final Type typeOfT;

    public JsonFileRepository(String filePath, Type typeOfT, List<TypeAdapterConfig<?>> adapters) {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();

        for (TypeAdapterConfig<?> adapter : adapters) {
            // cast obligada por la magia oscura de los genéricos
            @SuppressWarnings("unchecked")
            TypeAdapterConfig<Object> config = (TypeAdapterConfig<Object>) adapter;
            builder.registerTypeAdapter(config.type(), config.adapter());
        }

        this.gson = builder.create();
        this.filePath = filePath;
        this.typeOfT = typeOfT;
    }

    public List<T> load() {
        try (Reader reader = new FileReader(filePath)) {
            List<T> items = gson.fromJson(reader, typeOfT);
            return items != null ? items : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void save(List<T> items) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }

}
