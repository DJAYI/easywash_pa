/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;

/**
 *
 * @author danil
 */
public class Client extends Person {

    private Vehicle vehicle;

    public Client(Vehicle vehicle, String fullname, EnumDocType documentType, String documentNumber, String phoneNumber, String emailAddress) {
        super(fullname, documentType, documentNumber, phoneNumber, emailAddress);

        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
