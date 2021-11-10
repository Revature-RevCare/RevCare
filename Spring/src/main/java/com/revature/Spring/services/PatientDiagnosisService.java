package com.revature.Spring.services;

import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.repositories.PatientDiagnosisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * PatientDiagnosisService Service class
 * <br><br>
 * <b>Methods</b>
 *  <ul>
 *      <li>getById</li>
 *      <li>findAllDiagnosis</li>
 *      <li>addNewDiagnosis</li>
 *      <li>updateDiagnosis</li>
 *      <li>deleteDiagnosis</li>
 *  </ul>
 */
@Service
//@Transactional
public class PatientDiagnosisService {
    private final PatientDiagnosisRepo patientDiagnosisRepo;

    @Autowired
    public PatientDiagnosisService(PatientDiagnosisRepo patientDiagnosisRepo){ this.patientDiagnosisRepo = patientDiagnosisRepo;}

    //CRUD:
    //R:

    /**
     * getById
     * @param id given Patient Diagnosis id
     * @return PatientDiagnosis object via patientDiagnosisRepo method findById
     */
    public PatientDiagnosis getById(int id){
        return patientDiagnosisRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("patient diagnosis not found."));
    }

    /**
     * findAllDiagnosis
     * @return List of Patient diagnosis via patientDiagnosisRepo method findAll
     */
    public List<PatientDiagnosis> findAllDiagnosis(){return patientDiagnosisRepo.findAll();}

    /**
     * findAllActiveDiagnosis
     * @return List of all Active diagnosis via patientDiagnosisRepo method findAll
     */
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

    /**
     * addNewDiagnosis
     * @param pd given PatientDiagnosis object.
     * @return PatientDiagnosis object after creating new one via patientDiagnosisRepo method save
     */
    public PatientDiagnosis addNewDiagnosis(PatientDiagnosis pd){ return patientDiagnosisRepo.save(pd);}

    //D:

    /**
     * deleteDiagnosis
     * @param id Integer containing given id of diagnosis record to delete
     */
    public void deleteDiagnosis(Integer id){ patientDiagnosisRepo.deleteById(id);}

    //U:

    /**
     * updateDiagnosis
     * @param pd PatientDiagnosis object
     * @return PatientDiagnosis object via patientDiagnosisRepo method save
     */
    public PatientDiagnosis updateDiagnosis(PatientDiagnosis pd) {
        return patientDiagnosisRepo.save(pd);
    }

}