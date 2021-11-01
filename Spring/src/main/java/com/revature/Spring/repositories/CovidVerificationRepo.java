package com.revature.Spring.repositories;

import com.revature.Spring.models.CovidVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CovidVerificationRepo extends JpaRepository<CovidVerification, Integer> {
    Optional<CovidVerification> findCovidVerificationById(Integer id);
}
