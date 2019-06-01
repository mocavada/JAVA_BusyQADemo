package com.busyqa.project.jobbank;

import com.busyqa.project.jobbank.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
public class JobbankController {


    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JobbankService jobbankService;

    //========
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/jobs")
    public List<Job> listAllAndSort() {

        return this.jobbankService.getJobList();
    }

    //========
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "/job")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    List<Job> createJob(@RequestBody Job job) {
        Job newJob = this.jobbankService.createJob(job);
        System.out.print(job);
        return this.jobbankService.getJobList();
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/job/{id}")
    public @ResponseBody
    void delJob(@PathVariable("id") Long id) {

        this.jobbankService.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "/job")
    public @ResponseBody
    void editJob(@RequestBody Job job) {
        this.jobbankService.updateJobByID(job);
    }
    //================================================================
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/jobtypes")
    public List<JobType> getJobTypeList() {
        return this.jobbankService.getJobTypeList();
    }


    //================================================================
    //========================Optional
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "/company")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    List<JobCompany> createCompany(@RequestBody JobCompany comp) {
        JobCompany jobCompanySaved = this.jobbankService.createCompany(comp);
        //Coomcomp = this.jobbankService.createCompany(comp);
        System.out.print(jobCompanySaved);
        return this.jobbankService.getCompanyList();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/companies")
    public List<JobCompany> getCompanyList() {
        return this.jobbankService.getCompanyList();
    }


    //======== login
    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, value = "/login")
    public JobLoginStatus login(@RequestBody JobPostUser jobPostUser, HttpSession session) {

        System.out.println(session.getId() + ":" + jobPostUser.getUserName() + " :" + jobPostUser.getPassword());

        return jobbankService.login(jobPostUser, session);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/checklogin")
    public JobLoginStatus checkLogin(HttpSession session) {

        return this.jobbankService.checkLoginSessionStatus(session);
    }

    //======== session test
    @GetMapping("/checkCount")
    // it will handle all request for /welcome
    public java.util.Map<String, Integer> start(HttpSession session) {
        String sessionId = session.getId();
        System.out.println("\n " + sessionId + " \n");

        Integer integer = (Integer) session.getAttribute("hitCounter"); // it will read data from database tables
        if (integer == null) {
            integer = new Integer(0);
            integer++;
            session.setAttribute("hitCounter", integer);  // it will write data to tables
        } else {
            integer++;
            session.setAttribute("hitCounter", integer);  // it will write data to tables
        }
        java.util.Map<String, Integer> hitCounter = new HashMap<>();
        hitCounter.put("Hit Counter", integer);
        return hitCounter;
    }

}

