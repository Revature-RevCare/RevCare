package com.revature.Spring;

import com.revature.Spring.controllers.PatientDiagnosisController;
import com.revature.Spring.models.PatientDiagnosis;
import com.revature.Spring.services.PatientDiagnosisService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = PatientDiagnosisController.class)
public class PatientDiagnosisControllerTest {

    @MockBean
    private PatientDiagnosisService patientDiagnosisService;

    @Autowired
    private MockMvc mockMvc;

    private List<PatientDiagnosis> patientDiagnoses;

    @Test
    public void shouldAddDiagnosis() throws Exception {
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
    public void shouldDeleteDiagnosis() throws Exception {
        PatientDiagnosis diagnosis1 = new PatientDiagnosis(1,"test1","test1",20,"nothing",
                "cough","n/a","n/a","n/a","n/a", LocalDate.parse("2021-11-11"),130,170,
                37.5f,130,70,80,false,"cold",1,1,1);
        PatientDiagnosis diagnosis2 = new PatientDiagnosis(2,"test2","test2",31,"too cold",
                "cough","n/a","heart disease","peanut","n/a",LocalDate.parse("2021-11-01"),150,180,
                36.8f,130,80,80,true,"stomachache",2,1,1);
        Mockito.when(patientDiagnosisService.findAllDiagnosis()).thenReturn(asList(diagnosis1, diagnosis2));

        mockMvc.perform(get("/diagnosis/delete/delete"))
                .andExpect(status().isOk())
    }

}
