package com.revature.Spring.DoctorAndNurseTests;

import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.models.User;
import com.revature.Spring.repositories.PatientDiagnosisRepo;
import com.revature.Spring.repositories.UserRepo;
import com.revature.Spring.services.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorTests {

    //inject the service and repositories here

    @Autowired
    private DoctorService service;

    @MockBean
    private UserRepo repositoryu;

    @MockBean
    private PatientDiagnosisRepo repositoryp;

    @Test
    public void findByConfirmTest() {
        Boolean confirm=false;
        when(repositoryp.findByConfirm(confirm)).thenReturn((PatientDiagnosis) Stream
                .of(new PatientDiagnosis(1, "Jonathon", "Beeles", 28, false))
                .collect(Collectors.toList()));
        assertEquals(1, service.findByConfirm(confirm).size());
    }

    @Test
    public void getByLastNameTest() {
        String last="Beeles";
        when(repositoryu.findByLast(last)).thenReturn((User) Stream
                .of(new User(1, "Jonathon", "Beeles", "Stanford", "MD", "doctor@doctor.com", "pass", "555-555-5555"))
                .collect(Collectors.toList()));
        assertEquals(1, service.findByLastName(last).size());
    }

    // get all test if needed:
//    @Test
//    public void getUsersTest() {
//        when(repositoryu.getUsers()).thenReturn(Stream
//                .of(new User(1, "Jonathon", "Beeles", 28, false),
//                        new User(9, "Robert", "Campbell", 27, false))
//                .collect(Collectors.toList()));
//        assertEquals(2, service.getUsers().size());
//    }

}
