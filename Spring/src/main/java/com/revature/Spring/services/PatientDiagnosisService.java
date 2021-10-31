package com.revature.Spring.services;

import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.repositories.PatientDiagnosisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientDiagnosisService {
    private final PatientDiagnosisRepo patientDiagnosisRepo;

    @Autowired
    public PatientDiagnosisService(PatientDiagnosisRepo patientDiagnosisRepo){ this.patientDiagnosisRepo = patientDiagnosisRepo;}

    //CRUD:
    //R:
    public PatientDiagnosis getById(int id){
        return patientDiagnosisRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("patient diagnosis not found."));
    }

    public List<PatientDiagnosis> findAllDiagnosis(){return patientDiagnosisRepo.findAll();}

    public List<PatientDiagnosis> findAllActiveDiagnosis(){
        List<PatientDiagnosis> lopd = patientDiagnosisRepo.findAll();
        List<PatientDiagnosis> result = new ArrayList<>();

        for(PatientDiagnosis pd : lopd) {
            //check if not verified by doctor yet
            if(!pd.isDoctor_verification())
                result.add(pd);
        }
        return result;
    }
    //C:
    public PatientDiagnosis addNewDiagnosis(PatientDiagnosis pd){ return patientDiagnosisRepo.save(pd);}

    //D:
    public void deleteDiagnosis(Integer id){ patientDiagnosisRepo.deleteById(id);}

    //U:
    public PatientDiagnosis updateDiagnosis(PatientDiagnosis pd) {
        return patientDiagnosisRepo.save(pd);
    }

}