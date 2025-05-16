package com.tecno_comfenalco.easywashproject.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.tecno_comfenalco.easywashproject.enums.EnumAppointmentStatus;
import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.models.Vehicle;

public class AppointmentBookingService {

    private List<Employee> employees;

    public AppointmentBookingService(List<Employee> employees) {
        this.employees = employees;
    }

    public Appointment bookingAppointment(LocalDate date, LocalTime startTime, List<Service> services, Client client,
            Vehicle vehicle) {
        Appointment appointment = new Appointment(services, client, null, null, date, startTime, vehicle);
        Employee assignedEmployee = SchedulerService.assignEmployee(employees, date, startTime, appointment);

        if (assignedEmployee != null) {
            appointment.setEmployee(assignedEmployee);
            appointment.setStatus(EnumAppointmentStatus.PENDIENTE);

            assignedEmployee.getAppointments().add(appointment);

            System.out.println("Cita asignada a " + assignedEmployee.getFullname() + " a las "
                    + startTime);

            return appointment;
        } else {
            System.out.println("No hay empleados disponibles para este horario.");
            return null;
        }
    }
}
