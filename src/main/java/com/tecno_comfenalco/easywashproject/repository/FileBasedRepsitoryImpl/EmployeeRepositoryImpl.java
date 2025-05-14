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
import java.time.format.DateTimeFormatter;
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

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        List<TypeAdapterConfig<?>> adapters = List.of(
                new TypeAdapterConfig<>(LocalTime.class,
                        (JsonDeserializer<LocalTime>) (JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) -> LocalTime.parse(json.getAsString(),
                                        timeFormatter)),
                new TypeAdapterConfig<>(LocalTime.class, (JsonSerializer<LocalTime>) (LocalTime src, Type typeOfSrc,
                        JsonSerializationContext context) -> new JsonPrimitive(src.format(timeFormatter))));

        this.jsonFileRepository = new JsonFileRepository<Employee>("employees.json", listType, adapters);
    }

    @Override
    public Employee create(Employee k) {
        try {
            List<Employee> employeeList = jsonFileRepository.load();
            employeeList.add(k);
            return k;

        } catch (Exception e) {
            System.out.println("No se ha podido insertar al empleado al sistema");
            return null;
        }
    }

    @Override
    public Employee read(Employee k) {
        try {
            return jsonFileRepository.load()
                    .stream()
                    .filter((t) -> t.getDocumentNumber().equals(k.getDocumentNumber()))
                    .findFirst()
                    .orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información del empleado solicitado");
            return null;
        }
    }

    @Override
    public List<Employee> readAll() {
        try {
            return jsonFileRepository.load();

        } catch (Exception e) {
            System.out.println("No se ha podido la información de la los empleados");
            return null;
        }
    }

    @Override
    public void delete(Employee k) {
        try {
            List<Employee> employeeList = jsonFileRepository.load();
            employeeList.remove(k);
            jsonFileRepository.save(employeeList);

        } catch (Exception e) {
            System.out.println("No se ha podido eliminar al empleado solicitado");
        }
    }

    @Override
    public Employee update(Employee k, Employee j) {
        try {
            List<Employee> employeeList = jsonFileRepository.load();

            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).equals(k.getDocumentNumber())) {
                    employeeList.set(i, j);
                    jsonFileRepository.save(employeeList);
                    return j;
                }
            }

            return null;

        } catch (Exception e) {
            System.out.println("No se ha podido modificar la información del empleado solicitado");
            return null;
        }
    }

    @Override
    public Employee findById(Long id) {
        try {
            return jsonFileRepository.load().stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el empleado por id");
            return null;
        }
    }

}
