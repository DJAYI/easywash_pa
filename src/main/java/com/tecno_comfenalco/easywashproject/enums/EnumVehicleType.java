/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.enums;

/**
 *
 * @author danil
 */
public enum EnumVehicleType {
    CAMIONETA("Camioneta"),
    CARRO("Carro"),
    MOTO("Moto");

    private String description;

    EnumVehicleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EnumVehicleType fromDescription(String description) {
        for (EnumVehicleType type : EnumVehicleType.values()) {
            if (type.getDescription().equalsIgnoreCase(description)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No se encontró el tipo de vehículo con la descripción: " + description);
    }
}
