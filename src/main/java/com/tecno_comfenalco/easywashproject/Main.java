/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tecno_comfenalco.easywashproject;

import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;
import java.time.Duration;

/**
 *
 * @author danil
 */
public class Main {

    public static void main(String[] args) {
        //EmailNotificationService emailNotificationService = new EmailNotificationService();
        //emailNotificationService.sendEmail("danilo.arenasyi@gmail.com", "prueba", "Saludos desde java");

        ServiceRepositoryImpl serviceRepositoryImpl = new ServiceRepositoryImpl();

        Service servicio1 = new Service("LAVADO", 1000000.00, "SERVICIO 1", Duration.ofMinutes(10));
        Service servicioGuardado = serviceRepositoryImpl.create(servicio1);

        System.out.println("Servicio guardado: " + servicioGuardado.toString());
    }
}
