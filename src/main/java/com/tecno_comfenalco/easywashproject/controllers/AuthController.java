/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import javax.swing.JOptionPane;

import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.UserRepositoryImpl;

/**
 *
 * @author danil
 */
public class AuthController {

    // Instancia singleton
    private static AuthController instance;

    private String session;
    private final ClientRepositoryImpl clientRepository;
    private final UserRepositoryImpl userRepository;

    // Constructor privado para singleton
    private AuthController() {
        this.clientRepository = new ClientRepositoryImpl();
        this.userRepository = new UserRepositoryImpl();
    }

    // Método para obtener la instancia singleton
    public static AuthController getInstance() {
        if (instance == null) {
            instance = new AuthController();
        }
        return instance;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
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
                setSession(client.getDocumentNumber());
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
                setSession(user.getDocumentNumber());
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
