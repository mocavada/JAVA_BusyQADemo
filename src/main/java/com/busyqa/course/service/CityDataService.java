package com.busyqa.course.service;

import com.busyqa.course.pojo.City;
import com.busyqa.course.repo.CityRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

@Service("CityDataService")
public class CityDataService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityRepositoryImpl cityRepository;

    public CityDataService(CityRepositoryImpl cityRepository) {
        this.cityRepository = cityRepository;
    }

    //create
    public City create(City cityCreated) {
        System.out.println(cityCreated.toString());

        return this.cityRepository.save(cityCreated);
    }

    //Read
    public List<City> listAll() {
        List<City> list = new ArrayList<>();
        cityRepository.findAll().forEach(list::add);


        return list;
    }

    public Iterable<City> listAllI() {
        return cityRepository.findAll();
    }


    public City getOne(Long cityId) {
        City city = cityRepository.findById(cityId).get();
        System.out.print(city);
        return city;
    }

    //update
    public void update(City partialUpdate) {
        if (partialUpdate.getPopulation() < 1) {
            //....
        } else {
            this.cityRepository.save(partialUpdate);
        }

    }


    //delete
    public void delete(Long cityId) {
        this.cityRepository.deleteById(cityId);
    }

    //Conditional Expression
    public List<City> getCityByPopuation(long population) {
//        return this.cityRepository.findByPopulationGreaterThan(population);
        return this.cityRepository.findByPopulationGreaterThanAndName(population, "G");
    }

    //Sorting
    public List<City> listAllAndSort() {
        List<City> list = new ArrayList<>();
        cityRepository.findAll(new Sort(Sort.Direction.ASC, "population")).forEach(list::add);
        return list;
    }


    //Paging
    public List<City> listAllAndPage(int index, int size) {
        List<City> list = new ArrayList<>();
        cityRepository.findAll(PageRequest.of(index, size, new Sort(Sort.Direction.ASC, "population"))).forEach(list::add);
        return list;
    }

    //customized query
    public List<City> searchCity(String cityName) {


        return this.cityRepository.retrieveByName(cityName);
    }


}
