/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository;

import com.tecno_comfenalco.easywashproject.models.Client;
import java.util.List;
/**
 *
 * @author danil
 */
public interface ClientRepository extends Repository<Client, Client>{

    @Override
    public Client update(Client k);

    @Override
    public void delete(Client k);

    @Override
    public List<Client> readAll();

    @Override
    public Client read(Client k);

    @Override
    public Client create(Client k);
    
}
