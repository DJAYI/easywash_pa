/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import java.util.List;

import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.UserRepositoryImpl;

/**
 * Controlador para la gestión de usuarios.
 * Utiliza UserRepositoryImpl para la persistencia.
 */
public class UserController {

    private final UserRepositoryImpl userRepository;

    public UserController() {
        this.userRepository = new UserRepositoryImpl();
    }

    /**
     * Crea un nuevo usuario.
     * 
     * @param user Usuario a crear.
     * @return Usuario creado o null si falla.
     */
    public User createUser(User user) {
        return userRepository.create(user);
    }

    /**
     * Busca un usuario por credenciales.
     * 
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @return Usuario encontrado o null.
     */
    public User findByCredentials(String username, String password) {
        return userRepository.findByCredentials(username, password);
    }

    /**
     * Obtiene todos los usuarios.
     * 
     * @return Lista de usuarios.
     */
    public List<User> getAllUsers() {
        return userRepository.readAll();
    }

    // Otros métodos: eliminar, actualizar, buscar por ID, etc.
}
