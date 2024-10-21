package com.josespagnossim.petvaccine.Dtos;




import java.util.List;

public record ClientDto(
        Long id,
        String name,
        String document,
        String email,
        String phoneNumber

) {}
