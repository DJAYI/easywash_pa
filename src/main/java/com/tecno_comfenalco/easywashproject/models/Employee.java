/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.EmployeeRepositoryImpl;

/**
 * Modelo que representa un empleado.
 * Incluye lógica para asignar un ID único y atributos relacionados con el
 * horario y citas.
 * Hereda de Person.
 * 
 * @author danil
 */
public class Employee extends Person {

    // Instancia del repositorio para acceder a los empleados almacenados
    private transient final EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();

    // Atributos del empleado
    private Long id; // Identificador único
    private double salary; // Salario
    private Duration scheduleStart; // Hora de inicio de jornada
    private Duration scheduleEnd; // Hora de fin de jornada
    private transient List<Appointment> appointments; // Lista de citas asignadas (no serializable)

    /**
     * Constructor de la clase Employee.
     * Asigna un ID único automáticamente basado en los registros existentes.
     * 
     * @param salary         Salario
     * @param scheduleStart  Hora de inicio
     * @param scheduleEnd    Hora de fin
     * @param appointments   Lista de citas
     * @param fullname       Nombre completo
     * @param documentType   Tipo de documento
     * @param documentNumber Número de documento
     * @param phoneNumber    Teléfono
     * @param mailAddress    Correo
     */
    public Employee(double salary, Duration scheduleStart, Duration scheduleEnd, List<Appointment> appointments,
            String fullname, EnumDocType documentType, String documentNumber, String phoneNumber, String mailAddress) {
        // Llama al constructor de la clase base Person
        super(fullname, documentType, documentNumber, phoneNumber, mailAddress);

        // Obtengo la lista de empleados existentes
        List<Employee> employeeList = employeeRepositoryImpl.readAll();
        // Si la lista está vacía, asigno el ID 1. Si no, sumo 1 al último ID.
        this.id = employeeList.isEmpty() ? 1L : employeeList.get(employeeList.size() - 1).getId() + 1;

        // Asigno los valores recibidos a los atributos
        this.salary = salary;
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
        this.appointments = appointments;
    }

    // Getter para el ID
    public Long getId() {
        return id;
    }

    // Setter para el ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el salario
    public double getSalary() {
        return salary;
    }

    // Setter para el salario
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter para la hora de inicio
    public Duration getScheduleStart() {
        return scheduleStart;
    }

    // Setter para la hora de inicio
    public void setScheduleStart(Duration scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    // Getter para la hora de fin
    public Duration getScheduleEnd() {
        return scheduleEnd;
    }

    // Setter para la hora de fin
    public void setScheduleEnd(Duration scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    // Getter para la lista de citas
    public List<Appointment> getAppointments() {
        return appointments;
    }

    // Setter para la lista de citas
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Verifica si el empleado está disponible para una cita en un horario y fecha
     * dados.
     * 
     * @param startTime Hora de inicio propuesta
     * @param duration  Duración de la cita
     * @param date      Fecha de la cita
     * @return true si está disponible, false si hay conflicto
     */
    public boolean isEmployeeAvailable(Duration startTime, Duration duration, LocalDate date) {
        // Calcula la hora de fin de la cita propuesta
        Duration endTime = startTime.plusMinutes(duration.toMinutes());
        // Recorre todas las citas asignadas al empleado
        for (Appointment appointment : appointments) {
            // Si la cita es el mismo día
            if (appointment.getDate().equals(date)) {
                // Obtiene el rango horario de la cita existente
                Duration appointmentStartTime = appointment.getStartTime();
                Duration appointmentEndTime = appointmentStartTime.plus(appointment.getDurationAppointment());

                // Verifica si hay traslape de horarios
                if (startTime.compareTo(appointmentEndTime) < 0 && endTime.compareTo(appointmentStartTime) > 0) {
                    return false; // Hay conflicto
                }
            }
        }
        return true; // No hay conflicto
    }
}
