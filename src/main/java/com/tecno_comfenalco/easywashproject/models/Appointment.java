/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import com.tecno_comfenalco.easywashproject.enums.EnumAppointmentStatus;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author danil
 */
public class Appointment {
    private Service service;
    private Client client;
    private Employee employee;
    private EnumAppointmentStatus status;
    private LocalDate date;
    private LocalTime time;

    public Appointment(Service service, Client client, Employee employee, EnumAppointmentStatus status, LocalDate date, LocalTime time) {
        this.service = service;
        this.client = client;
        this.employee = employee;
        this.status = status;
        this.date = date;
        this.time = time;
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EnumAppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnumAppointmentStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    
}
