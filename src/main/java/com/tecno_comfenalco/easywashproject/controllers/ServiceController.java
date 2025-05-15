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
     * Crea un nuevo servicio usando JOptionPane para mostrar el resultado.
     * 
     * @param service Servicio a crear.
     * @return Servicio creado o null si falla.
     */
    public Service createService(Service service) {
        try {
            Service created = serviceRepository.create(service);
            if (created != null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Servicio creado exitosamente.");
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "No se pudo crear el servicio.");
            }
            return created;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al crear el servicio: " + e.getMessage());
            return null;
        }
    }

    /**
     * Busca un servicio por ID usando JOptionPane para mostrar el resultado.
     * 
     * @param id Identificador del servicio.
     * @return Servicio encontrado o null.
     */
    public Service findById(Long id) {
        try {
            Service found = serviceRepository.findById(id);
            if (found != null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Servicio encontrado: " + found.toString());
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
            }
            return found;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al buscar el servicio: " + e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene todos los servicios usando JOptionPane para mostrar el resultado.
     * 
     * @return Lista de servicios.
     */
    public List<Service> getAllServices() {
        try {
            List<Service> services = serviceRepository.readAll();
            javax.swing.JOptionPane.showMessageDialog(null, "Servicios encontrados: " + services.size());
            return services;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al obtener los servicios: " + e.getMessage());
            return null;
        }
    }

    // Otros métodos: eliminar, actualizar, buscar por nombre, etc.
}
