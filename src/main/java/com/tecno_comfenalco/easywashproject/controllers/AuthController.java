/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Person;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.UserRepositoryImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class AuthController {

    private Person session;
    private final ClientRepositoryImpl clientRepository;
    private final UserRepositoryImpl userRepository;

    public AuthController() {
        this.clientRepository = new ClientRepositoryImpl();
        this.userRepository = new UserRepositoryImpl();
    }

    public Person getSession() {
        return session;
    }

    public void setSession(Person session) {
        this.session = session;
    }

    private boolean isNullOrBlank(String... values) {
        for (String value : values) {
            if (value == null || value.isBlank()) {
                return true;
            }
        }
        return false;
    }

    public boolean authenticateClient(String email, String documento) {
        if (isNullOrBlank(email, documento)) {
            return false;
        }

        try {
            Client client = clientRepository.findByEmailAndDocument(email, documento);
            if (client != null) {
                setSession(client);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,
                "Cliente no encontrado o datos incorrectos",
                "INVALID AUTHENTICATION",
                JOptionPane.ERROR_MESSAGE);

        return false;
    }

    public boolean authenticateUser(String username, String password) {
        if (isNullOrBlank(username, password)) {
            JOptionPane.showMessageDialog(null,
                    "Los campos son obligatorios",
                    "INVALID AUTHENTICATION",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            User user = userRepository.findByCredentials(username, password);
            if (user != null) {
                setSession(user);
                JOptionPane.showMessageDialog(null,
                        "Autenticación exitosa",
                        "Autenticado",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,
                "Usuario no encontrado o datos incorrectos",
                "INVALID AUTHENTICATION",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
