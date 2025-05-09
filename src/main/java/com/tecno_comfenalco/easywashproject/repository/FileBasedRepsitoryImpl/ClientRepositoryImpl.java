/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.repository.ClientRepository;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author danil
 */
public class ClientRepositoryImpl implements ClientRepository {

    private final JsonFileRepository<Client> jsonFileRepository;

    public ClientRepositoryImpl() {
        Type listType = new TypeToken<List<Client>>() {
        }.getType();

        this.jsonFileRepository = new JsonFileRepository<Client>("clients.json", listType, List.of());
    }

    @Override
    public Client update(Client k, Client j) {
        try {
            List<Client> clients = jsonFileRepository.load();

            for (int i = 0; i < clients.size(); i++) {
                if (k.getDocumentNumber().equals(clients.get(i).getDocumentNumber())) {
                    clients.set(i, j);
                    return j;
                }
            }

            return null;

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al realizar la modificación del cliente");
            return null;
        }
    }

    @Override
    public void delete(Client k) {
        try {
            List<Client> clients = jsonFileRepository.load();
            clients.remove(k);
            jsonFileRepository.save(clients);

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al intentar eliminar al cliente");
        }
    }

    @Override
    public List<Client> readAll() {
        try {
            return jsonFileRepository.load();
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la información de los clientes");
            return null;
        }
    }

    @Override
    public Client read(Client k) {
        try {
            return jsonFileRepository.load().stream().filter((t) -> t.getDocumentNumber().equals(k.getDocumentNumber())).findFirst().orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar al cliente solicitado");
            return null;
        }
    }

    @Override
    public Client create(Client k) {
        try {
            List<Client> clients = jsonFileRepository.load();
            clients.add(k);
            jsonFileRepository.save(clients);
            return k;
        } catch (Exception e) {
            System.out.println("No se ha podido insertar un nuevo cliente");
            return null;
        }

    }
    
    @Override
    public Client findByEmailAndDocument(String email, String document){
        try{
            //Cargar todos los clientes desde el archivo json
            List<Client> clients = jsonFileRepository.load();
            return clients.stream()
                    .filter(client -> client.getMailAddress().equalsIgnoreCase(email)
                    && client.getDocumentNumber().equals(document))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.err.println("Error al buscar cliente por email y documento: " + e.getMessage());
            return null;
        }    
    }  
    
    @Override
    public Client findByEmail(String email) {
        try{
            List<Client> clients = jsonFileRepository.load();
            return clients.stream()
                    .filter(client -> client.getMailAddress().equalsIgnoreCase(email))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.err.println("Error al buscar cliente por email: " + e.getMessage());
            return null;
        }
    }
}
            
        
    


