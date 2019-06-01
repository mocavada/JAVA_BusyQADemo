package com.busyqa.service;

import com.busyqa.course.pojo.City;
import com.busyqa.course.repo.CityRepositoryImpl;
import com.busyqa.course.service.CityDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class CityDataServiceUnitTest {

    @Mock
    private CityRepositoryImpl cityRepository;
    @InjectMocks
    private CityDataService cityDataService;




    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCity() {

        // Create a city
        City aMockCity = new City("Montreal", 300000);
        when(cityRepository.save(any(City.class))).thenReturn(aMockCity);

        // Save the city, but it will be intercepted by Mokito
        City newCity = cityDataService.create(new City());

        System.out.println(newCity.getName());

        // Verify the save
        assertEquals("Montreal", newCity.getName());

        // teardown
        // no need to delete because of mock
    }
}
