package com.josespagnossim.petvaccine.Dtos;


public record VaccinationEventDto(
        Long petId,
        Long vaccineId,
        String vaccinationDate
) {}
