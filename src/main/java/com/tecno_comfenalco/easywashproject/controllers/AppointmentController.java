/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.AppointmentRepositoryImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class AppointmentController {
    public void create(Appointment appointment) {
        AppointmentRepositoryImpl appointmentRepositoryImpl = new AppointmentRepositoryImpl();
        
        try {
            appointmentRepositoryImpl.create(appointment);
            JOptionPane.showMessageDialog(null, "Cita exitosamente agendada", "Cita agendada", JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al agendar la cita", "Error cita", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void remove(Appointment appointment) {
        AppointmentRepositoryImpl appointmentRepositoryImpl = new AppointmentRepositoryImpl();
        
        try {
            appointmentRepositoryImpl.delete(appointment);
            JOptionPane.showMessageDialog(null, "Cita exitosamente eliminada", "Cita eliminada", JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar la cita", "Error cita", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modify(Appointment appointmentToModify, Appointment appointmentModified) {
        AppointmentRepositoryImpl appointmentRepositoryImpl = new AppointmentRepositoryImpl();
        
        try {
            appointmentRepositoryImpl.update(appointmentToModify, appointmentModified);
            JOptionPane.showMessageDialog(null, "Cita exitosamente actualizada", "Cita actualizada", JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar la cita", "Error cita", JOptionPane.ERROR_MESSAGE);
        }
    }
}
