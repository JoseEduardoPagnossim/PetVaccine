package com.josespagnossim.petvaccine.services;


import com.josespagnossim.petvaccine.Dtos.PetDto;
import com.josespagnossim.petvaccine.exceptions.customer.CustomerNotFound;
import com.josespagnossim.petvaccine.exceptions.pets.InvalidInsertionOfPetData;
import com.josespagnossim.petvaccine.models.entities.CustomerEntity;
import com.josespagnossim.petvaccine.models.entities.PetEntity;
import com.josespagnossim.petvaccine.models.repositories.CustomerRepository;
import com.josespagnossim.petvaccine.models.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetsRepository petsRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public PetService(PetsRepository petsRepository, CustomerRepository clientRepository) {
        this.petsRepository = petsRepository;
        this.customerRepository = clientRepository;
    }


    public PetDto createPet(Long clientId, PetDto petDto){
        CustomerEntity customer = customerRepository.findById(clientId)
                .orElseThrow(() -> new CustomerNotFound("Client not found"));

        if (petDto.name() == null || petDto.species() == null){
            throw new InvalidInsertionOfPetData("Name and age and species are required");
        } else {
            PetEntity pet = new PetEntity();
            pet.setId(pet.getId());
            pet.setName(petDto.name());
            pet.setSpecies(petDto.species());
            pet.setAge(petDto.age());
            pet.setBreed(petDto.breed());


            PetEntity savePet = petsRepository.save(pet);

            return new PetDto(
                    savePet.getName(),
                    savePet.getSpecies(),
                    savePet.getBreed(),
                    savePet.getAge()

            );
        }
    }

    public List<PetEntity> getAllPets(){
        return petsRepository.findAll();
    }

    public PetEntity getPetById(Long id){
        return petsRepository.findById(id).orElse(null);
    }

    public void deletePetById(Long id){
        petsRepository.deleteById(id);
    }
}
