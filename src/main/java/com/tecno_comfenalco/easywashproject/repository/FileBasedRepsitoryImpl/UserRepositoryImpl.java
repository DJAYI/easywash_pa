/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.UserRepository;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            List<User> userList = readAll();

            for (int i = 0; i < userList.size(); i++) {
                if (k.getUsername().equals(userList.get(i).getUsername())) {
                    userList.set(i, j);
                    this.jsonFileRepository.save(userList);
                    return j;
                }
            }
            return null;

        } catch (Exception e) {
            System.out.println("No se ha podido modificar la información del usuario solicitado");
            return null;
        }

    }

    @Override
    public void delete(User k) {
        try {
            List<User> userList = readAll();
            userList.remove(k);
            jsonFileRepository.save(userList);

        } catch (Exception e) {
            System.out.println("No se ha podido eliminar al usuario solicitado");
        }
    }

    @Override
    public List<User> readAll() {
        try {
            return this.jsonFileRepository.load();

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información de los usuarios");
            return null;
        }
    }

    @Override
    public User read(User k) {
        try {
            return this.jsonFileRepository.load()
                    .stream()
                    .filter(user -> user.getUsername().equalsIgnoreCase(k.getUsername()))
                    .findFirst()
                    .orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información del usuario solicitado");
            return null;
        }
    }

    @Override
    public User create(User k) {
        try {
            List<User> userList = this.jsonFileRepository.load();
            Set<User> userSet = new HashSet<>(userList);

            userSet.add(k); // Agregar el nuevo usuario al set (evita duplicados automáticamente)

            this.jsonFileRepository.save(new ArrayList<>(userSet));

            return k;

        } catch (Exception e) {
            System.out.println("No se ha podido insertar al usuario al sistema");
            return null;
        }

    }

    @Override
    public User findByCredentials(String username, String password) {
        try {
            return this.jsonFileRepository.load()
                    .stream()
                    .filter(user -> user.getUsername().equalsIgnoreCase(username)
                            && user.getPassword().equalsIgnoreCase(password))
                    .findFirst()
                    .orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información del usuario solicitado");
            return null;
        }
    }

    @Override
    public User findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
