package com.example.client.repository;

import com.example.client.model.SigningService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SigningServiceRepository extends JpaRepository<SigningService, Integer> {

    @Query(value = "select * from signing_service WHERE client_id = ? and is_active= true", nativeQuery = true)
    List<SigningService> getActiveSigningServiceBy(int id);

    @Query(value = "select * from signing_service WHERE client_id = ?", nativeQuery = true)
    List<SigningService> getAllSigningServiceBy(int id);
}
