package com.revature.Spring;

import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.models.User;
import com.revature.Spring.repositories.PatientDiagnosisRepo;
import com.revature.Spring.services.PatientDiagnosisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDiagnosisServiceTest {
    @Autowired
    private PatientDiagnosisService patientDiagnosisService;

    @MockBean
    private PatientDiagnosisRepo patientDiagnosisRepo;

    @Test
    public void getAllDiagnosisTest(){
        when(patientDiagnosisRepo.findAll()).thenReturn(Stream.of(new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1),
                                                                  new PatientDiagnosis(2,"test2","test2",31,"too cold",
                                                                          "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
                                                                          36.8f,130,80,80,true,"stomachache",2,1,1)).collect(Collectors.toList()));
        assertEquals(2,patientDiagnosisService.findAllDiagnosis().size());
    }

    @Test
    public void getAllActiveDiagnosisTest(){
        when(patientDiagnosisRepo.findAll()).thenReturn(Stream.of(new PatientDiagnosis(1,"test1","test1",20,"nothing",
                        "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                        37.5f,130,70,80,false,"cold",1,1,1),
                new PatientDiagnosis(2,"test2","test2",31,"too cold",
                        "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
                        36.8f,130,80,80,true,"stomachache",2,1,1)).collect(Collectors.toList()));
        assertEquals(1,patientDiagnosisService.findAllActiveDiagnosis().size());
    }

    @Test
    public void saveDiagnosisTest(){
        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
        when(patientDiagnosisRepo.save(pd)).thenReturn(pd);
        assertEquals(pd,patientDiagnosisService.addNewDiagnosis(pd));
    }

    @Test
    public void deleteDiagnosisTest(){
        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
        patientDiagnosisService.deleteDiagnosis(1);
        verify(patientDiagnosisRepo,times(1)).deleteById(1);
    }

    @Test
    public void getByDiagnosisIdTest(){
        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
        when(patientDiagnosisRepo.findById(1)).thenReturn(java.util.Optional.of(pd));
        assertEquals(pd,patientDiagnosisService.getById(1));
    }

    @Test
    public void updateDiagnosisTest(){
        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
       // userService.updateUser(user);
        patientDiagnosisService.updateDiagnosis(pd);
        verify(patientDiagnosisRepo, times(1)).save(pd);

    }
}
