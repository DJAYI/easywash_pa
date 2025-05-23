/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl;

import com.google.gson.reflect.TypeToken;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.repository.ClientRepository;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                    jsonFileRepository.save(clients);
                    System.out.println("Cliente actualizado correctamente");
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
            return jsonFileRepository.load().stream().filter((t) -> t.getDocumentNumber().equals(k.getDocumentNumber()))
                    .findFirst().orElse(null);

        } catch (Exception e) {
            System.out.println("No se ha podido recuperar al cliente solicitado");
            return null;
        }
    }

    @Override
    public Client create(Client k) {
        try {
            List<Client> clients = jsonFileRepository.load();
            Set<Client> clientSet = new HashSet<>(clients);

            clientSet.add(k);
            jsonFileRepository.save(new ArrayList<>(clientSet));
            return k;
        } catch (Exception e) {
            System.out.println("No se ha podido insertar un nuevo cliente");
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Client findByEmailAndDocument(String email, String document) {
        try {
            // Cargar todos los clientes desde el archivo json
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
        try {
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

    @Override
    public Client findById(Long id) {
        try {
            return jsonFileRepository.load().stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el cliente por id");
            return null;
        }
    }

    /**
     * Busca un cliente por número de documento.
     *
     * @param documentNumber Número de documento a buscar.
     * @return Cliente encontrado o null si no existe.
     */
    public Client findByDocumentNumber(String documentNumber) {
        try {
            List<Client> clients = readAll();
            if (clients == null || clients.isEmpty()) {
                return null;
            }
            return clients.stream()
                    .filter(c -> c.getDocumentNumber().equals(documentNumber))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("No se ha podido encontrar el cliente por documento");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
