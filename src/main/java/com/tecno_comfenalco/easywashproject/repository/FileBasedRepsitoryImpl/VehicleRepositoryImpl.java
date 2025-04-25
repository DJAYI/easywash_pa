/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.Vehicle;
import com.tecno_comfenalco.easywashproject.repository.VehicleRepository;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author danil
 */
public class VehicleRepositoryImpl implements VehicleRepository {

    private final JsonFileRepository<Vehicle> jsonRepository;

    public VehicleRepositoryImpl() {
        Type listType = new TypeToken<List<Vehicle>>() {
        }.getType();
        this.jsonRepository = new JsonFileRepository<>("vehicles.json", listType, List.of());
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        try {
            List<Vehicle> list = jsonRepository.load();
            list.add(vehicle);
            jsonRepository.save(list);
            return vehicle;

        } catch (Exception e) {
            System.out.println("No se ha podido insertar el vehiculo al sistema");
            return null;
        }
    }

    @Override
    public List<Vehicle> readAll() {
        try {
            return jsonRepository.load();

        } catch (Exception e) {
            System.out.println("No seha podido recuperar la información de los vehiculos en el sistema");
            return null;
        }
    }

    @Override
    public Vehicle read(Vehicle key) {
        try {
            return jsonRepository.load().stream()
                    .filter(v -> v.getPlate().equalsIgnoreCase(key.getPlate()))
                    .findFirst()
                    .orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información del vehículo solicitado");
            return null;
        }
    }

    @Override
    public Vehicle update(Vehicle vehicle, Vehicle j) {
        try {
            List<Vehicle> list = jsonRepository.load();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPlate().equalsIgnoreCase(vehicle.getPlate())) {
                    list.set(i, j);
                    jsonRepository.save(list);
                    System.out.println("Vehiculo actualizado");
                    System.out.println(j);
                    return j;
                }
            }
            System.out.println("Vehiculo no actualizado");
            return null;

        } catch (Exception e) {
            System.out.println("No se ha podido modificaar la información del vehiculo solicitado");
            return null;
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        try {
            List<Vehicle> list = jsonRepository.load();
            list.removeIf(existing -> existing.getPlate().equalsIgnoreCase(vehicle.getPlate()));
            jsonRepository.save(list);

            System.out.println("Vehiculo con placa " + vehicle.getPlate() + " Fue eliminado");

        } catch (Exception e) {
            System.out.println("No se ha podido eliminar el vehiculo del sistema");

        }
    }

}
