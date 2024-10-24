package com.josespagnossim.petvaccine.Dtos;


public record CustomerDto(

        Long id,
        String name,
        String document,
        String email,
        String phoneNumber

) {}
