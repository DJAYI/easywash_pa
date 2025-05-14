/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.AppointmentRepositoryImpl;
import com.tecno_comfenalco.easywashproject.services.AppointmentBookingService;

/**
 * Controlador para la gestión de citas.
 * Utiliza AppointmentBookingService para la lógica de negocio y el repositorio
 * para persistencia.
 */
public class AppointmentController {
    private final AppointmentBookingService bookingService;
    private final AppointmentRepositoryImpl appointmentRepository;

    /**
     * Constructor que recibe la lista de empleados y crea los servicios necesarios.
     * 
     * @param employees Lista de empleados disponibles para asignación de citas.
     */
    public AppointmentController(List<Employee> employees) {
        this.bookingService = new AppointmentBookingService(employees);
        this.appointmentRepository = new AppointmentRepositoryImpl();
    }

    /**
     * Agenda una nueva cita y la persiste si es posible.
     * 
     * @param date      Fecha de la cita.
     * @param startTime Hora de inicio de la cita.
     * @param services  Lista de servicios a realizar.
     * @param client    Cliente que solicita la cita.
     * @return La cita creada o null si no fue posible agendarla.
     */
    public Appointment bookAppointment(LocalDate date, LocalTime startTime, List<Service> services, Client client) {
        // Usa el servicio para agendar la cita y asignar un empleado disponible
        Appointment appointment = bookingService.bookingAppointment(date, startTime, services, client);
        if (appointment != null) {
            // Persiste la cita en el repositorio
            appointmentRepository.create(appointment);
        }
        return appointment;
    }

    /**
     * Obtiene todas las citas registradas.
     * 
     * @return Lista de citas.
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.readAll();
    }

    /**
     * Busca una cita por su ID.
     * 
     * @param id Identificador de la cita.
     * @return La cita encontrada o null si no existe.
     */
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Puedes agregar más métodos según las necesidades del sistema (cancelar cita,
    // actualizar, etc.)
}
