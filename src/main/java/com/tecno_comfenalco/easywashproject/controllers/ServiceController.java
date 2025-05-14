/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class ServiceController {
    public void create(Service service) {
        ServiceRepositoryImpl serviceRepositoryImpl = new ServiceRepositoryImpl();

        try {
            serviceRepositoryImpl.create(service);
            JOptionPane.showMessageDialog(null, "Servicio exitosamente creado", "Servicio creado",
                    JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al crear el servicio", "Error servicio",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void remove(Long id) {
        ServiceRepositoryImpl serviceRepositoryImpl = new ServiceRepositoryImpl();
        Service service = serviceRepositoryImpl.findById(id);

        try {
            serviceRepositoryImpl.delete(service);
            JOptionPane.showMessageDialog(null, "Servicio exitosamente eliminado", "Servicio eliminada",
                    JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar al servicio", "Error servicio",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modify(Long id, Service serviceModified) {
        ServiceRepositoryImpl serviceRepositoryImpl = new ServiceRepositoryImpl();
        Service service = serviceRepositoryImpl.findById(id);

        try {
            serviceRepositoryImpl.update(service, serviceModified);
            JOptionPane.showMessageDialog(null, "Servicio exitosamente actualizado", "Servicio actualizado",
                    JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar al servicio", "Error servicio",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
