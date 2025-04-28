package com.tecno_comfenalco.easywashproject.services;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Employee;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danil
 */
public class SchedulerService {
    public static Employee assignEmployee(List<Employee> employees, LocalDate date, Duration time,
            Appointment appointment) {
        LocalDate appointmentDate = appointment.getDate();
        Duration startTime = appointment.getStartTime();
        Duration totalDuration = appointment.getDurationAppointment();

        for (Employee employee : employees) {
            if (employee.isEmployeeAvailable(startTime, totalDuration, appointmentDate)) {
                return employee;
            }
        }
        return null;
    }
}
