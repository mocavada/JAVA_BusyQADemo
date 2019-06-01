package com.busyqa.controller;

import com.busyqa.course.controller.RESTController;
import com.busyqa.course.pojo.City;
import com.busyqa.course.service.BookDataService;
import com.busyqa.course.service.CityDataService;
import com.busyqa.project.pictureupload.StorageService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RESTController.class)
@SuppressWarnings("unchecked")
public class HTMLFormControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CityDataService cityDataService;

    @MockBean
    BookDataService bookDataService;

    @MockBean
    StorageService storageService;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCity() throws Exception {
        // setup mock City returned the mock service component
        City aMockCity = new City("Toronto", 2810000);

        when(cityDataService.create(any(City.class)))
                .thenReturn(aMockCity);

        // simulate the form bean that would POST from the web page
        City aCity = new City("Toronto", 2810000);

        String json = (new Gson()).toJson(aCity, City.class);

        // simulate the form submit (POST)
        mockMvc.perform(
                post("/city/").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andReturn();


        // no need to teardown
    }

}
