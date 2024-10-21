package com.josespagnossim.petvaccine.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PetEntity pet;  // Pet que foi vacinado

    @ManyToOne
    private VaccineEntity vaccine;  // Vacina aplicada

    private String vaccinationDate;  // Data da vacinação


}
