package com.revature.Spring.CovidVerification.Services;
import com.revature.Spring.models.CovidVerification;
import com.revature.Spring.repositories.CovidVerificationRepo;
import com.revature.Spring.services.CovidVerificationService;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Mocking a CovidVerificationService class to test service Methods.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CovidServiceTest {
    @Autowired
    private CovidVerificationService covidService;

    @MockBean
    private CovidVerificationRepo covidRepo;


    /*	Test to find all the application by passing 2 objects with the help of Mockito
    *	when statement and then checking on the size by assertEqual method,
    *	if the test passes it will return the size of Objects we passed in.
     */
    @Test
    public void findAllTest(){
        Mockito.when(covidRepo.findAll()).thenReturn(Stream.of(new CovidVerification(1,"No", false), new CovidVerification(2, "Yes", true)).collect(Collectors.toList()));
        Assertions.assertEquals(2, covidService.findAll().size());
    }

    /*	Test to save an application creating a mock object and used a verify method to check if application is saved.
     */
    @Test
    public void saveTest(){
        CovidVerification covid = new CovidVerification(1,"no", false);
        covidService.addCovid(covid);
        verify(covidRepo, times(1)).save(covid);
    }

    // Test to get an Application By id

    @Test
    public void getByIdTest(){
        CovidVerification covid = new CovidVerification(1, "yes", false);
        when(covidRepo.findById(1)).thenReturn(java.util.Optional.of(covid));
        Assertions.assertEquals(covid, covidService.getById(1));
    }


}
