/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import java.util.List;

import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.EmployeeRepositoryImpl;

/**
 * Controlador para la gestión de empleados.
 * Utiliza EmployeeRepositoryImpl para la persistencia.
 */
public class EmployeeController {

    private final EmployeeRepositoryImpl employeeRepository;

    public EmployeeController() {
        this.employeeRepository = new EmployeeRepositoryImpl();
    }

    /**
     * Crea un nuevo empleado.
     * 
     * @param employee Empleado a crear.
     * @return Empleado creado o null si falla.
     */
    public Employee createEmployee(Employee employee) {
        try {
            Employee created = employeeRepository.create(employee);
            javax.swing.JOptionPane.showMessageDialog(null, "Empleado creado exitosamente.", "Éxito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return created;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al crear empleado: " + e.getMessage(), "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Busca un empleado por ID.
     * 
     * @param id Identificador del empleado.
     * @return Empleado encontrado o null.
     */
    public Employee findById(Long id) {
        try {
            Employee found = employeeRepository.findById(id);
            if (found != null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Empleado encontrado exitosamente.", "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Empleado no encontrado.", "Información",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            return found;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + e.getMessage(), "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Obtiene todos los empleados.
     * 
     * @return Lista de empleados.
     */
    public List<Employee> getAllEmployees() {
        try {
            List<Employee> employees = employeeRepository.readAll();
            javax.swing.JOptionPane.showMessageDialog(null, "Empleados obtenidos exitosamente.", "Éxito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return employees;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al obtener empleados: " + e.getMessage(), "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return java.util.Collections.emptyList();
        }
    }

    // Otros métodos: eliminar, actualizar, buscar por documento, etc.
}
