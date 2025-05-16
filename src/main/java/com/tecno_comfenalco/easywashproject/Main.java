/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tecno_comfenalco.easywashproject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.tecno_comfenalco.easywashproject.enums.EnumAppointmentStatus;
import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.enums.EnumVehicleType;
import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.models.Vehicle;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.AppointmentRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.EmployeeRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.UserRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.VehicleRepositoryImpl;
import com.tecno_comfenalco.easywashproject.views.layouts.VistaPrincipal;

/**
 *
 * @author danil
 */
public class Main {

        public static void main(String[] args) {

                // Crear y guardar un vehículo solo si no existe
                VehicleRepositoryImpl vehicleRepo = new VehicleRepositoryImpl();
                Vehicle vehicle = vehicleRepo.findById(1L);
                if (vehicle == null) {
                        vehicle = new Vehicle("3", "Mazda", "ABC123", "Rojo", EnumVehicleType.CARRO);
                        vehicleRepo.create(vehicle);
                }

                // Crear y guardar un cliente solo si no existe
                ClientRepositoryImpl clientRepo = new ClientRepositoryImpl();
                Client client = clientRepo.findById(1L);
                if (client == null) {
                        client = new Client(vehicle, "Juan Perez", EnumDocType.CC, "123456", "555-1234",
                                        "juan@mail.com");
                        clientRepo.create(client);
                }

                // Crear y guardar un servicio solo si no existe
                ServiceRepositoryImpl serviceRepo = new ServiceRepositoryImpl();
                Service service = serviceRepo.findById(1L);
                if (service == null) {
                        service = new Service("Lavado Básico", 20000, "Lavado exterior e interior",
                                        Duration.ofMinutes(30));
                        serviceRepo.create(service);
                }

                // Crear y guardar un empleado solo si no existe
                EmployeeRepositoryImpl employeeRepo = new EmployeeRepositoryImpl();
                Employee employee = employeeRepo.findById(1L);
                if (employee == null) {
                        employee = new Employee(1500000, Duration.ofHours(8), Duration.ofHours(17), List.of(),
                                        "Ana Lopez", EnumDocType.CC, "654321", "555-5678", "ana@mail.com");
                        employeeRepo.create(employee);
                }

                // Crear y guardar una cita solo si no existe
                AppointmentRepositoryImpl appointmentRepo = new AppointmentRepositoryImpl();
                Appointment appointment = appointmentRepo.findById(1L);
                if (appointment == null) {
                        appointment = new Appointment(
                                        List.of(service),
                                        client,
                                        employee,
                                        EnumAppointmentStatus.PENDIENTE,
                                        LocalDate.now(),
                                        LocalTime.of(10, 0), vehicle);
                        appointmentRepo.create(appointment);
                }

                appointmentRepo.readAll().forEach(System.out::println);

                // Crear y guardar un usuario solo si no existe
                UserRepositoryImpl userRepo = new UserRepositoryImpl();
                User user = userRepo.findByCredentials("admin", "password123");
                if (user == null) {
                        user = new User("admin", "password123", "Danilo Arenas", EnumDocType.CC, "987654", "555-8765",
                                        "admin@mail.com");
                        userRepo.create(user);
                }

                // Vista principal
                VistaPrincipal vistaPrincipal = new VistaPrincipal();
                vistaPrincipal.setVisible(true);

                System.out.println("Datos de prueba creados y guardados.");
        }
}
