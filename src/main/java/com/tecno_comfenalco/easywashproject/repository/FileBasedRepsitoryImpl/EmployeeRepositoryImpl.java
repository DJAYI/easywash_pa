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
import java.time.Duration;
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

        // Custom TypeAdapter for Duration
        JsonSerializer<Duration> durationSerializer = (src, typeOfSrc, context) -> new JsonPrimitive(src.toString());
        JsonDeserializer<Duration> durationDeserializer = (json, typeOfT, context) -> Duration
                .parse(json.getAsString());

        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(Duration.class, durationSerializer),
                new TypeAdapterConfig<>(Duration.class, durationDeserializer));

        this.jsonFileRepository = new JsonFileRepository<Employee>("employees.json", listType, adapters);
    }

    @Override
    public Employee create(Employee k) {
        try {
            List<Employee> employees = readAll();
            if (employees == null) {
                employees = new java.util.ArrayList<>();
            }
            employees.add(k);
            jsonFileRepository.save(employees);
            return k;
        } catch (Exception e) {
            System.out.println("No se ha podido crear el empleado");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Employee read(Employee k) {
        try {
            List<Employee> employees = readAll();
            if (employees == null || employees.isEmpty()) {
                return null;
            }
            if (k.getId() != null) {
                return employees.stream()
                        .filter(e -> e.getId().equals(k.getId()))
                        .findFirst()
                        .orElse(null);
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el empleado");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Employee> readAll() {
        try {
            List<Employee> employees = jsonFileRepository.load();
            if (employees == null) {
                return java.util.Collections.emptyList();
            }
            employees.removeIf(e -> !(e instanceof Employee));
            return employees;
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información de los empleados");
            System.out.println(e.getMessage());
            return java.util.Collections.emptyList();
        }
    }

    @Override
    public void delete(Employee k) {
        try {
            List<Employee> employees = jsonFileRepository.load();
            employees.remove(k);
            jsonFileRepository.save(employees);
        } catch (Exception e) {
            System.out.println("No se ha podido eliminar el empleado");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Employee update(Employee k, Employee j) {
        try {
            List<Employee> employees = jsonFileRepository.load();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).equals(k)) {
                    employees.set(i, j);
                    jsonFileRepository.save(employees);
                    return j;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido modificar el empleado");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Employee findById(Long id) {
        try {
            List<Employee> employees = readAll();
            if (employees == null || employees.isEmpty()) {
                return null;
            }
            return employees.stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el empleado por id");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
