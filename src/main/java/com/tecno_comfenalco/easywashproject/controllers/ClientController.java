/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import java.util.List;

import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;

/**
 * Controlador para la gestión de clientes.
 * Utiliza ClientRepositoryImpl para la persistencia.
 */
public class ClientController {

    private final ClientRepositoryImpl clientRepository;

    public ClientController() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    /**
     * Crea un nuevo cliente.
     * 
     * @param client Cliente a crear.
     * @return Cliente creado o null si falla.
     */
    public Client createClient(Client client) {
        return clientRepository.create(client);
    }

    /**
     * Busca un cliente por ID.
     * 
     * @param id Identificador del cliente.
     * @return Cliente encontrado o null.
     */
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }

    /**
     * Obtiene todos los clientes.
     * 
     * @return Lista de clientes.
     */
    public List<Client> getAllClients() {
        return clientRepository.readAll();
    }

    // Otros métodos: eliminar, actualizar, buscar por documento, etc.
}
