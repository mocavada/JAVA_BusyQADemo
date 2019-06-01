package com.busyqa.jobbank;

import com.busyqa.project.jobbank.pojo.Job;
import com.busyqa.project.jobbank.pojo.JobCompany;
import com.busyqa.project.jobbank.pojo.JobType;
import com.busyqa.project.jobbank.repo.JobRepository;
import com.busyqa.project.pictureupload.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JobRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private JobRepository jobRepository;

    @MockBean
    StorageService storageService;

    @Test
    public void testFindByName() {

        // Create a Job
        Job job = new Job(null, null,
                "Software Engineer", "Coding", "College degree", "Toronto", 55000l);

        // save test data
//        entityManager.persist(job);
        jobRepository.save(job);

        // Find an inserted record
        Job foundjob = jobRepository.findFirst1ByJobTitle("Software Engineer");

        assertThat(foundjob.getJobTitle(), is(equalTo("Software Engineer")));

        // teardown
//        cityRepositoryImpl.delete(city);
        entityManager.remove(job);
        entityManager.flush();
    }

}
