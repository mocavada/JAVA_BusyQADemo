package com.busyqa.course.repo;

import com.busyqa.course.pojo.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepositoryImpl extends PagingAndSortingRepository<City, Long> {



    List<City> findByPopulationGreaterThanAndName(long population, String name);
    List<City> findByPopulationGreaterThan(long population);

    @Query(value = "SELECT * FROM city c WHERE c.name = :nameSearch", nativeQuery = true)
    List<City> retrieveByName(@Param("nameSearch") String name);

//    @Query(value = "SELECT * FROM city c WHERE c.name = :nameSearch", nativeQuery = true)
    City findByName(String name);

}

