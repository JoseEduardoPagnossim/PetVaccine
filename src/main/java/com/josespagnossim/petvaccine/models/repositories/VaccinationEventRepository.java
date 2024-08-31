package com.josespagnossim.petvaccine.models.repositories;

import com.josespagnossim.petvaccine.models.entities.VaccinationEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationEventRepository extends JpaRepository<VaccinationEventEntity,Long> {
}
