package com.busyqa.course.controller;

import com.busyqa.course.pojo.BasicFormSubmit;
import com.busyqa.course.pojo.City;
import com.busyqa.course.pojo.Greeting;
import com.busyqa.course.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Controller
public class HTMLFormController {
    //================================================================Basic Form (Get)
    @RequestMapping(method = RequestMethod.GET, value = "/FormGetMain.html")
    public String basicFormGet() {
        return "basic_form_get/Main";
    }

    @GetMapping("/GetResponse99")
    public String basicFormGetResponse(BasicFormSubmit user, Map<String, Object> model) {
        model.put("userName", user.getUserName());
        model.put("email", user.getEmail());
        if (user.getEmail().contains("@")) {
            return "basic_form_get/Response";
        } else {
            return "basic_form_get/Error";
        }
    }

//    http://127.0.0.1/wleifjlwef/GetResponseABC?name=wlefij
    @GetMapping("/{somethingelse}/GetResponseABC")
    public String basicFormGetResponseABC(@RequestParam String name,
                                          @PathVariable("somethingelse") String userEmail,
                                          Map<String, Object> model) {
        model.put("userName", name);
        model.put("email", userEmail);
        return "basic_form_get/Response";
    }

    //    @PostMapping("/GetResponse99")
    @RequestMapping(method = RequestMethod.POST, value = "/GETResponse99")
    public String basicFormGetResponseX(Model model, BasicFormSubmit user) {
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("email", user.getEmail());
//        if(user.getEmail().contains("@")){
//            return "basic_form_get/Response";
//        }else {
//            return "basic_form_get/Error";
//        }

        return "basic_form_get/Response";
    }

    //================================================================Basic Form (Post)
    @Autowired
    private CityDataService cityDataService;

    @RequestMapping(method = RequestMethod.GET, value = "/FormPostCity.html")
    @ResponseStatus(value = HttpStatus.OK)
    public String cityCreate() {
        return "basic_form_post/Main";
    }


    @PostMapping(value = "/PostSubmit.html")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Object> citySubmit(City city, Model model) {

        //=== save to jdbc
        City savedCity = this.cityDataService.create(city);
        System.out.println(savedCity.toString());

        //=== redirect to query
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("city/{id}")
                .buildAndExpand(savedCity.getId())
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", location.getPath());

        return new ResponseEntity<Object>(headers, HttpStatus.FOUND);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/GetList.html")
    @ResponseStatus(value = HttpStatus.OK)
    public String cityList(Map<String, Object> model) {
        model.put("list", this.cityDataService.listAll());
        return "basic_form_post/GetList";
    }


}
