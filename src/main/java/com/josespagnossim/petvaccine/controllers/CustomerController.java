package com.josespagnossim.petvaccine.controllers;

import com.josespagnossim.petvaccine.Dtos.CustomerDto;
import com.josespagnossim.petvaccine.models.entities.CustomerEntity;
import com.josespagnossim.petvaccine.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService clientService) {
        this.customerService = clientService;
    }

    @PostMapping
    public CustomerDto createClient(@RequestBody CustomerDto clientDto) {
        return customerService.creatClient(clientDto);
    }

    @GetMapping("/{id}")
    public Optional<CustomerEntity> findAllWithPets(@PathVariable Long id) {
        return customerService.findAllWithPets(id);
    }

    @GetMapping
    public List<CustomerEntity> getAllClients() {
        return customerService.getAllClients();
    }

//    @GetMapping("{id}")
//    public CustomerEntity getClientById(@RequestParam Long id) {
//        return customerService.getClientById(id);
//    }

    @PutMapping
    public CustomerEntity updateClient(@PathVariable Long id, @RequestBody CustomerDto clientDto) {
        return customerService.updateClient(id, clientDto);
    }

    @DeleteMapping
    public void deleteClient(@PathVariable Long id) {
        customerService.deleteClientById(id);
    }



}
