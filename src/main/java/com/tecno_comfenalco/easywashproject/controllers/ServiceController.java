package com.tecno_comfenalco.easywashproject.controllers;

import java.util.List;

import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;

/**
 * Controlador para la gestión de servicios.
 * Utiliza ServiceRepositoryImpl para la persistencia.
 */
public class ServiceController {

    private final ServiceRepositoryImpl serviceRepository;

    public ServiceController() {
        this.serviceRepository = new ServiceRepositoryImpl();
    }

    /**
     * Crea un nuevo servicio.
     * 
     * @param service Servicio a crear.
     * @return Servicio creado o null si falla.
     */
    public Service createService(Service service) {
        return serviceRepository.create(service);
    }

    /**
     * Busca un servicio por ID.
     * 
     * @param id Identificador del servicio.
     * @return Servicio encontrado o null.
     */
    public Service findById(Long id) {
        return serviceRepository.findById(id);
    }

    /**
     * Obtiene todos los servicios.
     * 
     * @return Lista de servicios.
     */
    public List<Service> getAllServices() {
        return serviceRepository.readAll();
    }

    // Otros métodos: eliminar, actualizar, buscar por nombre, etc.
}
