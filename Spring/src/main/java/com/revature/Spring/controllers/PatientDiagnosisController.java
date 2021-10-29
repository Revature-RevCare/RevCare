package com.revature.Spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.services.PatientDiagnosisService;
import com.revature.Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis")
public class PatientDiagnosisController {
    private final PatientDiagnosisService patientDiagnosisService;

    @Autowired
    public PatientDiagnosisController(PatientDiagnosisService patientDiagnosisService, UserService userService) {

        this.patientDiagnosisService = patientDiagnosisService;
    }

    @GetMapping(value = "/active")
    public ResponseEntity<List<PatientDiagnosis>> getActiveDiagnosis() {
        List<PatientDiagnosis> patientDiagnoses = patientDiagnosisService.findAllActiveDiagnosis();
        return new ResponseEntity<>(patientDiagnoses, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<PatientDiagnosis> getDiagnosisById(@PathVariable("id") Integer id) throws JsonProcessingException {
        PatientDiagnosis pd = patientDiagnosisService.getById(id);
        return new ResponseEntity<>(pd, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientDiagnosis>> getAllDiagnosises () {
        List<PatientDiagnosis> pokemons = patientDiagnosisService.findAllDiagnosis();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<PatientDiagnosis> addPatient(@RequestBody PatientDiagnosis patient) {
        PatientDiagnosis newPatient = patientDiagnosisService.addNewDiagnosis(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }


    @PostMapping("/update")
    public ResponseEntity<PatientDiagnosis> patientDiagnosisUpdate(@RequestBody PatientDiagnosis patientDiagnosis) {
        PatientDiagnosis updateDiagnosis = patientDiagnosisService.updateDiagnosis(patientDiagnosis);
        return new ResponseEntity<>(updateDiagnosis, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<PatientDiagnosis> removePatient(@RequestBody PatientDiagnosis patient){
        patientDiagnosisService.deleteDiagnosis(patient.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
