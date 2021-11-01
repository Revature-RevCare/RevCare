package com.revature.Spring.CovidVerification.Services;
import com.revature.Spring.models.CovidVerification;
import com.revature.Spring.repositories.CovidVerificationRepo;
import com.revature.Spring.services.CovidVerificationService;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CovidServiceTest {
    @Autowired
    private CovidVerificationService covidService;

    @MockBean
    private CovidVerificationRepo covidRepo;


    //	Test to get all covid applications
    @Test
    public void findAllTest(){
        Mockito.when(covidRepo.findAll()).thenReturn(Stream.of(new CovidVerification(1,"No", false), new CovidVerification(2, "Yes", true)).collect(Collectors.toList()));
        Assertions.assertEquals(2, covidService.findAll().size());
    }

//	Test to check and see Covid application adding data into database

    @Test
    public void saveTest(){
        CovidVerification covid = new CovidVerification(1,"no", false);
        covidService.addCovid(covid);
        verify(covidRepo, times(1)).save(covid);
    }

    // Test to get an Application By id

    @Test
    public void getByIdTest(){
        int id =1;
        when(covidRepo.getById(id)).thenReturn(new CovidVerification(1, "Yes", false));
        Assertions.assertEquals(id, covidService.getById(id).getCovidId());
    }
}
