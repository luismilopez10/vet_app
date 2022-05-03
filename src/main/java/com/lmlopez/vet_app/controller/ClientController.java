package com.lmlopez.vet_app.controller;

import com.lmlopez.vet_app.entity.Client;
import com.lmlopez.vet_app.entity.Pet;
import com.lmlopez.vet_app.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    @Autowired
    IClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.updateClient(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @PostMapping("/pets")
    public Client savePet(@RequestBody Pet pet){
        return clientService.savePet(pet);
    }

    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id){
        clientService.deletePet(id);
    }
}
