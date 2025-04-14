/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository;

import com.tecno_comfenalco.easywashproject.models.Vehicle;
import java.util.List;

/**
 *
 * @author danil
 */
public interface VehicleRepository extends Repository<Vehicle, Vehicle>{

    @Override
    public Vehicle update(Vehicle k, Vehicle j);

    @Override
    public void delete(Vehicle k);

    @Override
    public List<Vehicle> readAll();

    @Override
    public Vehicle read(Vehicle k);

    @Override
    public Vehicle create(Vehicle k);
    
}
