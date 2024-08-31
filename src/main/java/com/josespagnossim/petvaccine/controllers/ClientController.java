package com.josespagnossim.petvaccine.controllers;

import com.josespagnossim.petvaccine.Dtos.ClientDto;
import com.josespagnossim.petvaccine.models.entities.ClientEntity;
import com.josespagnossim.petvaccine.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientEntity createClient(@RequestBody ClientDto clientDto) {
        return clientService.creatClient(clientDto);
    }

    @GetMapping
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("{id}")
    public ClientEntity getClientById(@RequestParam Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping
    public ClientEntity updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
    }



}
