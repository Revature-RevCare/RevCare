package com.revature.Spring.repositories;

import com.revature.Spring.models.PatientDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDiagnosisRepo extends JpaRepository<PatientDiagnosis, Integer> {
}
