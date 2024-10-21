package com.josespagnossim.petvaccine.services;


import com.josespagnossim.petvaccine.Dtos.ClientDto;
import com.josespagnossim.petvaccine.Dtos.PetDto;
import com.josespagnossim.petvaccine.exceptions.client.ClientNotFound;
import com.josespagnossim.petvaccine.exceptions.pets.InvalidInsertionOfPetData;
import com.josespagnossim.petvaccine.models.entities.ClientEntity;
import com.josespagnossim.petvaccine.models.entities.PetEntity;
import com.josespagnossim.petvaccine.models.entities.VaccinationEventEntity;
import com.josespagnossim.petvaccine.models.repositories.ClientRepository;
import com.josespagnossim.petvaccine.models.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private PetsRepository petsRepository;
    private ClientRepository clientRepository;

    @Autowired
    public PetService(PetsRepository petsRepository, ClientRepository clientRepository) {
        this.petsRepository = petsRepository;
        this.clientRepository = clientRepository;
    }


    public PetDto createPet(Long clientId, PetDto petDto){
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFound("Client not found"));

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
