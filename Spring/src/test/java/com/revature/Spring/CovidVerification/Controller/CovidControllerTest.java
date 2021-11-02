package com.revature.Spring.CovidVerification.Controller;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CovidVerificationController.class)
public class CovidControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CovidVerificationService service;
    @MockBean
    private CovidVerificationRepo covidRepo;

    @Test
    public void shouldCreateMockMVC(){
        Assert.assertNotNull(mvc);
    }

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
                .andExpect(content().json("[{}, {}, {}]"));
        System.out.println(covid);
    }






}
