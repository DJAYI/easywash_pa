/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import com.tecno_comfenalco.easywashproject.enums.EnumVehicleType;

/**
 *
 * @author danil
 */
public class Vehicle {
    private String model;
    private VehicleBrand brand;
    private String plate;
    private String color;
    private EnumVehicleType type;

    public Vehicle(String model, VehicleBrand brand, String plate, String color, EnumVehicleType type) {
        this.model = model;
        this.brand = brand;
        this.plate = plate;
        this.color = color;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public EnumVehicleType getType() {
        return type;
    }

    public void setType(EnumVehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "model=" + model + ", brand=" + brand + ", plate=" + plate + ", color=" + color + ", type=" + type + '}';
    }
    
    
}
