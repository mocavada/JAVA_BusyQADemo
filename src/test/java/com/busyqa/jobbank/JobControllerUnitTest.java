package com.busyqa.jobbank;

import com.busyqa.course.controller.RESTController;
import com.busyqa.course.service.BookDataService;
import com.busyqa.course.service.CityDataService;
import com.busyqa.project.jobbank.JobbankController;
import com.busyqa.project.jobbank.JobbankService;
import com.busyqa.project.jobbank.pojo.Job;
import com.busyqa.project.jobbank.pojo.JobCompany;
import com.busyqa.project.jobbank.pojo.JobType;
import com.busyqa.project.pictureupload.StorageService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JobbankController.class)
@SuppressWarnings("unchecked")
public class JobControllerUnitTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    JobbankService jobbankService;

    // ======== prepare other related service instance
    @MockBean
    BookDataService bookDataService;
    @MockBean
    StorageService storageService;
    @MockBean
    CityDataService cityDataService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddJob() throws Exception {
        // Create a job
        Job aMockJob = new Job(new JobCompany(), new JobType(),
                "Software Engineer", "Coding", "College degree", "Toronto", 55000l);

        // make a mock service response
        when(jobbankService.createJob(any(Job.class)))
                .thenReturn(aMockJob);

        // simulate the form bean that would POST from the web page
        Job aInsertData = new Job(new JobCompany(), new JobType(),
                "Software Engineer", "Coding", "College degree", "Toronto", 55000l);

        String json = (new Gson()).toJson(aInsertData, Job.class);

        System.out.println(json);

        // simulate the form submit (POST)
        MvcResult result = mockMvc.perform(
                post("/job/").contentType(MediaType.APPLICATION_JSON).content("{\"id\":0,\"jobTitle\":\"Software Engineer\",\"jobDescription\":\"Coding\",\"requirement\":\"College degree\",\"location\":\"Toronto\",\"salary\":55000}\n"))
                .andExpect(status().isCreated())
                .andReturn();

        System.out.println(result.getResponse());
        // no need to teardown
    }

}
