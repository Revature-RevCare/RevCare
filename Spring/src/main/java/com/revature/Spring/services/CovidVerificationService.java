package com.revature.Spring.services;

import com.revature.Spring.exceptions.ApplicationNotFoundException;
import com.revature.Spring.models.CovidVerification;
import com.revature.Spring.repositories.CovidVerificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CovidVerificationService Service
 * <br><br>
 * <b>Methods</b>
 *  <ul>
 *      <li>getById</li>
 *      <li>findAll</li>
 *      <li>addCovid</li>
 *  </ul>
 */
@Service
public class CovidVerificationService {
    private final CovidVerificationRepo covidRepo;

    @Autowired
    public CovidVerificationService(CovidVerificationRepo covidRepo){
        this.covidRepo = covidRepo;
    }

    /**
     * getById
     * @param id Integer containing given id
     * @return CovidVerification for a given id via covidRepo method findById
     */
    public CovidVerification getById(Integer id){
        // This line of code doesn't work.
//        return covidRepo.findCovidVerificationById(id).orElseThrow(()->new ApplicationNotFoundException("Application Id " + id + " Application not found by this Id"));
        return covidRepo.findById(id).orElse(null);
    }

    /**
     * findAll
     * @return List of Covid verifications via covidRepo method findAll
     */
    public List<CovidVerification> findAll(){
        return covidRepo.findAll();
    }

    /**
     * addCovid
     * @param covid CovidVerification object
     * @return CovidVerification objext via covidRepo method save
     */
    public CovidVerification addCovid(CovidVerification covid){
        return covidRepo.save(covid);
    }

//    public void updateApplication(CovidVerification covid){
//        covidRepo.save(covid);
//    }
//
//    public void deleteApplication(Integer id){
//        covidRepo.delete(covidRepo.getById(id));
//    }
}
