package com.revature.Spring.controllers;

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
    public ResponseEntity<CovidVerification> addCovidApplication(@RequestBody CovidVerification covid){
        CovidVerification newApplication = covidService.addCovid(covid);
        return new ResponseEntity<>(newApplication, HttpStatus.CREATED);
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
