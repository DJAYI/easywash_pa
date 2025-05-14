package com.tecno_comfenalco.easywashproject.services;

import com.tecno_comfenalco.easywashproject.enums.EnumAppointmentStatus;
import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.models.Service;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class AppointmentBookingService {

    private List<Employee> employees;

    public AppointmentBookingService(List<Employee> employees) {
        this.employees = employees;
    }

    public Appointment bookingAppointment(LocalDate date, Duration startTime, List<Service> services, Client client) {
        Appointment appointment = new Appointment(services, null, null, null, date, startTime);
        Employee assignedEmployee = SchedulerService.assignEmployee(employees, date, startTime, appointment);

        if (assignedEmployee != null) {

            appointment.setClient(client);
            appointment.setEmployee(assignedEmployee);
            appointment.setStatus(EnumAppointmentStatus.PENDIENTE);

            assignedEmployee.getAppointments().add(appointment);

            System.out.println("Cita asignada a " + assignedEmployee.getFullname() + " a las "
                    + startTime.toMinutes() / 60 + ":" + startTime.toMinutes() % 60);

            return appointment;
        } else {
            System.out.println("No hay empleados disponibles para este horario.");
            return null;
        }
    }
}
