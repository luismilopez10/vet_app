package com.lmlopez.vet_app.service;

import com.lmlopez.vet_app.entity.Client;
import com.lmlopez.vet_app.entity.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    List<Client> getAllClients();

    Client saveClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long id);

    Client savePet(Pet pet);

    void deletePet(Pet pet);
}
