package com.revature.Spring.repositories;

import com.revature.Spring.models.CovidVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidVerificationRepo extends JpaRepository<CovidVerification, Integer> {
}
