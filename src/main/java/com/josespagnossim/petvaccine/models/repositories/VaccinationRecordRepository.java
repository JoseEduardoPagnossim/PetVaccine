package com.josespagnossim.petvaccine.models.repositories;

import com.josespagnossim.petvaccine.models.entities.VaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, Long> {
}
