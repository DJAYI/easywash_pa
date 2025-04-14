/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.Vehicle;
import com.tecno_comfenalco.easywashproject.repository.VehicleRepository;

import java.util.List;

/**
 *
 * @author danil
 */
public class VehicleRepositoryImpl implements VehicleRepository{
    private final JsonFileRepository<Vehicle> jsonRepository;

    public VehicleRepositoryImpl() {
        Type listType = new TypeToken<List<Vehicle>>() {}.getType();
        this.jsonRepository = new JsonFileRepository<>("vehicles.json", listType, List.of());
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        List<Vehicle> list = jsonRepository.load();
        list.add(vehicle);
        jsonRepository.save(list);
        return vehicle;
    }

    @Override
    public List<Vehicle> readAll() {
        return jsonRepository.load();
    }

    @Override
    public Vehicle read(Vehicle key) {
        return jsonRepository.load().stream()
                .filter(v -> v.getPlate().equalsIgnoreCase(key.getPlate()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Vehicle update(Vehicle vehicle, Vehicle j) {
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
    }

    @Override
    public void delete(Vehicle vehicle) {
        List<Vehicle> list = jsonRepository.load();
        list.removeIf(existing -> existing.getPlate().equalsIgnoreCase(vehicle.getPlate()));
        jsonRepository.save(list);
        
        System.out.println("Vehiculo con placa " + vehicle.getPlate() + " Fue eliminado");
    }
    
}
