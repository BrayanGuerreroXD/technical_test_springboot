package com.nelumbo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.test.entity.Client;
import com.nelumbo.test.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public List<Client> getClientAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientbyId(@PathVariable Integer id) {

        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            return client.get();
        }

        return null;
    }

    @PostMapping
    public Client postClient(@RequestBody Client client) {
        clientRepository.save(client);
        return client;
    }


    @PutMapping("/{id}")
    public Client putClientbyId(@PathVariable Integer id, @RequestBody Client client) {

        Optional<Client> clientCurrent = clientRepository.findById(id);

        if (clientCurrent.isPresent()) {
            Client clientReturn = clientCurrent.get();
            clientReturn.setName(client.getName());
            clientRepository.save(clientReturn);
            return clientReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Client deleteClientbyId(@PathVariable Integer id) {

        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            Client clientReturn = client.get();
            clientRepository.deleteById(id);
            return clientReturn;
        }

        return null;
    }
}
