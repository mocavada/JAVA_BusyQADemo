package com.busyqa.controller;

import com.busyqa.course.controller.RESTController;
import com.busyqa.course.pojo.City;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HTMLFormControllerIntegrationTest {

    @Autowired
    RESTController cityController;

    @Test
    public void testAddCity() {
        // Create a city
        City city = new City("Toronto", 2810000);

        // POST our city form bean to the controller; check the outcome
        City outcome = cityController.createCityNoRedirect(city);

        // Assert THAT the outcome is as expected
        assertThat(outcome.getName(), is(equalTo("Toronto")));

        //
        City quieyCity = cityController.readOneCity(String.valueOf(outcome.getId()));
        assertThat(quieyCity.getName(), is(equalTo("Toronto")));

        // teardown
        cityController.deleteCity(String.valueOf(quieyCity.getId()));
    }


}
