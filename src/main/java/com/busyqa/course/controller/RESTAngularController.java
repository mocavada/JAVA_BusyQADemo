package com.busyqa.course.controller;

import com.busyqa.course.pojo.AngularFormDemo;
import com.busyqa.course.pojo.AngularFormStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTAngularController {
    //
    @RequestMapping(method = RequestMethod.POST, value = "/angular-model-form-demo")
    public AngularFormStatus angularModelFormPost(@RequestBody AngularFormDemo f) {
        System.out.println("User Email: " + f.getEmail());
        AngularFormStatus st = new AngularFormStatus("Successfully submit");
        return st;
    }
}
