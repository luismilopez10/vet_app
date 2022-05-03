package com.lmlopez.vet_app.service;

import com.lmlopez.vet_app.entity.Client;
import com.lmlopez.vet_app.entity.Pet;

import java.util.List;

public interface IClientService {

    List<Client> getAllClients();

    Client saveClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long id);

    Client savePet(Pet pet);

    void deletePet(Long id);
}
