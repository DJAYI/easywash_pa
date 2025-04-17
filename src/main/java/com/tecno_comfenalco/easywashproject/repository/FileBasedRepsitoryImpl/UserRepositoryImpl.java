/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.User;
import com.tecno_comfenalco.easywashproject.repository.UserRepository;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<User> userList = readAll();

        for (int i = 0; i < userList.size(); i++) {
            if (k.getUsername().equals(userList.get(i).getUsername())) {
                userList.set(i, j);
                this.jsonFileRepository.save(userList);
                return j;
            }
        }
        return null;
    }

    @Override
    public void delete(User k) {
        List<User> userList = readAll();
        userList.remove(k);
        jsonFileRepository.save(userList);
    }

    @Override
    public List<User> readAll() {
        return this.jsonFileRepository.load();
    }

    @Override
    public User read(User k) {
        return this.jsonFileRepository.load()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(k.getUsername()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User create(User k) {
        List<User> userList = this.jsonFileRepository.load();
        Set<User> userSet = new HashSet<>(userList);
        userList.add(k);
        this.jsonFileRepository.save(userSet.stream().collect(Collectors.toList()));

        return k;
    }

}
