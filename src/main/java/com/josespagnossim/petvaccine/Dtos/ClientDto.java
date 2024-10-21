package com.josespagnossim.petvaccine.Dtos;


public record ClientDto(
        Long id,
        String name,
        String document,
        String email,
        String phoneNumber

) {}
