/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository;

import com.tecno_comfenalco.easywashproject.models.Employee;
import java.util.List;

/**
 *
 * @author danil
 */
public interface EmployeeRepository extends Repository<Employee, Employee> {

    @Override
    public Employee update(Employee k, Employee j);

    @Override
    public void delete(Employee k);

    @Override
    public List<Employee> readAll();

    @Override
    public Employee read(Employee k);

    @Override
    public Employee create(Employee k);

    @Override
    public Employee findById(Long id);
}
