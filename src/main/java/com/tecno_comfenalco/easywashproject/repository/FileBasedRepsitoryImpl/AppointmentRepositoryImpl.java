/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.LocalDate;
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
import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.records.TypeAdapterConfig;
import com.tecno_comfenalco.easywashproject.repository.AppointmentRepository;

public class AppointmentRepositoryImpl implements AppointmentRepository {

    private final JsonFileRepository<Appointment> jsonFileRepository;

    public AppointmentRepositoryImpl() {
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Custom TypeAdapter for Duration
        JsonSerializer<Duration> durationSerializer = (src, typeOfSrc, context) -> new JsonPrimitive(src.toString());
        JsonDeserializer<Duration> durationDeserializer = (json, typeOfT, context) -> Duration
                .parse(json.getAsString());

        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(LocalTime.class,
                        (JsonDeserializer<LocalTime>) (JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) -> LocalTime.parse(json.getAsString(),
                                        timeFormatter)),
                new TypeAdapterConfig<>(LocalTime.class,
                        (JsonSerializer<LocalTime>) (LocalTime src, Type typeOfSrc,
                                JsonSerializationContext context) -> new JsonPrimitive(src.format(timeFormatter))),
                new TypeAdapterConfig<>(LocalDate.class,
                        (JsonDeserializer<LocalDate>) (JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) -> LocalDate.parse(json.getAsString(),
                                        dateFormatter)),
                new TypeAdapterConfig<>(LocalDate.class, (JsonSerializer<LocalDate>) (LocalDate src, Type typeOfSrc,
                        JsonSerializationContext context) -> new JsonPrimitive(src.format(dateFormatter))),
                // Register Duration adapters
                new TypeAdapterConfig<>(Duration.class, durationSerializer),
                new TypeAdapterConfig<>(Duration.class, durationDeserializer),
                // Employee adapters (serialize as ID, deserialize by ID)
                new TypeAdapterConfig<>(Employee.class,
                        (JsonSerializer<Employee>) (Employee src, Type typeOfSrc,
                                JsonSerializationContext context) -> new JsonPrimitive(src.getId())),
                new TypeAdapterConfig<>(Employee.class,
                        (JsonDeserializer<Employee>) (JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) -> {
                            Long id = json.getAsLong();
                            // Implementa aquí la lógica para obtener el empleado por ID.
                            // Por ejemplo, podrías tener un método estático EmployeeRepository.findById(id)
                            // Aquí se deja como ejemplo:
                            return new EmployeeRepositoryImpl().findById(id);
                        }));

        this.jsonFileRepository = new JsonFileRepository<Appointment>("appointments.json", listType, adapters);

    }

    @Override
    public Appointment update(Appointment k, Appointment j) {
        try {
            List<Appointment> appointments = jsonFileRepository.load();

            for (int i = 0; i < appointments.size(); i++) {
                if (appointments.get(i).equals(k)) {
                    appointments.set(i, j);
                    return j;
                }
            }

            return null;

        } catch (Exception e) {
            System.out.println("No se ha podido modificar la cita");
            return null;
        }

    }

    @Override
    public void delete(Appointment k) {
        try {
            List<Appointment> appointments = jsonFileRepository.load();
            appointments.remove(k);
            jsonFileRepository.save(appointments);
        } catch (Exception e) {
            System.out.println("No se ha podido eliminar la cita");
        }
    }

    @Override
    public List<Appointment> readAll() {
        try {
            return jsonFileRepository.load();

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información de las citas");
            return java.util.Collections.emptyList();
        }
    }

    @Override
    public Appointment read(Appointment k) {
        try {
            return jsonFileRepository.load().stream()
                    .filter((t) -> t.getDate().equals(k.getDate()))
                    .findFirst()
                    .orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido encontrar la cita");
            return null;
        }
    }

    @Override
    public Appointment create(Appointment k) {
        try {
            List<Appointment> appointments = jsonFileRepository.load();
            appointments.add(k);
            jsonFileRepository.save(appointments);
            return k;

        } catch (Exception e) {
            System.out.println("No se ha podido crear la cita");
            return null;
        }
    }

    @Override
    public Appointment findById(Long id) {
        try {
            return jsonFileRepository.load().stream()
                    .filter(a -> a.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar la cita por id");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
