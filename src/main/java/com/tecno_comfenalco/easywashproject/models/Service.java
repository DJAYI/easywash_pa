/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.time.Duration;
import java.util.List;

import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;

/**
 * Modelo que representa un servicio ofrecido.
 * Incluye lógica para asignar un ID único y atributos básicos.
 * 
 * @author danil
 */
public class Service {

    // Instancia del repositorio para acceder a los servicios almacenados
    private transient final ServiceRepositoryImpl serviceRepositoryImpl = new ServiceRepositoryImpl();

    // Atributos del servicio
    private Long id; // Identificador único
    private String name; // Nombre del servicio
    private double price; // Precio del servicio
    private String description; // Descripción del servicio
    private Duration duration; // Duración del servicio

    /**
     * Constructor de la clase Service.
     * Asigna un ID único automáticamente basado en los registros existentes.
     * 
     * @param name        Nombre del servicio
     * @param price       Precio del servicio
     * @param description Descripción
     * @param duration    Duración
     */
    public Service(String name, double price, String description, Duration duration) {
        // Obtengo la lista de servicios existentes
        List<Service> serviceList = serviceRepositoryImpl.readAll();
        // Si la lista está vacía, asigno el ID 1. Si no, sumo 1 al último ID.
        this.id = serviceList.isEmpty() ? 1L : serviceList.get(serviceList.size() - 1).getId() + 1;

        // Asigno los valores recibidos a los atributos
        this.name = name;
        this.price = price;
        this.description = description;
        this.duration = duration;
    }

    // Getter para el ID
    public Long getId() {
        return id;
    }

    // Setter para el ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el nombre
    public String getName() {
        return name;
    }

    // Setter para el nombre
    public void setName(String name) {
        this.name = name;
    }

    // Getter para el precio
    public double getPrice() {
        return price;
    }

    // Setter para el precio
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter para la descripción
    public String getDescription() {
        return description;
    }

    // Setter para la descripción
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter para la duración
    public Duration getDuration() {
        return duration;
    }

    // Setter para la duración
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    // Representación en texto del objeto Service
    @Override
    public String toString() {
        return "Service{" +
                "name=" + name +
                ", price=" + price +
                ", description=" + description +
                ", duration=" + duration +
                '}';
    }

}
