package com.josespagnossim.petvaccine.services;

import com.josespagnossim.petvaccine.Dtos.VaccinationEventDto;
import com.josespagnossim.petvaccine.exceptions.pets.PetNotFound;
import com.josespagnossim.petvaccine.exceptions.vaccine.VaccineNotFound;
import com.josespagnossim.petvaccine.models.entities.PetEntity;
import com.josespagnossim.petvaccine.models.entities.VaccinationEventEntity;
import com.josespagnossim.petvaccine.models.entities.VaccineEntity;
import com.josespagnossim.petvaccine.models.repositories.PetsRepository;
import com.josespagnossim.petvaccine.models.repositories.VaccinationEventRepository;
import com.josespagnossim.petvaccine.models.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationEventService {

    private VaccinationEventRepository vaccinationEventRepository;
    private PetsRepository petsRepository;
    private VaccineRepository vaccineRepository;

    @Autowired
    public VaccinationEventService(VaccinationEventRepository vaccinationEventRepository, PetsRepository petsRepository, VaccineRepository vaccineRepository) {
        this.vaccinationEventRepository = vaccinationEventRepository;
        this.petsRepository = petsRepository;
        this.vaccineRepository = vaccineRepository;
    }

    public VaccinationEventDto createVaccinationEvent(VaccinationEventDto eventDto) {
        PetEntity pet = petsRepository.findById(eventDto.petId())
                .orElseThrow(() -> new PetNotFound("Pet not found"));

        VaccineEntity vaccine = vaccineRepository.findById(eventDto.vaccineId())
                .orElseThrow(() -> new VaccineNotFound("Vaccine not found"));

        VaccinationEventEntity vaccinationEvent = new VaccinationEventEntity();
        vaccinationEvent.setPet(pet);
        vaccinationEvent.setVaccine(vaccine);
        vaccinationEvent.setVaccinationDate(eventDto.vaccinationDate());

        VaccinationEventEntity saveEvent = vaccinationEventRepository.save(vaccinationEvent);

        return new VaccinationEventDto(
                saveEvent.getId(),
                saveEvent.getPet().getId(),
                saveEvent.getVaccinationDate());
    }
}
