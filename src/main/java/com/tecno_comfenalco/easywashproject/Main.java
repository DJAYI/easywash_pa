/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tecno_comfenalco.easywashproject;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.UserRepositoryImpl;
import com.tecno_comfenalco.easywashproject.views.layouts.VistaPrincipal;

/**
 *
 * @author danil
 */
public class Main {

    public static void main(String[] args) {
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
        userRepositoryImpl.create(new User("admin", "admin", "Danilo Jose Arenas Yi", EnumDocType.CC, "1043321890", "123456789", "asd@mail.com"));

        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.setVisible(true);

    }
}
