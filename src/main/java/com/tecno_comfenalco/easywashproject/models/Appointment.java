/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import com.tecno_comfenalco.easywashproject.enums.EnumAppointmentStatus;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.AppointmentRepositoryImpl;

/**
 *
 * @author danil
 */
public class Appointment {

    // Llamo a la implementación del repositorio de citas
    private transient final AppointmentRepositoryImpl appointmentRepositoryImpl;

    // Atributos
    private Long id;
    private List<Service> services;
    private Client client;
    private Employee employee;
    private EnumAppointmentStatus status;
    private LocalDate date;
    private Duration startTime;

    // Constructor
    public Appointment(List<Service> services, Client client, Employee employee, EnumAppointmentStatus status,
            LocalDate date, Duration startTime) {
        // Obtengo el ID de la cita y lo asigno
        this.appointmentRepositoryImpl = new AppointmentRepositoryImpl();

        List<Appointment> appointmentList = this.appointmentRepositoryImpl.readAll();
        if (appointmentList == null || appointmentList.isEmpty()) {
            this.setId(1L);
        } else {
            this.setId((appointmentList.get(appointmentList.size() - 1).getId() + 1));
        }

        this.services = services;
        this.client = client;
        this.employee = employee;
        this.status = status;
        this.date = date;
        this.startTime = startTime;
    }

    // Método para obtener la duración total de la cita
    public Duration getDurationAppointment() {
        return services.stream()
                .map(Service::getDuration)
                .reduce(Duration.ZERO, Duration::plus);
    }

    // Getter y Setter para servicios
    public List<Service> getService() {
        return services;
    }

    public void setService(List<Service> service) {
        this.services = service;
    }

    // Getter y Setter para cliente
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Getter y Setter para empleado
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // Getter y Setter para estado
    public EnumAppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnumAppointmentStatus status) {
        this.status = status;
    }

    // Getter y Setter para fecha
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter y Setter para hora de inicio
    public Duration getStartTime() {
        return startTime;
    }

    public void setStartTime(Duration time) {
        this.startTime = time;
    }

    // Getter y Setter para ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
