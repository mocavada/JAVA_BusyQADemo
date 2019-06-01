package com.busyqa.project.jobbank.repo;

import com.busyqa.project.jobbank.pojo.Job;
import com.busyqa.project.jobbank.pojo.JobCompany;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
    Job findFirst1ByJobTitle(String jobTitle);

}

