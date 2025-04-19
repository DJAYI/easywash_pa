/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import com.tecno_comfenalco.easywashproject.enums.EnumAppointmentStatus;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author danil
 */
public class Appointment {

    private List<Service> services;
    private Client client;
    private Employee employee;
    private EnumAppointmentStatus status;
    private LocalDate date;
    private LocalTime startTime;

    public Appointment(List<Service> services, Client client, Employee employee, EnumAppointmentStatus status, LocalDate date, LocalTime startTime) {
        this.services = services;
        this.client = client;
        this.employee = employee;
        this.status = status;
        this.date = date;
        this.startTime = startTime;
    }

    public LocalTime getDurationAppointment() {
        LocalTime duration = null;

        services.forEach((service) -> {
            duration.plusMinutes(service.getDuration().getMinute());
        });

        return duration;
    }

    public List<Service> getService() {
        return services;
    }

    public void setService(List<Service> service) {
        this.services = service;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime time) {
        this.startTime = time;
    }

}
