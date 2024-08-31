package com.josespagnossim.petvaccine.services;

import com.josespagnossim.petvaccine.Dtos.VaccineDto;
import com.josespagnossim.petvaccine.exceptions.vaccine.VaccineNotFound;
import com.josespagnossim.petvaccine.models.entities.VaccineEntity;
import com.josespagnossim.petvaccine.models.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VaccineService {


    private VaccineRepository vaccineRepository;

    @Autowired
    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }


    public VaccineEntity createVaccine(VaccineDto vaccineDto) {
        VaccineEntity vaccine = new VaccineEntity();
        vaccine.setName(vaccineDto.name());
        vaccine.setManufacturer(vaccineDto.manufacturer());
        vaccine.setDescription(vaccineDto.description());
        return vaccineRepository.save(vaccine);
    }

    public VaccineEntity findById(Long id) {
        return vaccineRepository.findById(id)
                .orElseThrow(() -> new VaccineNotFound("Id vaccine not found"));
    }

    // Outros métodos para listar, editar, deletar vacinas
}

