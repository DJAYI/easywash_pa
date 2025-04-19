/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tecno_comfenalco.easywashproject;

import com.tecno_comfenalco.easywashproject.services.EmailNotificationService;

/**
 *
 * @author danil
 */
public class Main {

    public static void main(String[] args) {
        EmailNotificationService emailNotificationService = new EmailNotificationService();
        emailNotificationService.sendEmail("danilo.arenasyi@gmail.com", "prueba", "Saludos desde java");
    }
}
