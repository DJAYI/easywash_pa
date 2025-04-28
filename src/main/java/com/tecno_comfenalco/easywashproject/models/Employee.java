/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;

/**
 *
 * @author danil
 */
public class Employee extends Person {

    private double salary;
    private Duration scheduleStart;
    private Duration scheduleEnd;
    private transient List<Appointment> appointments;

    public Employee(double salary, Duration scheduleStart, Duration scheduleEnd, List<Appointment> appointments,
            String fullname, EnumDocType documentType, String documentNumber, String phoneNumber, String mailAddress) {
        super(fullname, documentType, documentNumber, phoneNumber, mailAddress);
        this.salary = salary;
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
        this.appointments = appointments;

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Duration getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(Duration scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public Duration getScheduleEnd() {
        return scheduleEnd;
    }

    public void setScheduleEnd(Duration scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public boolean isEmployeeAvailable(Duration startTime, Duration duration, LocalDate date) {
        Duration endTime = startTime.plusMinutes(duration.toMinutes());
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                Duration appointmentStartTime = appointment.getStartTime();
                Duration appointmentEndTime = appointmentStartTime.plus(appointment.getDurationAppointment());

                if (startTime.compareTo(appointmentEndTime) < 0 && endTime.compareTo(appointmentStartTime) > 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
