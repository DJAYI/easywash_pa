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
    
    public static EnumDocType fromString(String valor) {
        try {
            return EnumDocType.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de documento no valido: " + valor + ". Valores aceptados: " + Arrays.toString(EnumDocType.values()));
    }     
 }      

    public static String[] getDescripciones() {
        return Arrays.stream(values())
                     .map(EnumDocType::getDescripcion)
                     .toArray(String[]::new);
    }
}
