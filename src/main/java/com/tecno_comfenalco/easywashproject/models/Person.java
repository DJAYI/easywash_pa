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
public abstract class Person {

    private String fullname;
    private EnumDocType documentType;
    private String documentNumber;
    private String phoneNumber;
    private String mailAddress;

    public Person(String fullname, EnumDocType documentType, String documentNumber, String phoneNumber,
            String mailAddress) {
        this.fullname = fullname;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public EnumDocType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(EnumDocType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

}
