package com.revature.Spring.controllers;

import com.revature.Spring.services.PatientDiagnosisService;
import com.revature.Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosis")
public class PatientDiagnosisController {
    private final PatientDiagnosisService patientDiagnosisService;
    private final UserService userService;

    public PatientDiagnosisController(PatientDiagnosisService patientDiagnosisService, UserService userService) {
        this.patientDiagnosisService = patientDiagnosisService;
        this.userService = userService;
    }


}
