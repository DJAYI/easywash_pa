/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository;
import com.tecno_comfenalco.easywashproject.models.Service;
import java.util.List;
/**
 *
 * @author danil
 */
public interface ServiceRepository extends Repository<Service, Service>{

    @Override
    public Service update(Service k, Service j);

    @Override
    public void delete(Service k);

    @Override
    public List<Service> readAll();

    @Override
    public Service read(Service k);

    @Override
    public Service create(Service k);
    
}
