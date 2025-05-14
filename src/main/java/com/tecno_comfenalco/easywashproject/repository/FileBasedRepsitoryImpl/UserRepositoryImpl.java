/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.UserRepository;

/**
 *
 * @author danil
 */
public class UserRepositoryImpl implements UserRepository {

    private final JsonFileRepository<User> jsonFileRepository;

    public UserRepositoryImpl() {
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        this.jsonFileRepository = new JsonFileRepository<>("users.json", listType, List.of());
    }

    @Override
    public User update(User k, User j) {
        try {
            List<User> users = jsonFileRepository.load();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).equals(k)) {
                    users.set(i, j);
                    jsonFileRepository.save(users);
                    return j;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido modificar el usuario");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(User k) {
        try {
            List<User> users = jsonFileRepository.load();
            users.remove(k);
            jsonFileRepository.save(users);
        } catch (Exception e) {
            System.out.println("No se ha podido eliminar el usuario");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> readAll() {
        try {
            List<User> users = jsonFileRepository.load();
            if (users == null) {
                return java.util.Collections.emptyList();
            }
            users.removeIf(u -> !(u instanceof User));
            return users;
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información de los usuarios");
            System.out.println(e.getMessage());
            return java.util.Collections.emptyList();
        }
    }

    @Override
    public User read(User k) {
        try {
            List<User> users = readAll();
            if (users == null || users.isEmpty()) {
                return null;
            }
            if (k.getUsername() != null) {
                return users.stream()
                        .filter(u -> u.getUsername().equals(k.getUsername()))
                        .findFirst()
                        .orElse(null);
            }
            return null;
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el usuario");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User create(User k) {
        try {
            List<User> users = readAll();
            if (users == null) {
                users = new java.util.ArrayList<>();
            }
            users.add(k);
            jsonFileRepository.save(users);
            return k;
        } catch (Exception e) {
            System.out.println("No se ha podido crear el usuario");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User findById(Long id) {
        try {
            List<User> users = readAll();
            if (users == null || users.isEmpty()) {
                return null;
            }
            return users.stream()
                    .filter(u -> u.getUsername().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el usuario por id");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User findByCredentials(String username, String password) {
        try {
            List<User> users = readAll();
            if (users == null || users.isEmpty()) {
                return null;
            }
            return users.stream()
                    .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el usuario por credenciales");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
