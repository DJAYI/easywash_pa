/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.repository.ClientRepository;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;

/**
 *
 * @author danil
 */
public class ClientController {
    private final ClientRepository clientRepository;
    
    public ClientController() {
        this.clientRepository = new ClientRepositoryImpl();
    }
    
    public boolean registerClient(String nombre, String tipoDoc, String documento, String telefono, String correo) {
        //Validacion basica de campos obligatorios
        if (nombre == null || nombre.isEmpty() || documento == null || documento.isEmpty()){ 
            return false;
        }
        
        try {
            //Convertir String a EnumDocType
            EnumDocType docType = EnumDocType.fromDescripcion(tipoDoc.toUpperCase());
            
            //Crear nuevo cliente 
            Client newClient = new Client(null, nombre, docType, documento, telefono, correo);
            
            //Guardar en el repositorio
            return clientRepository.create(newClient) != null;
        } catch (IllegalArgumentException e) {
            System.err.println("Tipo de documento invalido: " + tipoDoc);
            return false;
        } catch (Exception e) {
            System.err.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }
    
    //Metodo adicional para buscar cliente por email
    public Client findClientByEmail(String email) {
        if (email == null || email.isEmpty()) {
            System.err.println("Email no puede estar vacio");
            return null;
        }
        return clientRepository.findByEmail(email);
    }
}
