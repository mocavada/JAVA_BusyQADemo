package com.busyqa.jobbank;

import com.busyqa.course.controller.RESTController;
import com.busyqa.course.pojo.City;
import com.busyqa.project.jobbank.JobbankController;
import com.busyqa.project.jobbank.pojo.Job;
import com.busyqa.project.jobbank.pojo.JobCompany;
import com.busyqa.project.jobbank.pojo.JobType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JobControllerIntegrationTest {

    @Autowired
    JobbankController jobbankController;

    @Test
    public void testAddJob() {
        // Create a city
        Job aInsertJob = new Job(null, null,
                "Software Engineer", "Coding", "College degree", "Toronto", 55000l);

        // POST our city form bean to the controller; check the outcome
        List<Job> outcome = jobbankController.createJob(aInsertJob);
        outcome.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.getId() > o2.getId()) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

        // Assert THAT the outcome is as expected
        assertThat(outcome.get(outcome.size() - 1).getJobTitle(), is(equalTo("Software Engineer")));


        // teardown
        jobbankController.delJob(outcome.get(outcome.size() - 1).getId());
    }


}
