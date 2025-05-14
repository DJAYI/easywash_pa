/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.AppointmentRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.EmployeeRepositoryImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class EmployeeController {
    public void create(Employee employee) {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();

        try {
            employeeRepositoryImpl.create(employee);
            JOptionPane.showMessageDialog(null, "Empleado exitosamente creado", "Empleado creado",
                    JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al crear al empleado", "Error empleado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void remove(Long id) {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
        Employee employee = employeeRepositoryImpl.findById(id);

        try {
            employeeRepositoryImpl.delete(employee);
            JOptionPane.showMessageDialog(null, "Empleado exitosamente eliminado", "Empleado eliminada",
                    JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar al empleado", "Error empleado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modify(Long id, Employee employeeModified) {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
        Employee employee = employeeRepositoryImpl.findById(id);

        try {
            employeeRepositoryImpl.update(employee, employeeModified);
            JOptionPane.showMessageDialog(null, "Empleado exitosamente actualizado", "Empleado actualizado",
                    JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar al empleado", "Error empleado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
