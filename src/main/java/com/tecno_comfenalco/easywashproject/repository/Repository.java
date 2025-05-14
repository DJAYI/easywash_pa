/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository;

import java.util.List;

/**
 *
 * @author danil
 */
public interface Repository<T, K> {

    public T create(K k);

    public T read(K k);

    public List<T> readAll();

    public void delete(K k);

    public T update(K k, K j);

    public T findById(Long id);
}
