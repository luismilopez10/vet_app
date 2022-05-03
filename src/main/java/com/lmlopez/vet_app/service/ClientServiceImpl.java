package com.lmlopez.vet_app.service;

import com.lmlopez.vet_app.entity.Client;
import com.lmlopez.vet_app.entity.Pet;
import com.lmlopez.vet_app.repository.ClientRepository;
import com.lmlopez.vet_app.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements IClientService{

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).get();
        if (!client.getPets().isEmpty()){
            client.getPets().forEach(pet -> petRepository.deleteById(pet.getId()));
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Client savePet(Pet pet){
        Client client = clientRepository.findById(pet.getFK_client_id()).get();
        client.addPet(pet);
        petRepository.save(pet);
        return clientRepository.save(client);
    }

    @Override
    public void deletePet(Pet pet){
        petRepository.deleteById(pet.getId());
    }
}
