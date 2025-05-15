/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import java.util.List;

import javax.swing.JOptionPane;

import com.tecno_comfenalco.easywashproject.models.Vehicle;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.VehicleRepositoryImpl;

/**
 * Controlador para la gestión de vehículos.
 */
public class VehicleController {

    private final VehicleRepositoryImpl vehicleRepository;

    public VehicleController() {
        this.vehicleRepository = new VehicleRepositoryImpl();
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        try {
            Vehicle created = vehicleRepository.create(vehicle);
            if (created != null) {
                JOptionPane.showMessageDialog(null, "Vehículo registrado exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el vehículo.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            return created;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el vehículo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Vehicle findById(Long id) {
        try {
            Vehicle vehicle = vehicleRepository.findById(id);
            if (vehicle != null) {
                JOptionPane.showMessageDialog(null, "Vehículo encontrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return vehicle;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el vehículo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List<Vehicle> getAllVehicles() {
        try {
            List<Vehicle> vehicles = vehicleRepository.readAll();
            JOptionPane.showMessageDialog(null, "Vehículos recuperados exitosamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            return vehicles;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al recuperar los vehículos: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return java.util.Collections.emptyList();
        }
    }

    public Vehicle updateVehicle(Vehicle oldVehicle, Vehicle newVehicle) {
        try {
            Vehicle updated = vehicleRepository.update(oldVehicle, newVehicle);
            if (updated != null) {
                JOptionPane.showMessageDialog(null, "Vehículo actualizado exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el vehículo.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            return updated;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el vehículo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void deleteVehicle(Vehicle vehicle) {
        try {
            vehicleRepository.delete(vehicle);
            JOptionPane.showMessageDialog(null, "Vehículo eliminado exitosamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el vehículo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
