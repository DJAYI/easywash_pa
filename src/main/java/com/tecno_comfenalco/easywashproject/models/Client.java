/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.util.ArrayList;
import java.util.List;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;

/**
 *
 * @author danil
 */
public class Client extends Person {

    // LLamo a la implementaciín del repositorio de cliente
    private transient final ClientRepositoryImpl clientRepositoryImpl = new ClientRepositoryImpl();

    // Atributos
    private Long id;
    private List<Vehicle> vehicles;

    // Constructor
    public Client(List<Vehicle> vehicles, String fullname, EnumDocType documentType, String documentNumber,
            String phoneNumber,
            String emailAddress) {

        // Constructor de la clase Abstracta
        super(fullname, documentType, documentNumber, phoneNumber, emailAddress);
        this.vehicles = (vehicles != null) ? vehicles : new ArrayList<>();

        // Obtengo el ID del cliente y lo asigno
        List<Client> clientList = clientRepositoryImpl.readAll();
        if (clientList.isEmpty()) {
            this.id = 1L;
        } else {
            this.id = clientList.get(clientList.size() - 1).getId() + 1;
        }
    }

    // Constructor de conveniencia para un solo vehículo
    public Client(Vehicle vehicle, String fullname, EnumDocType documentType, String documentNumber, String phoneNumber,
            String emailAddress) {
        this(new ArrayList<>(List.of(vehicle)), fullname, documentType, documentNumber, phoneNumber, emailAddress);
    }

    public List<Vehicle> getVehicles() {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Método para agregar un vehículo al cliente
    public void addVehicle(Vehicle vehicle) {
        getVehicles().add(vehicle);
    }

    @Override
    public String toString() {
        return "Client [clientRepositoryImpl=" + clientRepositoryImpl + ", id=" + id + ", vehicles=" + vehicles
                + ", getFullname()=" + getFullname() + ", getDocumentType()=" + getDocumentType()
                + ", getDocumentNumber()=" + getDocumentNumber() + ", getClass()=" + getClass() + ", getPhoneNumber()="
                + getPhoneNumber() + ", getMailAddress()=" + getMailAddress() + ", getVehicles()=" + getVehicles()
                + ", getId()=" + getId() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
