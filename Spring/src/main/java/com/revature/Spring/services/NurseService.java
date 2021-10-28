package com.revature.Spring.services;

import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.models.User;
import com.revature.Spring.repositories.PatientDiagnosisRepo;
import com.revature.Spring.repositories.UserRepo;

import java.util.Collections;
import java.util.List;

public class NurseService {

    private PatientDiagnosisRepo pr;
    private UserRepo ur;

    public NurseService(PatientDiagnosisRepo pr, UserRepo ur){
        this.pr = pr;
        this.ur = ur;
    }

    public List<PatientDiagnosis> findAllPatientDiagnosis(){
        return pr.findAll();
    }

    public List<PatientDiagnosis> findByConfirm(Boolean confirm){
        return Collections.singletonList(pr.findByConfirm(confirm));
    }

    public User getByLastname(String lname){
        return ur.findByLastname(lname);
    }

}
