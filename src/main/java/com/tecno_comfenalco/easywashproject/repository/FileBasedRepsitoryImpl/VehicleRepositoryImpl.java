/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Vehicle;
import com.tecno_comfenalco.easywashproject.repository.VehicleRepository;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author danil
 */
public class VehicleRepositoryImpl implements VehicleRepository {

    private final JsonFileRepository<Vehicle> jsonFileRepository;

    public VehicleRepositoryImpl() {
        Type listType = new TypeToken<List<Vehicle>>() {
        }.getType();
        this.jsonFileRepository = new JsonFileRepository<Vehicle>("vehicles.json", listType, List.of());
    }

    @Override
    public Vehicle createAndAssignToOwner(Vehicle vehicle, Long clientId) {
        try {
            ClientRepositoryImpl clientRepositoryImpl = new ClientRepositoryImpl();

            Client client = clientRepositoryImpl.findById(clientId);
            System.out.println("Cliente encontrado Repositorio: " + client.getId());

            if (client == null) {
                System.out.println("No se encontró el cliente con ID: " + clientId);
                return vehicle;
            }

            // Asegura que la lista de vehículos no sea null
            List<Vehicle> vehicles = client.getVehicles();
            if (vehicles == null) {
                vehicles = new java.util.ArrayList<>();
            }
            vehicles.add(vehicle);
            client.setVehicles(vehicles);

            // Actualiza el cliente en el repositorio
            clientRepositoryImpl.update(clientRepositoryImpl.findById(clientId), client);

            // Guarda el vehículo en el repositorio
            List<Vehicle> existingVehicles = jsonFileRepository.load();
            if (existingVehicles == null) {
                existingVehicles = new java.util.ArrayList<>();
            }
            existingVehicles.add(vehicle);
            jsonFileRepository.save(existingVehicles);
            System.out.println("Vehículo asignado al cliente y guardado correctamente.");
            return vehicle;

        } catch (Exception e) {
            System.out.println("No se ha podido insertar el vehiculo al sistema");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Vehicle> readAll() {
        try {
            List<Vehicle> vehicles = jsonFileRepository.load();
            if (vehicles == null) {
                return java.util.Collections.emptyList();
            }
            vehicles.removeIf(v -> !(v instanceof Vehicle));
            return vehicles;
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información de los vehículos");
            System.out.println(e.getMessage());
            return java.util.Collections.emptyList();
        }
    }

    @Override
    public Vehicle read(Vehicle k) {
        try {
            List<Vehicle> vehicles = readAll();
            if (vehicles == null || vehicles.isEmpty()) {
                return null;
            }
            if (k.getId() != null) {
                return vehicles.stream()
                        .filter(v -> v.getId().equals(k.getId()))
                        .findFirst()
                        .orElse(null);
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el vehículo");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Vehicle update(Vehicle k, Vehicle j) {
        try {
            List<Vehicle> vehicles = jsonFileRepository.load();
            for (int i = 0; i < vehicles.size(); i++) {
                if (vehicles.get(i).equals(k)) {
                    vehicles.set(i, j);
                    jsonFileRepository.save(vehicles);
                    return j;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido modificar el vehículo");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Vehicle k) {
        try {
            List<Vehicle> vehicles = jsonFileRepository.load();
            if (vehicles == null) {
                vehicles = new java.util.ArrayList<>();
            }
            vehicles.removeIf(v -> v.getPlate() != null && v.getPlate().equals(k.getPlate()));
            jsonFileRepository.save(vehicles);
        } catch (Exception e) {
            System.out.println("No se ha podido eliminar el vehículo");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Vehicle findById(Long id) {
        try {
            List<Vehicle> vehicles = readAll();
            if (vehicles == null || vehicles.isEmpty()) {
                return null;
            }
            return vehicles.stream()
                    .filter(v -> v.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el vehículo por id");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Vehicle create(Vehicle k) {
        try {
            List<Vehicle> vehicles = readAll();
            if (vehicles == null) {
                vehicles = new java.util.ArrayList<>();
            }
            vehicles.add(k);
            jsonFileRepository.save(vehicles);
            return k;
        } catch (Exception e) {
            System.out.println("No se ha podido crear el vehículo");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
