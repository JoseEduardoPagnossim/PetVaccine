package com.josespagnossim.petvaccine.controllers;

import com.josespagnossim.petvaccine.Dtos.VaccinationEventDto;
import com.josespagnossim.petvaccine.services.VaccinationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccination")
public class VaccinationEventController {

    private final VaccinationEventService vaccinationEventService;

    @Autowired
    public VaccinationEventController(VaccinationEventService vaccinationEventService) {
        this.vaccinationEventService = vaccinationEventService;
    }

    @PostMapping
    public VaccinationEventDto createVaccination(@RequestBody VaccinationEventDto vaccinationEventDto) {
        return vaccinationEventService.createVaccinationEvent(vaccinationEventDto);
    }

}
