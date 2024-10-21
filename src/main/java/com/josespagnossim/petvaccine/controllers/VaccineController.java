package com.josespagnossim.petvaccine.controllers;

import com.josespagnossim.petvaccine.Dtos.VaccineDto;
import com.josespagnossim.petvaccine.models.entities.VaccineEntity;
import com.josespagnossim.petvaccine.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    @Autowired

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping
    public VaccineEntity createVaccine(@RequestBody VaccineDto vaccineDto) {
        return vaccineService.createVaccine(vaccineDto);
    }


}
