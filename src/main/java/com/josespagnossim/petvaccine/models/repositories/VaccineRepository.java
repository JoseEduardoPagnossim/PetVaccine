package com.josespagnossim.petvaccine.models.repositories;

import com.josespagnossim.petvaccine.models.entities.VaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<VaccineEntity, Long> {
}
