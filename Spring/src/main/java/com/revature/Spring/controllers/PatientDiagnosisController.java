package com.revature.Spring.controllers;

<<<<<<< Updated upstream
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public PatientDiagnosisController(PatientDiagnosisService patientDiagnosisService) {
=======
    @Autowired
    public PatientDiagnosisController(PatientDiagnosisService patientDiagnosisService, UserService userService) {
>>>>>>> Stashed changes
        this.patientDiagnosisService = patientDiagnosisService;
    }

<<<<<<< HEAD
    @GetMapping(value = "/all")
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

    @GetMapping("/active/")
    public ResponseEntity<List<PatientDiagnosis>> getAllActiveDiagnosises () {
        List<PatientDiagnosis> patients = patientDiagnosisService.findAllActiveDiagnosis();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PatientDiagnosis> getPatientById (@PathVariable("id") Integer id) {
        PatientDiagnosis pokemon = patientDiagnosisService.getById(id);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PatientDiagnosis> addPatient(@RequestBody PatientDiagnosis patient) {
        PatientDiagnosis newPatient = patientDiagnosisService.addNewDiagnosis(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

=======
>>>>>>> da973315d7d8ed02acf457ed9ad7d8300b62459d
}
