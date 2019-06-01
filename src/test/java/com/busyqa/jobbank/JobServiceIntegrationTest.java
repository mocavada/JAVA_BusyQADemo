package com.busyqa.jobbank;

import com.busyqa.project.jobbank.JobbankService;
import com.busyqa.project.jobbank.pojo.Job;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class JobServiceIntegrationTest {


    @Autowired
    private JobbankService jobbankService;

    @Test
    public void testAddJob() {
        // Create a job
        Job aInsertJob = new Job(null, null,
                "Software Engineer", "Coding", "College degree", "Toronto", 55000l);

        // save the job to the DB
        Job savedReturnJob = jobbankService.createJob(aInsertJob);

        // Verify the save
        assertEquals(aInsertJob.getJobTitle(), savedReturnJob.getJobTitle());

        // Verify the addition
        assertNotNull(savedReturnJob);


        // teardown
        jobbankService.delete(savedReturnJob.getId());
    }

//
}
