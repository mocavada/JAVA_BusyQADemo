package com.busyqa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.busyqa.course.pojo.City;
import com.busyqa.course.service.CityDataService;
import com.busyqa.project.jobbank.pojo.Job;
import com.busyqa.project.jobbank.pojo.JobCompany;
import com.busyqa.project.jobbank.pojo.JobType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class CityDataServiceIntegrationTest {

    @Autowired
    private CityDataService cityDataService;

    @Test
    public void testAddCity() {
        // Create a city
        City city = new City();
        city.setName("Toronto2");
        city.setPopulation(300000);

        // Test adding the city
        City savedReturnCity = cityDataService.create(city);

        // Verify the addition
        assertNotNull(savedReturnCity);

        Long cityID = savedReturnCity.getId();
        City queryReturnCity = cityDataService.getOne(cityID);

        assertNotNull(queryReturnCity.getId());
        assertEquals("Toronto2", queryReturnCity.getName());

        // teardown
        cityDataService.delete(cityID);
    }


//
}
