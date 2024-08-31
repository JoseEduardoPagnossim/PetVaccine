package com.josespagnossim.petvaccine.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PetEntity pets;

    @ManyToOne
    private VaccineEntity vaccines;

    private LocalDate vaccinationDate;
    private LocalDate nextDueDate;


}
