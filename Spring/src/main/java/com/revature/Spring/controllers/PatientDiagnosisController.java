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

/**
 * Controller class PatientDiagnosisController maps to "/daignosis"
 * <br><br>
 * <b>Methods</b>
 *  <ul>
 *      <li>getActiveDiagnosis Get the active diagnosis</li>
 *      <li>getDiagnosisById Get a diagnosis by id</li>
 *      <li>getDiagnosisById Get all diagnosis</li>
 *      <li>addPatient Creates a new patient</li>
 *      <li>patientDiagnosisUpdate Changes information for a patient.</li>
 *      <li>removePatient delets a patient.</li>
 *  </ul>
 */
@RestController
@RequestMapping("/diagnosis")
public class PatientDiagnosisController {
    private final PatientDiagnosisService patientDiagnosisService;

    @Autowired
    public PatientDiagnosisController(PatientDiagnosisService patientDiagnosisService) {

        this.patientDiagnosisService = patientDiagnosisService;
    }

    /**
     * getActiveDiagnosis maps to "/active"
     * @return ResponseEntity for the active diagnosis
     */
    @GetMapping(value = "/active")
    public ResponseEntity<List<PatientDiagnosis>> getActiveDiagnosis() {
        List<PatientDiagnosis> patientDiagnoses = patientDiagnosisService.findAllActiveDiagnosis();
        return new ResponseEntity<>(patientDiagnoses, HttpStatus.OK);
    }

    /**
     * getDiagnosisById maps to "/find/id"
     * @param id Integer containing the diagnosis id
     * @return ResponseEntity with status ok and a diagnosis by id.
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<PatientDiagnosis> getDiagnosisById(@PathVariable("id") Integer id) throws JsonProcessingException {
        PatientDiagnosis pd = patientDiagnosisService.getById(id);
        return new ResponseEntity<>(pd, HttpStatus.OK);
    }

    /**
     * getAllDiagnosises maps to "/all"
     * @return ResponseEntity with status ok and a list of all patient diagnosis.
     */
    @GetMapping("/all")
    public ResponseEntity<List<PatientDiagnosis>> getAllDiagnosises () {
        List<PatientDiagnosis> patients = patientDiagnosisService.findAllDiagnosis();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    /**
     * addPatient maps to "/add"
     * @param patient A PatientDiagnosis object
     * @return ResponseEntity with status CREATED and the new patient diagnosis.
     */
    @PostMapping(value = "/add")
    public ResponseEntity<PatientDiagnosis> addPatient(@RequestBody PatientDiagnosis patient) {
        PatientDiagnosis newPatient = patientDiagnosisService.addNewDiagnosis(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    /**
     * patientDiagnosisUpdate maps to "put/update"
     * @param patientDiagnosis PatientDiaganosis object to change.
     * @return ResponseEntity status ok and the updated patient diagnosis
     */
    @PostMapping("put/update")
    public ResponseEntity<PatientDiagnosis> patientDiagnosisUpdate(@RequestBody PatientDiagnosis patientDiagnosis) {
        PatientDiagnosis updateDiagnosis = patientDiagnosisService.updateDiagnosis(patientDiagnosis);
        return new ResponseEntity<>(updateDiagnosis, HttpStatus.OK);
    }

    /**
     * removePatient maps to "delete/{id}"
     * @param id Integer containing the id of the diagnosis to delete
     * @return ResponseEntity with status OK
     */
    @PostMapping("delete/{id}")
    public ResponseEntity<?> removePatient(@PathVariable("id") Integer id){
        patientDiagnosisService.deleteDiagnosis(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
