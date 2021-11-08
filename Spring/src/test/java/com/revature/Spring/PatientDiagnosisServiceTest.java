//package com.revature.Spring;
//
//import com.revature.Spring.models.PatientDiagnosis;
//import com.revature.Spring.models.User;
//import com.revature.Spring.repositories.PatientDiagnosisRepo;
//import com.revature.Spring.services.PatientDiagnosisService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDate;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PatientDiagnosisServiceTest {
//    @Autowired
//    private PatientDiagnosisService patientDiagnosisService;
//
//    @MockBean
//    private PatientDiagnosisRepo patientDiagnosisRepo;
//
//    @Test
//    public void getAllDiagnosisTest(){
//        when(patientDiagnosisRepo.findAll()).thenReturn(Stream.of(new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1),
//                                                                  new PatientDiagnosis(2,"test2","test2",31,"too cold",
//                                                                          "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
//                                                                          36.8f,130,80,80,true,"stomachache",2,1,1)).collect(Collectors.toList()));
//        assertEquals(2,patientDiagnosisService.findAllDiagnosis().size());
//    }
//
//    @Test
//    public void getAllActiveDiagnosisTest(){
//        when(patientDiagnosisRepo.findAll()).thenReturn(Stream.of(new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                        "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                        37.5f,130,70,80,false,"cold",1,1,1),
//                new PatientDiagnosis(2,"test2","test2",31,"too cold",
//                        "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
//                        36.8f,130,80,80,true,"stomachache",2,1,1)).collect(Collectors.toList()));
//        assertEquals(1,patientDiagnosisService.findAllActiveDiagnosis().size());
//    }
//
//    @Test
//    public void saveDiagnosisTest(){
//        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        when(patientDiagnosisRepo.save(pd)).thenReturn(pd);
//        assertEquals(pd,patientDiagnosisService.addNewDiagnosis(pd));
//    }
//
//    @Test
//    public void deleteDiagnosisTest(){
//        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        patientDiagnosisService.deleteDiagnosis(1);
//        verify(patientDiagnosisRepo,times(1)).deleteById(1);
//    }
//
//    @Test
//    public void getByDiagnosisIdTest(){
//        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        when(patientDiagnosisRepo.findById(1)).thenReturn(java.util.Optional.of(pd));
//        assertEquals(pd,patientDiagnosisService.getById(1));
//    }
//
//    @Test
//    public void updateDiagnosisTest(){
//        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//
//        patientDiagnosisService.updateDiagnosis(pd);
//        verify(patientDiagnosisRepo, times(1)).save(pd);
//
//    }
//
//    @Test
//    public void constructorTest(){
//        PatientDiagnosis pd = new PatientDiagnosis("test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        PatientDiagnosis pd2 = new PatientDiagnosis();
//        pd2.setBlood_pressure_high(130);
//        pd2.setFname("test1");
//        pd2.setLname("test1");
//        pd2.setPatient_age(20);
//        pd2.setComplaint("nothing");
//        pd2.setSymptoms("cough");
//        pd2.setMed_history("n/a");
//        pd2.setFam_history("n/a");
//        pd2.setAllergies("n/a");
//        pd2.setCurrent_meds("n/a");
//        pd2.setCurrent_date(LocalDate.parse("2021-11-11"));
//        pd2.setPatient_height(170);
//        pd2.setPatient_weight(130);
//        pd2.setPatient_temp(37.5f);
//        pd2.setBlood_pressure_low(70);
//        pd2.setPulse(80);
//        pd2.setDoctor_verification(false);
//        pd2.setDiagnosis_text("cold");
//        pd2.setCovid_id(1);
//        pd2.setDoctor_id(1);
//        pd2.setNurse_id(1);
//        assertEquals(pd,pd2);
//    }
//
//    @Test
//    public void toStringTest(){
//        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        PatientDiagnosis pd2 = new PatientDiagnosis();
//        pd2.setId(1);
//        pd2.setBlood_pressure_high(130);
//        pd2.setFname("test1");
//        pd2.setLname("test1");
//        pd2.setPatient_age(20);
//        pd2.setComplaint("nothing");
//        pd2.setSymptoms("cough");
//        pd2.setMed_history("n/a");
//        pd2.setFam_history("n/a");
//        pd2.setAllergies("n/a");
//        pd2.setCurrent_meds("n/a");
//        pd2.setCurrent_date(LocalDate.parse("2021-11-11"));
//        pd2.setPatient_height(170);
//        pd2.setPatient_weight(130);
//        pd2.setPatient_temp(37.5f);
//        pd2.setBlood_pressure_low(70);
//        pd2.setPulse(80);
//        pd2.setDoctor_verification(false);
//        pd2.setDiagnosis_text("cold");
//        pd2.setCovid_id(1);
//        pd2.setDoctor_id(1);
//        pd2.setNurse_id(1);
//        assertEquals(pd.toString(),pd2.toString());
//    }
//}
