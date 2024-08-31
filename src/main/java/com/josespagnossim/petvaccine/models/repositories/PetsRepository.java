package com.josespagnossim.petvaccine.models.repositories;

import com.josespagnossim.petvaccine.models.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<PetEntity, Long> {
}
