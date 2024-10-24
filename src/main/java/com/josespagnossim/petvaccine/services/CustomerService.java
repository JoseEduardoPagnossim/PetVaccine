package com.josespagnossim.petvaccine.services;

import com.josespagnossim.petvaccine.Dtos.CustomerDto;
import com.josespagnossim.petvaccine.exceptions.customer.CustomerNotFound;
import com.josespagnossim.petvaccine.exceptions.customer.InvalidInsertionOfCustomerData;
import com.josespagnossim.petvaccine.models.entities.CustomerEntity;
import com.josespagnossim.petvaccine.models.repositories.CustomerRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto creatClient(CustomerDto customerDto) {
        if(customerDto.name() == null || customerDto.document() == null) {
            throw new InvalidInsertionOfCustomerData("Client name or document cannot be null");
        } else {
            CustomerEntity customer = new CustomerEntity();
            customer.setId(customer.getId());
            customer.setName(customerDto.name());
            customer.setDocument(customerDto.document());
            customer.setEmail(customerDto.email());
            customer.setPhoneNumber(customerDto.phoneNumber());

            CustomerEntity saveClient = customerRepository.save(customer);

            return new CustomerDto(
                    saveClient.getId(),
                    saveClient.getName(),
                    saveClient.getDocument(),
                    saveClient.getEmail(),
                    saveClient.getPhoneNumber()
                     );
        }
    }

    public Optional<CustomerEntity> findAllWithPets(Long id){
        return customerRepository.findByIdWithPets(id);
    }

    public List<CustomerEntity> getAllClients() {
        return customerRepository.findAll();
    }

    public CustomerEntity getClientById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public CustomerEntity updateClient(Long id, CustomerDto clientDto) {
        Optional<CustomerEntity> client = customerRepository.findById(id);
        CustomerEntity customerEntity = null;
        if(client.isPresent()) {
            customerEntity = client.get();
            customerEntity.setName(clientDto.name());
            customerEntity.setDocument(clientDto.document());
            return customerRepository.save(customerEntity);
        } else{
            throw new CustomerNotFound("ID not found");
        }

    }

    public void deleteClientById(Long id) {
        customerRepository.deleteById(id);
    }



}
