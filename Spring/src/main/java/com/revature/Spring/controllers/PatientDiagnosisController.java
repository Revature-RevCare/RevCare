package com.revature.Spring.controllers;

import com.revature.Spring.services.PatientDiagnosisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosis")
public class PatientDiagnosisController {
    private final PatientDiagnosisService patientDiagnosisService;

    public PatientDiagnosisController(PatientDiagnosisService patientDiagnosisService) {
        this.patientDiagnosisService = patientDiagnosisService;
    }
}
