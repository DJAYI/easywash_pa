/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.enums;

import java.util.Arrays;

/**
 *
 * @author danil
 */
public enum EnumDocType {
    CC("Cedula de Ciudadania"),
    TI("Tarjeta de Identidad"),
    CE("Cedula Extranjeria"),
    PP("Pasaporte"),
    PPT("Permiso Provisional de Permanencia");

    private final String descripcion;

    EnumDocType(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Metodo para obtener un valor de Enum apartir de una Descripción
    public static EnumDocType fromDescripcion(String descripcion) {
        // Retorna el documento que tenga 
        // coincidencia con la descripción que recibe como argumento
        return Arrays.stream(values())
                .filter(e -> e.getDescripcion().equalsIgnoreCase(descripcion))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Descripción no válida: " + descripcion));
    }

    public static String[] getDescripciones() {
        return Arrays.stream(values())
                .map(EnumDocType::getDescripcion)
                .toArray(String[]::new);
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
