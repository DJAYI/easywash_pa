/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.records.TypeAdapterConfig;
import com.tecno_comfenalco.easywashproject.repository.AppointmentRepository;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author danil
 */
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private final JsonFileRepository<Appointment> jsonFileRepository;

    public AppointmentRepositoryImpl() {
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(LocalTime.class, (JsonDeserializer<LocalTime>) (JsonElement json, Type typeOfT, JsonDeserializationContext context) -> LocalTime.parse(json.getAsString())),
                new TypeAdapterConfig<>(LocalTime.class, (JsonSerializer<LocalTime>) (LocalTime src, Type typeOfSrc, JsonSerializationContext context) -> new JsonPrimitive(src.toString())),
                new TypeAdapterConfig<>(LocalDate.class, (JsonDeserializer<LocalDate>) (JsonElement json, Type typeOfT, JsonDeserializationContext context) -> LocalDate.parse(json.getAsString())),
                new TypeAdapterConfig<>(LocalDate.class, (JsonSerializer<LocalDate>) (LocalDate src, Type typeOfSrc, JsonSerializationContext context) -> new JsonPrimitive(src.toString()))
        );

        this.jsonFileRepository = new JsonFileRepository<Appointment>("appointments.json", listType, adapters);

    }

    @Override
    public Appointment update(Appointment k, Appointment j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Appointment k) {
        List<Appointment> appointments = jsonFileRepository.load();
        appointments.remove(k);
        jsonFileRepository.save(appointments);
    }

    @Override
    public List<Appointment> readAll() {
        return jsonFileRepository.load();
    }

    @Override
    public Appointment read(Appointment k) {
        return jsonFileRepository.load().stream()
                .filter((t) -> t.getDate().equals(k.getDate()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Appointment create(Appointment k) {
        List<Appointment> appointments = jsonFileRepository.load();
        appointments.add(k);
        jsonFileRepository.save(appointments);
        return k;
    }

}
