package com.busyqa.course.controller;

import com.busyqa.course.pojo.book.Book;
import com.busyqa.course.pojo.book.Category;
import com.busyqa.course.pojo.City;
import com.busyqa.course.pojo.book.Publisher;
import com.busyqa.course.service.BookDataService;
import com.busyqa.course.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RESTController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private BookDataService bookDataService;

    //TEST
    @RequestMapping(method = RequestMethod.GET, value = "/city/test")
    public String test() {
        return "test fail abc 123";
    }

    //Create - in response, it sends another location
    @RequestMapping(method = RequestMethod.POST, value = "/city/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createCity(@RequestBody City city) {
        City savedCity = this.cityDataService.create(city);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCity.getId())
                .toUri();


        return ResponseEntity.created(location).build();
    }

    //Create - in response, it sends the data created
    // example data: {"name":"ABC7","population":1234}
    @RequestMapping(method = RequestMethod.POST, value = "/city/city/")
    @ResponseStatus(HttpStatus.CREATED)
    public City createCityNoRedirect(@RequestBody City city) {
        City savedCity = this.cityDataService.create(city);
        return savedCity;
    }

    //Read - list all cities
    @RequestMapping(method = RequestMethod.GET, value = "/cities")
    public List<City> readAllCities() {
        return this.cityDataService.listAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cities/i")
    public Iterable<City>  readAllCitiesI() {
        return this.cityDataService.listAllI();
    }

    //Read - display the specific id
    @RequestMapping(method = RequestMethod.GET, value = "/city/{id}")
    public City readOneCity(@PathVariable String id) {
        Long cityId = Long.parseLong(id);
        return this.cityDataService.getOne(cityId);
    }

    //Update
    @RequestMapping(method = RequestMethod.PATCH, value = "/city/")
    public ResponseEntity<?> updateCity(@RequestBody City partialUpdate) {
        this.cityDataService.update(partialUpdate);
        return ResponseEntity.ok("resource updated");
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/city/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") String id) {
        this.cityDataService.delete(Long.parseLong(id));
        return ResponseEntity.ok("resource deleted");
    }

    //================================================================
    //page and sort
    @RequestMapping(method = RequestMethod.GET, value = "/cities/sort")
    public List<City> listAllAndSort() {
        return this.cityDataService.listAllAndSort();
    }

    // http://127.0.0.1:8080/cities/page?index=1&size=10
    @RequestMapping(method = RequestMethod.GET, value = "/cities/page")
    public List<City> listAllAndSort(@RequestParam("index") int index, @RequestParam("size") int size) {
        return this.cityDataService.listAllAndPage(index, size);
    }

    //Conditional
    @RequestMapping(method = RequestMethod.GET, value = "/city/findByPopulationGreaterThan/{population}")
    public List<City> getCityByPopuation(@PathVariable long population) {
        return this.cityDataService.getCityByPopuation(population);
    }

    //Customize Query
    @RequestMapping(method = RequestMethod.GET, value = "/city/search/{city}")
    public List<City> searchCity(@PathVariable String city) {
        return this.cityDataService.searchCity(city);
    }


    //================================================================

    //M2M-M2O
    // execute http://127.0.0.1/book/init first to generate demo data
    @RequestMapping(method = RequestMethod.GET, value = "/book/init")
    public void initM2M() {
        this.bookDataService.addDumyData();
    }

    //Many to One
    @RequestMapping(method = RequestMethod.GET, value = "/publishers")
    public List<Publisher> getAllPuclishers() {
        return this.bookDataService.findAllPublishers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getAllBook() {
        return this.bookDataService.findAllBooks();
    }

    //Many to Many
    @RequestMapping(method = RequestMethod.GET, value = "/cates")
    public List<Category> getAllCate() {
        return this.bookDataService.findAllCates();
    }


}