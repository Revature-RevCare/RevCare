package com.revature.Spring.repositories;

import com.revature.Spring.models.CovidVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CovidVerificationRepo extends JpaRepository<CovidVerification, Integer> {
    // This line of code causes issues in the services.
//    Optional<CovidVerification> findCovidVerificationById(Integer id);
}
