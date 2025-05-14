/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;
import java.util.List;

/**
 *
 * @author danil
 */
public class Client extends Person {

    // LLamo a la implementaciín del repositorio de cliente
    private transient final ClientRepositoryImpl clientRepositoryImpl = new ClientRepositoryImpl();

    // Atributos
    private Long id;
    private Vehicle vehicle;

    // Constructor
    public Client(Vehicle vehicle, String fullname, EnumDocType documentType, String documentNumber, String phoneNumber,
            String emailAddress) {

        // Constructor de la clase Abstracta
        super(fullname, documentType, documentNumber, phoneNumber, emailAddress);

        // Obtengo el ID del cliente y lo asigno
        List<Client> clientList = clientRepositoryImpl.readAll();
        if (clientList.isEmpty()) {
            this.id = 1L;
        } else {
            this.id = clientList.get(clientList.size() - 1).getId() + 1;
        }

        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
