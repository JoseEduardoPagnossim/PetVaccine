package com.josespagnossim.petvaccine.services;

import com.josespagnossim.petvaccine.Dtos.ClientDto;
import com.josespagnossim.petvaccine.exceptions.client.ClientNotFound;
import com.josespagnossim.petvaccine.exceptions.client.InvalidInsertionOfClientData;
import com.josespagnossim.petvaccine.models.entities.ClientEntity;
import com.josespagnossim.petvaccine.models.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity creatClient(ClientDto clientDto) {
        if(clientDto.name() == null || clientDto.document() == null) {
            throw new InvalidInsertionOfClientData("Client name or document cannot be null");
        } else {
            ClientEntity client = new ClientEntity();
            client.setId(client.getId());
            client.setName(clientDto.name());
            client.setDocument(clientDto.document());
            client.setEmail(clientDto.email());
            client.setDocument(clientDto.phoneNumber());
            return clientRepository.save(client);
        }
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientEntity getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public ClientEntity updateClient(Long id,ClientDto clientDto) {
        Optional<ClientEntity> client = clientRepository.findById(id);
        ClientEntity clientEntity = null;
        if(client.isPresent()) {
            clientEntity = client.get();
            clientEntity.setName(clientDto.name());
            clientEntity.setDocument(clientDto.document());
            return clientRepository.save(clientEntity);
        } else{
            throw new ClientNotFound("ID not found");
        }

    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }



}
