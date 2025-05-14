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
public interface ClientRepository extends Repository<Client, Client> {

    Client findByEmail(String email);

    Client findByEmailAndDocument(String email, String document);

    @Override
    public Client update(Client k, Client j);

    @Override
    public void delete(Client k);

    @Override
    public List<Client> readAll();

    @Override
    public Client read(Client k);

    @Override
    public Client create(Client k);

    @Override
    public Client findById(Long id);

}
