package com.josespagnossim.petvaccine.models.repositories;


import com.josespagnossim.petvaccine.models.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
