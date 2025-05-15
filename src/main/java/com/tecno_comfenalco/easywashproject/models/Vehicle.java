/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.util.List;

import com.tecno_comfenalco.easywashproject.enums.EnumVehicleType;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.VehicleRepositoryImpl;

/**
 * Modelo que representa un vehículo en el sistema.
 * Incluye atributos básicos y lógica para asignar un ID único.
 * 
 * @author danil
 */
public class Vehicle {

    // Instancia del repositorio para acceder a los vehículos almacenados
    private transient final VehicleRepositoryImpl vehicleRepositoryImpl = new VehicleRepositoryImpl();

    // Atributos del vehículo
    private Long id; // Identificador único
    private String model; // Modelo del vehículo
    private String brand; // Marca del vehículo
    private String plate; // Placa del vehículo
    private String color; // Color del vehículo
    private EnumVehicleType type; // Tipo de vehículo (enum)

    /**
     * Constructor de la clase Vehicle.
     * Asigna un ID único automáticamente basado en los registros existentes.
     * 
     * @param model Modelo del vehículo
     * @param brand Marca del vehículo
     * @param plate Placa del vehículo
     * @param color Color del vehículo
     * @param type  Tipo de vehículo
     */
    public Vehicle(String model, String brand, String plate, String color, EnumVehicleType type) {
        // Obtengo la lista de vehículos existentes
        List<Vehicle> vehicleList = vehicleRepositoryImpl.readAll();
        // Si la lista está vacía, asigno el ID 1. Si no, sumo 1 al último ID.
        this.id = vehicleList.isEmpty() ? 1L : vehicleList.get(vehicleList.size() - 1).getId() + 1;

        // Asigno los valores recibidos a los atributos
        this.model = model;
        this.brand = brand;
        this.plate = plate;
        this.color = color;
        this.type = type;
    }

    // Getter para el ID
    public Long getId() {
        return id;
    }

    // Setter para el ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el modelo
    public String getModel() {
        return model;
    }

    // Setter para el modelo
    public void setModel(String model) {
        this.model = model;
    }

    // Getter para la marca
    public String getBrand() {
        return brand;
    }

    // Setter para la marca
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter para la placa
    public String getPlate() {
        return plate;
    }

    // Setter para la placa
    public void setPlate(String plate) {
        this.plate = plate;
    }

    // Getter para el color
    public String getColor() {
        return color;
    }

    // Setter para el color
    public void setColor(String color) {
        this.color = color;
    }

    // Getter para el tipo
    public EnumVehicleType getType() {
        return type;
    }

    // Setter para el tipo
    public void setType(EnumVehicleType type) {
        this.type = type;
    }

    // Representación en texto del objeto Vehicle
    @Override
    public String toString() {
        return "Vehicle{" +
                "model=" + model +
                ", brand=" + brand +
                ", plate=" + plate +
                ", color=" + color +
                ", type=" + type +
                '}';
    }

}
