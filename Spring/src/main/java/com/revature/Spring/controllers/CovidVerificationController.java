package com.revature.Spring.controllers;

import com.revature.Spring.models.CovidVerification;
import com.revature.Spring.services.CovidVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/covid")
public class CovidVerificationController {

    private final CovidVerificationService covidService;

    @Autowired
    public CovidVerificationController(CovidVerificationService covidService){
        this.covidService = covidService;
    }

    @GetMapping("/")
    public List<CovidVerification> getAll(){
        return covidService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CovidVerification addCovid(@RequestBody CovidVerification covid){
            return covidService.addCovid(covid);
    }

    @PutMapping(path="/{id}")
    public void updateCovid(@PathVariable("id") int id, @RequestBody CovidVerification covid) {
        if (id == covid.getCovidId()) {
            covidService.update(covid);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        covidService.delete(id);
    }
}
