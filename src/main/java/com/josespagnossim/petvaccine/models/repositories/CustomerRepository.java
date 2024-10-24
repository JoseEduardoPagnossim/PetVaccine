package com.josespagnossim.petvaccine.models.repositories;


import com.josespagnossim.petvaccine.models.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("SELECT c FROM CustomerEntity c LEFT JOIN FETCH c.pets WHERE c.id = :id")
    Optional<CustomerEntity> findByIdWithPets(@Param("id") Long id);
}
