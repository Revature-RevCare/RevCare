
package com.revature.Spring.repositories;

import com.revature.Spring.models.PatientDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDiagnosisRepo extends JpaRepository<PatientDiagnosis, Integer> {
//    PatientDiagnosis findByConfirm(Boolean confirm);
}



