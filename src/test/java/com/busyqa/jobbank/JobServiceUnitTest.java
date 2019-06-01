package com.busyqa.jobbank;

import com.busyqa.course.pojo.City;
import com.busyqa.course.repo.CityRepositoryImpl;
import com.busyqa.course.service.CityDataService;
import com.busyqa.project.jobbank.JobbankService;
import com.busyqa.project.jobbank.pojo.Job;
import com.busyqa.project.jobbank.pojo.JobCompany;
import com.busyqa.project.jobbank.pojo.JobType;
import com.busyqa.project.jobbank.repo.JobRepository;
import com.busyqa.project.jobbank.repo.JobTypeRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class JobServiceUnitTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobbankService jobbankService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void anotherTest() {

    }

    @Test
    public void testAddJob() {

        // Create a job
        Job aMockJob = new Job(null, null,
                "Software Engineer", "Coding", "College degree", "Toronto", 55000l);

        // make a mock repository response
        when(jobRepository.save(any(Job.class))).thenReturn(aMockJob);

        // Save the city, but it will be intercepted by Mokito
        Job newJob = jobbankService.createJob(new Job(null, null,
                "Software Engineer", "Coding", "College degree", "Toronto", 55000l));

//        System.out.println(newJob.getJobCompany());

        // Verify the save
        assertEquals("Software Engineer", newJob.getJobTitle());

        // teardown
        // no need to delete because of mock
    }
}
