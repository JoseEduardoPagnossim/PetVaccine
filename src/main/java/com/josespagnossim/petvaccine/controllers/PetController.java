package com.josespagnossim.petvaccine.controllers;

import com.josespagnossim.petvaccine.Dtos.PetDto;
import com.josespagnossim.petvaccine.models.entities.PetEntity;
import com.josespagnossim.petvaccine.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/{clientId}")
    public PetDto createPet(@PathVariable Long clientId, @RequestBody PetDto petDto) {
        return petService.createPet(clientId, petDto);
    }

    @GetMapping
    public List<PetEntity> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public PetEntity getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePetById(@PathVariable Long id) {
        petService.deletePetById(id);
    }
}
