package com.revature.Spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.services.PatientDiagnosisService;
import com.revature.Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diagnosis")
public class PatientDiagnosisController {
    private final PatientDiagnosisService patientDiagnosisService;

    @Autowired
    public PatientDiagnosisController(PatientDiagnosisService patientDiagnosisService) {

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
        List<PatientDiagnosis> patients = patientDiagnosisService.findAllDiagnosis();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public ResponseEntity<?> addPatient(@RequestBody Map<String,String> json) {
        //LocalDate today = LocalDate.now();
        PatientDiagnosis newPatient = new PatientDiagnosis();
        newPatient.setFname(json.get("fname"));
        newPatient.setLname(json.get("lname"));
        newPatient.setPatient_age(Integer.parseInt(json.get("patient_age")));
        newPatient.setComplaint(json.get("complaint"));
        newPatient.setSymptoms(json.get("symptoms"));
        newPatient.setMed_history(json.get("med_history"));
        newPatient.setFam_history(json.get("fam_history"));
        newPatient.setAllergies(json.get("allergies"));
        newPatient.setCurrent_meds(json.get("current_meds"));
        newPatient.setCurrent_date(LocalDate.now());
        newPatient.setPatient_weight(Float.parseFloat(json.get("patient_weight")));
        newPatient.setPatient_height(Float.parseFloat(json.get("patient_height")));
        newPatient.setPatient_temp(Float.parseFloat(json.get("patient_temp")));
        newPatient.setBlood_pressure_high(Integer.parseInt(json.get("blood_pressure_high")));
        newPatient.setBlood_pressure_low(Integer.parseInt(json.get("blood_pressure_low")));
        newPatient.setPulse(Integer.parseInt(json.get("pulse")));
        newPatient.setDoctor_verification(false);
        newPatient.setDiagnosis_text(json.get("diagnosis_text"));
        newPatient.setCovid_id(Integer.parseInt(json.get("covid_id")));
        newPatient.setNurse_id(Integer.parseInt(json.get("nurse_id")));
        newPatient.setDoctor_id(-1);
        System.out.println(newPatient);
        PatientDiagnosis addPatient = patientDiagnosisService.addNewDiagnosis(newPatient);
        System.out.println(addPatient);
        return new ResponseEntity<PatientDiagnosis>(addPatient,HttpStatus.CREATED);
    }

//    @PostMapping("put/update")
//    public ResponseEntity<PatientDiagnosis> patientDiagnosisUpdate(@RequestBody PatientDiagnosis patientDiagnosis) {
//        PatientDiagnosis updateDiagnosis = patientDiagnosisService.updateDiagnosis(patientDiagnosis);
//        return new ResponseEntity<>(updateDiagnosis, HttpStatus.OK);
//    }

    @PostMapping(value ="put/update",consumes = "application/json")
    public ResponseEntity<?> patientDiagnosisUpdate(@RequestBody Map<String,String> json) {
        PatientDiagnosis updateDiagnos = new PatientDiagnosis();
        updateDiagnos.setId(Integer.parseInt(json.get("id")));
        updateDiagnos.setFname(json.get("fname"));
        updateDiagnos.setLname(json.get("lname"));
        updateDiagnos.setPatient_age(Integer.parseInt(json.get("patient_age")));
        updateDiagnos.setComplaint(json.get("complaint"));
        updateDiagnos.setSymptoms(json.get("symptoms"));
        updateDiagnos.setMed_history(json.get("med_history"));
        updateDiagnos.setFam_history(json.get("fam_history"));
        updateDiagnos.setAllergies(json.get("allergies"));
        updateDiagnos.setCurrent_meds(json.get("current_meds"));
        updateDiagnos.setCurrent_date(LocalDate.now());
        updateDiagnos.setPatient_weight(Float.parseFloat(json.get("patient_weight")));
        updateDiagnos.setPatient_height(Float.parseFloat(json.get("patient_height")));
        updateDiagnos.setPatient_temp(Float.parseFloat(json.get("patient_temp")));
        updateDiagnos.setBlood_pressure_high(Integer.parseInt(json.get("blood_pressure_high")));
        updateDiagnos.setBlood_pressure_low(Integer.parseInt(json.get("blood_pressure_low")));
        updateDiagnos.setPulse(Integer.parseInt(json.get("pulse")));
        updateDiagnos.setDoctor_verification(Boolean.parseBoolean(json.get("doctor_verification")));
        updateDiagnos.setDiagnosis_text(json.get("diagnosis_text"));
        updateDiagnos.setCovid_id(Integer.parseInt(json.get("covid_id")));
        updateDiagnos.setNurse_id(Integer.parseInt(json.get("nurse_id")));
        updateDiagnos.setDoctor_id(Integer.parseInt(json.get("doctor_id")));
        PatientDiagnosis updateDiagnosis = patientDiagnosisService.updateDiagnosis(updateDiagnos);
        return new ResponseEntity<PatientDiagnosis>(updateDiagnosis, HttpStatus.OK);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> removePatient(@PathVariable("id") Integer id){
        patientDiagnosisService.deleteDiagnosis(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
