//package com.revature.Spring.DoctorAndNurseTests;
//
//import com.revature.Spring.models.PatientDiagnosis;
//import com.revature.Spring.models.User;
//import com.revature.Spring.repositories.PatientDiagnosisRepo;
//import com.revature.Spring.repositories.UserRepo;
//import com.revature.Spring.services.DoctorService;
//import com.revature.Spring.services.NurseService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class NurseTests {
//
//    //inject the service and repositories here
//
//    @Autowired
//    private NurseService service;
//
//    @MockBean
//    private UserRepo repositoryu;
//
//    @MockBean
//    private PatientDiagnosisRepo repositoryp;
//
//    @Test
//    public void findByConfirmTest() {
//        Boolean confirm=false;
//        when(repositoryp.findByConfirm(confirm)).thenReturn((PatientDiagnosis) Stream
//                .of(new PatientDiagnosis(1, "Jonathon", "Beeles", 28, false))
//                .collect(Collectors.toList()));
//        assertEquals(1, service.findByConfirm(confirm).size());
//    }
//
//    @Test
//    public void getByLastTest() {
//        String last="Beeles";
//        when(repositoryu.findByLast(last)).thenReturn(new User(1, "Jonathon", "Beeles", "Stanford", "MD", "doctor@doctor.com", "pass", "555-555-5555"));
//        assertEquals(last, service.findByLast(last).getLast());
//    }
//
//    @Test
//    public void findAllPatientDiagnosisTest() {
//        when(repositoryp.findAll()).thenReturn(Stream
//                .of(new PatientDiagnosis(1, "Jonathon", "Beeles", 28, false),
//                        new PatientDiagnosis(9, "Robert", "Campbell", 27, false))
//                .collect(Collectors.toList()));
//        assertEquals(2, service.findAllPatientDiagnosis().size());
//    }
//}
