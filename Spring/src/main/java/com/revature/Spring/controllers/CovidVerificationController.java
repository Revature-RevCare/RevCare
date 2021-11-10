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

/**
 * The Controller class CovidVerificationController is marked as a REST controller with request mapping
 * of "/covid".
 * <br><br>
 * <b>Methods</b>
 *  <ul>
 *      <li>getAllCovidApplications Get all covid applications</li>
 *      <li>getApplicationById Get a covid application by given user name.</li>
 *      <li>addCovidApplication Creates a new Covid Application.</li>
 *  </ul>
 */
@RestController
@RequestMapping("/covid")
public class CovidVerificationController {

    private final CovidVerificationService covidService;
    private ObjectMapper om = new ObjectMapper();

    /**
     * CovidVerificationController autowires the covid service.
     * @param covidService
     */
    @Autowired
    public CovidVerificationController(CovidVerificationService covidService){
        this.covidService = covidService;
    }


    /**
     * getAllCovidApplications returns a ResponseEntity. It maps to the base location for getting all covid applications.
     * @return ResponseEntity with HTTP Status OK.
     */

   @GetMapping()
    public ResponseEntity<List<CovidVerification>> getAllCovidApplications(){
        List<CovidVerification> covidVerificationList = covidService.findAll();
        return new ResponseEntity<>(covidVerificationList, HttpStatus.OK);
   }


    /**
     * getApplicationById maps to /find/id and returns a ResponseEntity for the given id
     * @param id Integer containing the id
     * @return The ResponseEntity for the given id
     */

   @GetMapping("/find/{id}")
    public ResponseEntity<CovidVerification> getApplicationById(@PathVariable("id") Integer id){
        CovidVerification covid = covidService.getById(id);
        return new ResponseEntity<>(covid, HttpStatus.OK);
   }

    /**
     * addCovidApplication posts a new covid application record to the database.
     * @param covid CovidVerification object
     * @return ResponseEntity with HTTPStatus created.
     * @throws JsonProcessingException
     */
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
