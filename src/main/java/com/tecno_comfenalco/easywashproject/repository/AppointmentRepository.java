/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository;

import com.tecno_comfenalco.easywashproject.models.Appointment;
import java.util.List;
/**
 *
 * @author danil
 */
public interface AppointmentRepository extends Repository<Appointment, Appointment>{

    @Override
    public Appointment update(Appointment k, Appointment j);

    @Override
    public void delete(Appointment k);

    @Override
    public List<Appointment> readAll();

    @Override
    public Appointment read(Appointment k);

    @Override
    public Appointment create(Appointment k);
    
}
