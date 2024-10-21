package com.josespagnossim.petvaccine.Dtos;


import com.josespagnossim.petvaccine.models.entities.ClientEntity;

public record PetDto(
        String name,
        String species,
        String breed,
        int age
) {}

