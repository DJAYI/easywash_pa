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
public class User extends Person {

    private String username;
    private String password;

    public User(String username, String password, String fullname, EnumDocType documentType, String documentNumber, String phoneNumber, String emailAddress) {
        super(fullname, documentType, documentNumber, phoneNumber, emailAddress);

        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
