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
        return employeeRepository.create(employee);
    }

    /**
     * Busca un empleado por ID.
     * 
     * @param id Identificador del empleado.
     * @return Empleado encontrado o null.
     */
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    /**
     * Obtiene todos los empleados.
     * 
     * @return Lista de empleados.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.readAll();
    }

    // Otros métodos: eliminar, actualizar, buscar por documento, etc.
}
