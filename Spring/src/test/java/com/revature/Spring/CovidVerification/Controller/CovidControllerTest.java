package com.revature.Spring.CovidVerification.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Spring.controllers.CovidVerificationController;
import com.revature.Spring.models.CovidVerification;
import com.revature.Spring.repositories.CovidVerificationRepo;
import com.revature.Spring.services.CovidVerificationService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Mocking a CovidVerificationController Class to Test the controller methods
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CovidVerificationController.class)
public class CovidControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CovidVerificationService service;
    @MockBean
    private CovidVerificationRepo covidRepo;

    /**
     * Should Create a Mock MVC
     */
    @Test
    public void shouldCreateMockMVC(){
        Assert.assertNotNull(mvc);
    }

    /**
     *
     * @throws Exception
     *
     * Test to fetch all mock applications  by creating a list of Objects and using a when statement to find all applications and if the test passes then it returns HTTP OK status.
     */
    @Test
    public void findAllFetchTest() throws Exception {
        List<CovidVerification> covid = Arrays.asList(
                new CovidVerification(1, "yes", true),
                new CovidVerification(2, "no", true),
                new CovidVerification(3, "no", false)
        );
        when(service.findAll()).thenReturn(covid);
        mvc.perform(MockMvcRequestBuilders.get("/covid"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]"))
                        .andDo(print());
    }

    /**
     *
     * @throws Exception
     *
     * Test to find a mock application by its ID, Creating an Object and using when statement to get the application by its id
     * Mock mvc building a path and then Mock mvc matches the value we passed in an Object. If the test passes it will return HTTP.OK Status.
     */
    @Test
    public void findByIdTest() throws Exception {
        CovidVerification covid = new CovidVerification();
        covid.setCovidId(1);
        covid.setCovidStatus("Yes");
        covid.setVaccinationStatus(false);
        int id = 1;
        when(service.getById(id)).thenReturn(covid);
        mvc.perform(MockMvcRequestBuilders.get("/covid/find/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.covidStatus").value("Yes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vaccinationStatus").value(false))
                .andExpect(status().isOk());
    }

    /**
     *
     * @throws Exception
     *
     * Test to save a mock application, passing an object through Mock MVC Request Builder through Post method,
     * Object Mapper is converting an Object in string and the media type is Json. Once its set then Mock Mvc Matcher checks
     * the value in json path if it matches then the test will return HTTP.Created Status.
     */
    @Test
    public void saveCovidTest() throws Exception {

        CovidVerification covid = new CovidVerification();
        covid.setCovidId(1);
        covid.setCovidStatus("yes");
        covid.setVaccinationStatus(false);
        System.out.println(covid);

        when(service.addCovid(covid)).thenReturn(covid);
        mvc.perform(MockMvcRequestBuilders.post("/covid/add")
                        .content(new ObjectMapper().writeValueAsString(covid))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.covidId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.covidStatus").value("yes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vaccinationStatus").value(false));
    }







}
