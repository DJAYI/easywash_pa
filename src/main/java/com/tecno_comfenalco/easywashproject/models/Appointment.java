/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private LocalTime startTime; // Cambiado de Duration a LocalTime para representar la hora de inicio
    private Vehicle vehicle; // Nuevo campo para el vehículo de la cita

    // Constructor
    public Appointment(List<Service> services, Client client, Employee employee, EnumAppointmentStatus status,
            LocalDate date, LocalTime startTime, Vehicle vehicle) {
        // 1. Se obtiene el ID de la cita automáticamente.
        //    Se consulta el repositorio de citas y se asigna el siguiente ID disponible.
        this.appointmentRepositoryImpl = new AppointmentRepositoryImpl();

        List<Appointment> appointmentList = this.appointmentRepositoryImpl.readAll();
        // 2. Se valida si la lista es null o vacía para evitar NullPointerException.
        if (appointmentList == null || appointmentList.isEmpty()) {
            this.setId(1L);
        } else {
            this.setId((appointmentList.get(appointmentList.size() - 1).getId() + 1));
        }

        // 3. Se asignan los parámetros recibidos a los atributos de la clase.
        this.services = services;
        this.client = client;
        this.employee = employee;
        this.status = status;
        this.date = date;
        this.startTime = startTime; // Ahora es LocalTime
        this.vehicle = vehicle;     // Se asocia el vehículo a la cita
    }

    // Método para obtener la duración total de la cita sumando la duración de todos los servicios
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

    // Getter y Setter para hora de inicio (ahora LocalTime)
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime time) {
        this.startTime = time;
    }

    // Getter y Setter para ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y Setter para vehículo
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Método toString para depuración y visualización de la cita
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", services=" + services +
                ", client=" + client +
                ", employee=" + employee +
                ", status=" + status +
                ", date=" + date +
                ", startTime=" + startTime +
                ", vehicle=" + vehicle +
                '}';
    }

    /*
     * RESUMEN DE CAMBIOS Y FUNCIONAMIENTO:
     * 1. Se cambió el tipo del campo startTime de Duration a LocalTime para reflejar correctamente la hora de inicio de la cita.
     * 2. Se añadió el campo Vehicle a la clase Appointment y se actualizó el constructor y los métodos getter/setter correspondientes para asociar un vehículo a cada cita.
     * 3. En el constructor, se maneja el caso en que la lista de citas sea null o vacía para evitar NullPointerException y asignar correctamente el ID.
     * 4. El método getDurationAppointment() calcula la duración total de la cita sumando la duración de todos los servicios asociados.
     */
}
