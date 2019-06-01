package com.busyqa.repository;

import com.busyqa.course.pojo.City;
import com.busyqa.course.repo.CityRepositoryImpl;
import com.busyqa.project.pictureupload.StorageService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CityRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CityRepositoryImpl cityRepositoryImpl;

    @MockBean
    StorageService storageService;

    @Test
    public void testFindByName() {

        // Create a city
        City city = new City("Toronto", 2810000);

        // save test data
        entityManager.persist(city);
//         cityRepositoryImpl.save(city);

        // Find an inserted record
        City foundCity = cityRepositoryImpl.findByName("Toronto");

        assertThat(foundCity.getName(), is(equalTo("Toronto")));

        // teardown
//        cityRepositoryImpl.delete(city);
        entityManager.remove(city);
        entityManager.flush();
    }

}
