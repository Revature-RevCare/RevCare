//package com.revature.Spring;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.Spring.controllers.PatientDiagnosisController;
//import com.revature.Spring.models.PatientDiagnosis;
//import com.revature.Spring.services.PatientDiagnosisService;
//
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static java.util.Arrays.asList;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebMvcTest(controllers = PatientDiagnosisController.class)
//public class PatientDiagnosisControllerTest {
//
//    @MockBean
//    private PatientDiagnosisService patientDiagnosisService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private List<PatientDiagnosis> patientDiagnoses;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    public void shouldGetAllDiagnosisControllerTest() throws Exception {
//        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        PatientDiagnosis diagnosis2 = new PatientDiagnosis(2,"test2","test2",31,"too cold",
//                "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
//                36.8f,130,80,80,true,"stomachache",2,1,1);
//        Mockito.when(patientDiagnosisService.findAllDiagnosis()).thenReturn(asList(diagnosis1, diagnosis2));
//
//        mockMvc.perform(get("/diagnosis/all"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", Matchers.is(2)))
//                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
//                .andExpect(jsonPath("$[0].fname", Matchers.is("test1")))
//                .andExpect(jsonPath("$[1].id", Matchers.is(2)));
//    }
//
//    @Test
//    public void shouldGetAllActiveControllerTest() throws Exception {
//        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        PatientDiagnosis diagnosis2 = new PatientDiagnosis(2,"test2","test2",31,"too cold",
//                "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
//                36.8f,130,80,80,true,"stomachache",2,1,1);
//        Mockito.when(patientDiagnosisService.findAllActiveDiagnosis()).thenReturn(asList(diagnosis2));
//
//        mockMvc.perform(get("/diagnosis/active"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", Matchers.is(1)))
//                .andExpect(jsonPath("$[0].id", Matchers.is(2)))
//                .andExpect(jsonPath("$[0].fname", Matchers.is("test2")));
//    }
//
//    @Test
//    public void getDiagnosisByIdControllerTest() throws Exception {
//        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//        Mockito.when(patientDiagnosisService.getById(1)).thenReturn(diagnosis1);
//
//        mockMvc.perform(get("/diagnosis/find/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.fname", Matchers.is("test1")))
//                .andExpect(jsonPath("$.patient_weight", Matchers.is(130.0)));
//
//    }
//
//    @Test
//    public void createDiagnosisControllerTest() throws  Exception {
//        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"haha",1,1,1);
//
//        Mockito.when(patientDiagnosisService.addNewDiagnosis(pd)).thenReturn(pd);
//
//        mockMvc.perform(post("/diagnosis/add")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(pd)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id", Matchers.is(1)))
//                .andExpect(jsonPath("$.current_date", Matchers.is("2021-11-11")))
//                .andExpect(jsonPath("$.diagnosis_text", Matchers.is("haha")))
//                .andExpect(jsonPath("$.pulse", Matchers.is(80)))
//                .andExpect(jsonPath("$.patient_temp", Matchers.is(37.5)));
//    }
//
//    @Test
//    public void updateDiagnosisControllerTest() throws Exception {
//        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//
//        diagnosis1.setBlood_pressure_high(100);
//        diagnosis1.setBlood_pressure_low(80);
//        diagnosis1.setDoctor_verification(true);
//
//        Mockito.when(patientDiagnosisService.updateDiagnosis(diagnosis1)).thenReturn(diagnosis1);
//
//        mockMvc.perform(post("/diagnosis/put/update")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(diagnosis1)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.blood_pressure_high", Matchers.is(100)))
//                .andExpect(jsonPath("$.blood_pressure_low", Matchers.is(80)))
//                .andExpect(jsonPath("$.doctor_verification", Matchers.is(true)));
//
//    }
//
//    @Test
//    public void deleteDiagnosisControllerTest() throws Exception {
//        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
//                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
//                37.5f,130,70,80,false,"cold",1,1,1);
//
//        mockMvc.perform(post("/diagnosis/delete/{id}", 1))
//                .andExpect(status().isOk());
//    }
//
//}
package com.revature.Spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Spring.controllers.PatientDiagnosisController;
import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.services.PatientDiagnosisService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(controllers = PatientDiagnosisController.class)
public class PatientDiagnosisControllerTest {

    @MockBean
    private PatientDiagnosisService patientDiagnosisService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private List<PatientDiagnosis> patientDiagnoses;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldGetAllDiagnosisControllerTest() throws Exception {
        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
        PatientDiagnosis diagnosis2 = new PatientDiagnosis(2,"test2","test2",31,"too cold",
                "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
                36.8f,130,80,80,true,"stomachache",2,1,1);
        Mockito.when(patientDiagnosisService.findAllDiagnosis()).thenReturn(asList(diagnosis1, diagnosis2));

        mockMvc.perform(get("/diagnosis/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.is(2)))
                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$[0].fname", Matchers.is("test1")))
                .andExpect(jsonPath("$[1].id", Matchers.is(2)));
    }

    @Test
    public void shouldGetAllActiveControllerTest() throws Exception {
        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
        PatientDiagnosis diagnosis2 = new PatientDiagnosis(2,"test2","test2",31,"too cold",
                "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
                36.8f,130,80,80,true,"stomachache",2,1,1);
        Mockito.when(patientDiagnosisService.findAllActiveDiagnosis()).thenReturn(asList(diagnosis2));

        mockMvc.perform(get("/diagnosis/active"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.is(1)))
                .andExpect(jsonPath("$[0].id", Matchers.is(2)))
                .andExpect(jsonPath("$[0].fname", Matchers.is("test2")));
    }

    @Test
    public void getDiagnosisByIdControllerTest() throws Exception {
        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
        Mockito.when(patientDiagnosisService.getById(1)).thenReturn(diagnosis1);

        mockMvc.perform(get("/diagnosis/find/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fname", Matchers.is("test1")))
                .andExpect(jsonPath("$.patient_weight", Matchers.is(130.0)));

    }

    @Test
    public void createDiagnosisControllerTest() throws  Exception {
        PatientDiagnosis pd = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"haha",1,1,1);

        Mockito.when(patientDiagnosisService.addNewDiagnosis(pd)).thenReturn(pd);

        mockMvc.perform(post("/diagnosis/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(pd)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.current_date", Matchers.is("2021-11-11")))
                .andExpect(jsonPath("$.diagnosis_text", Matchers.is("haha")))
                .andExpect(jsonPath("$.pulse", Matchers.is(80)))
                .andExpect(jsonPath("$.patient_temp", Matchers.is(37.5)));
    }

    @Test
    public void updateDiagnosisControllerTest() throws Exception {
        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);

        diagnosis1.setBlood_pressure_high(100);
        diagnosis1.setBlood_pressure_low(80);
        diagnosis1.setDoctor_verification(true);

        Mockito.when(patientDiagnosisService.updateDiagnosis(diagnosis1)).thenReturn(diagnosis1);

        mockMvc.perform(post("/diagnosis/put/update")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(diagnosis1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.blood_pressure_high", Matchers.is(100)))
                .andExpect(jsonPath("$.blood_pressure_low", Matchers.is(80)))
                .andExpect(jsonPath("$.doctor_verification", Matchers.is(true)));

    }

    @Test
    public void deleteDiagnosisControllerTest() throws Exception {
        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);

        mockMvc.perform(post("/diagnosis/delete/{id}", 1))
                .andExpect(status().isOk());
    }

}
