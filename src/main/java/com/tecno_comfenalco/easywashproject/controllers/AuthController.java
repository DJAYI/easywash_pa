/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.repository.ClientRepository;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;

/**
 *
 * @author danil
 */
public class AuthController {
    private final ClientRepository clientRepository;
    
    public AuthController() {
        this.clientRepository = new ClientRepositoryImpl();
    }
    
    public boolean authenticate(String email, String documento) {
        //validacion basica de campos vacios
        if (email == null || email.isEmpty() || documento == null || documento.isEmpty()) {
            return false;
        }
        
        try {
            //Buscar cliente en el repositorio
            Client cliente = clientRepository.findByEmailAndDocument(email, documento);
            return cliente != null;
        } catch (Exception e) {
            System.err.println("Error en autenticacion: " + e.getMessage());
            return false;
        }
    }
}
