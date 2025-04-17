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
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.records.TypeAdapterConfig;
import com.tecno_comfenalco.easywashproject.repository.EmployeeRepository;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author danil
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JsonFileRepository<Employee> jsonFileRepository;

    public EmployeeRepositoryImpl() {
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(LocalTime.class, (JsonDeserializer<LocalTime>) (JsonElement json, Type typeOfT, JsonDeserializationContext context) -> LocalTime.parse(json.getAsString())),
                new TypeAdapterConfig<>(LocalTime.class, (JsonSerializer<LocalTime>) (LocalTime src, Type typeOfSrc, JsonSerializationContext context) -> new JsonPrimitive(src.toString()))
        );

        this.jsonFileRepository = new JsonFileRepository<Employee>("employees.json", listType, adapters);
    }

    @Override
    public Employee create(Employee k) {
        List<Employee> employeeList = jsonFileRepository.load();
        employeeList.add(k);
        return k;
    }

    @Override
    public Employee read(Employee k) {
        return jsonFileRepository.load()
                .stream()
                .filter((t) -> t.getDocumentNumber().equals(k.getDocumentNumber()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> readAll() {
        return jsonFileRepository.load();
    }

    @Override
    public void delete(Employee k) {
        List<Employee> employeeList = jsonFileRepository.load();
        employeeList.remove(k);
        jsonFileRepository.save(employeeList);
    }

    @Override
    public Employee update(Employee k, Employee j) {
        List<Employee> employeeList = jsonFileRepository.load();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(k.getDocumentNumber())) {
                employeeList.set(i, j);
                jsonFileRepository.save(employeeList);
                return j;
            }
        }

        return null;
    }

}
