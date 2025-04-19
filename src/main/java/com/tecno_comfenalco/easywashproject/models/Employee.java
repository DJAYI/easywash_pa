/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author danil
 */
public class Employee extends Person {

    private double salary;
    private LocalTime scheduleStart;
    private LocalTime scheduleEnd;
    private transient ArrayList<Appointment> appointments;

    public Employee(double salary, LocalTime scheduleStart, LocalTime scheduleEnd, ArrayList<Appointment> appointments, String fullname, EnumDocType documentType, String documentNumber, String phoneNumber, String mailAddress) {
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

    public LocalTime getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(LocalTime scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public LocalTime getScheduleEnd() {
        return scheduleEnd;
    }

    public void setScheduleEnd(LocalTime scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    private boolean isEmployeeAvailable(LocalTime startTime, LocalTime duration, LocalDate date) {
        LocalTime endTime = startTime.plusMinutes(duration.getMinute());
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                LocalTime appointmentStartTime = appointment.getStartTime();
                LocalTime appointmentEndTime = appointmentStartTime.plusMinutes(appointment.getDurationAppointment().getMinute());

                if (startTime.isBefore(appointmentEndTime) && endTime.isAfter(appointmentStartTime)) {
                    return false;
                }
            }
        }

        return true;
    }
}
