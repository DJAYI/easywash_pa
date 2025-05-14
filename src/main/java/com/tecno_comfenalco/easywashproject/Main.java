/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tecno_comfenalco.easywashproject;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.enums.EnumVehicleType;
import com.tecno_comfenalco.easywashproject.enums.EnumAppointmentStatus;
import com.tecno_comfenalco.easywashproject.models.*;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author danil
 */
public class Main {

    public static void main(String[] args) {
        // Crear y guardar una marca de vehículo
        VehicleBrand brand = new VehicleBrand("Mazda", "Marca japonesa");

        // Crear y guardar un vehículo
        Vehicle vehicle = new Vehicle("3", brand, "ABC123", "Rojo", EnumVehicleType.CARRO);
        VehicleRepositoryImpl vehicleRepo = new VehicleRepositoryImpl();
        vehicleRepo.create(vehicle);

        // Crear y guardar un cliente
        Client client = new Client(vehicle, "Juan Perez", EnumDocType.CC, "123456", "555-1234", "juan@mail.com");
        ClientRepositoryImpl clientRepo = new ClientRepositoryImpl();
        clientRepo.create(client);

        // Crear y guardar un servicio
        Service service = new Service("Lavado Básico", 20000, "Lavado exterior e interior", Duration.ofMinutes(30));
        ServiceRepositoryImpl serviceRepo = new ServiceRepositoryImpl();
        serviceRepo.create(service);

        // Crear y guardar un empleado
        Employee employee = new Employee(1500000, Duration.ofHours(8), Duration.ofHours(17), List.of(),
                "Ana Lopez", EnumDocType.CC, "654321", "555-5678", "ana@mail.com");
        EmployeeRepositoryImpl employeeRepo = new EmployeeRepositoryImpl();
        employeeRepo.create(employee);

        // Crear y guardar una cita
        Appointment appointment = new Appointment(
                List.of(service),
                client,
                employee,
                EnumAppointmentStatus.PENDIENTE,
                LocalDate.now(),
                Duration.ofHours(10));
        AppointmentRepositoryImpl appointmentRepo = new AppointmentRepositoryImpl();
        appointmentRepo.create(appointment);

        System.out.println("Datos de prueba creados y guardados.");
    }
}
