/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.UserRepositoryImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class AuthController {

    public boolean authenticate(String email, String documento) {
        //validacion basica de campos vacios
        if (email == null || email.isEmpty() || documento == null || documento.isEmpty()) {
            return false;
        }

        try {
            //Buscar cliente en el repositorio
            ClientRepositoryImpl clientRepositoryImpl = new ClientRepositoryImpl();
            Client cliente = clientRepositoryImpl.findByEmailAndDocument(email, documento);
            return cliente != null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente con email y documento solicitados no encontrado o datos incorrectos", "INVALID AUTHENTICATION", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean authenticateUser(String username, String password) {
        if (username.isBlank() || password.isBlank()) {
            return false;
        }

        try {
            UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
            User user = userRepositoryImpl.findByCredentials(username, password);

            return user != null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario con numbre de usuario y contraseña solicitados no encontrado o datos incorrectos", "INVALID AUTHENTICATION", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
