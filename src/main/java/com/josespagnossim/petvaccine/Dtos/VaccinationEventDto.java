package com.josespagnossim.petvaccine.Dtos;

import java.time.LocalDate;

public record VaccinationEventDto(
        Long petId,
        Long vaccineId,
        LocalDate vaccinationDate
) {}
