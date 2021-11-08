package com.revature.Spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Spring.models.CovidVerification;
import com.revature.Spring.services.CovidVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidVerificationController {

    private final CovidVerificationService covidService;
    private ObjectMapper om = new ObjectMapper();

    @Autowired
    public CovidVerificationController(CovidVerificationService covidService){
        this.covidService = covidService;
    }
   @GetMapping()
    public ResponseEntity<List<CovidVerification>> getAllCovidApplications(){
        List<CovidVerification> covidVerificationList = covidService.findAll();
        return new ResponseEntity<>(covidVerificationList, HttpStatus.OK);
   }
   @GetMapping("/find/{id}")
    public ResponseEntity<CovidVerification> getApplicationById(@PathVariable("id") Integer id){
        CovidVerification covid = covidService.getById(id);
        return new ResponseEntity<>(covid, HttpStatus.OK);
   }

    @PostMapping()
    public ResponseEntity<String> addCovidApplication(@RequestBody CovidVerification covid) throws JsonProcessingException {
        CovidVerification newApplication = covidService.addCovid(covid);
        return new ResponseEntity<>(om.writeValueAsString(covid), HttpStatus.CREATED);
    }

//    @PutMapping("/update")
//    public ResponseEntity<CovidVerification> updateCovidApplication(@RequestBody CovidVerification covid){
//        CovidVerification updateApplication = covidService.updateApplication(covid);
//        return new ResponseEntity<>(updateApplication, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteApplication(@PathVariable("id") Integer id){
//        covidService.deleteApplication(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
