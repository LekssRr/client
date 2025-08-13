package com.example.client.repository;

import com.example.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client getClientByVinCodeAuto(String vinCodeAuto);

    Optional<Client> findByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);
}
