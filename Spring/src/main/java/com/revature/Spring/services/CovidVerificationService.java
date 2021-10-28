package com.revature.Spring.services;

import com.revature.Spring.models.CovidVerification;
import com.revature.Spring.repositories.CovidVerificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidVerificationService {
    private final CovidVerificationRepo covidRepo;

    @Autowired
    public CovidVerificationService(CovidVerificationRepo covidRepo){
        this.covidRepo = covidRepo;
    }

    public CovidVerification getById(Integer id){
        return covidRepo.getById(id);
    }

    public List<CovidVerification> findAll(){
        return covidRepo.findAll();
    }

    public CovidVerification addCovid(CovidVerification covid){
        return covidRepo.save(covid);
    }

    public void update(CovidVerification covid){
        covidRepo.save(covid);
    }

    public void delete(Integer id){
        covidRepo.delete(covidRepo.getById(id));
    }
}
