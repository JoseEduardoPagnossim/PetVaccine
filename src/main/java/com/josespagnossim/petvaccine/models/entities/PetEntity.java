package com.josespagnossim.petvaccine.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(nullable = false)
    private int age;
    private String species;
    private String breed;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
