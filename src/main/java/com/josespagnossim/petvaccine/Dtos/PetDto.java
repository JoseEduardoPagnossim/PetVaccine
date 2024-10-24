package com.josespagnossim.petvaccine.Dtos;


import com.josespagnossim.petvaccine.models.entities.CustomerEntity;

public record PetDto(

        String name,
        String species,
        String breed,
        int age
) {}

