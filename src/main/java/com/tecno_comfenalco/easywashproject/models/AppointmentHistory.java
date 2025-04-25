/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import com.tecno_comfenalco.easywashproject.repository.AppointmentRepository;
import java.util.List;

/**
 *
 * @author danil
 */
public class AppointmentHistory {

    List<Appointment> appointments;
    private final AppointmentRepository appointmentRepository;

    public AppointmentHistory(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointmentRepository.readAll();
    }

}
