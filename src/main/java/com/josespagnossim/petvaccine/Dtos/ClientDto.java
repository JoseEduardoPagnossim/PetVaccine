package com.josespagnossim.petvaccine.Dtos;


public record ClientDto(
        String name,
        String document,
        String email,
        String phoneNumber
) {}
