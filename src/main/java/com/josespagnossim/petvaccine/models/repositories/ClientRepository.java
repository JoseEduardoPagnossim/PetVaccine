package com.josespagnossim.petvaccine.models.repositories;


import com.josespagnossim.petvaccine.models.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT c FROM ClientEntity c LEFT JOIN FETCH c.pets")
    List<ClientEntity> findAllWithPets();
}
