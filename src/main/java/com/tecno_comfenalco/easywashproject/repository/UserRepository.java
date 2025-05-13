/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository;

import com.tecno_comfenalco.easywashproject.models.User;
import java.util.List;

/**
 *
 * @author danil
 */
public interface UserRepository extends Repository<User, User> {

    @Override
    public User update(User k, User j);

    @Override
    public void delete(User k);

    @Override
    public List<User> readAll();

    @Override
    public User read(User k);

    @Override
    public User create(User k);

    public User findByCredentials(String username, String password);

}
