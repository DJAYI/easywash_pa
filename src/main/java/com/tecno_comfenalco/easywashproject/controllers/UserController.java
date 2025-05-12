/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.AppointmentRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.EmployeeRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.UserRepositoryImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class UserController {
    public void create(User user) {
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
        
        try {
            userRepositoryImpl.create(user);
            JOptionPane.showMessageDialog(null, "Usuario exitosamente creado", "Usuario creado", JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al crear al usuario", "Error usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void remove(User user) {
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
        
        try {
            userRepositoryImpl.delete(user);
            JOptionPane.showMessageDialog(null, "Usuario exitosamente eliminado", "Usuario eliminada", JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar al usuario", "Error empleado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modify(User userToModify, User userModified) {
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
        
        try {
            userRepositoryImpl.update(userToModify, userModified);
            JOptionPane.showMessageDialog(null, "Usuario exitosamente actualizado", "Usuario actualizado", JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar al usuario", "Error usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
}
