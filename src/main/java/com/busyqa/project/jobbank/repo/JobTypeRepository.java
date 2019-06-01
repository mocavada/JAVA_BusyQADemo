package com.busyqa.project.jobbank.repo;

import com.busyqa.project.jobbank.pojo.JobCompany;
import com.busyqa.project.jobbank.pojo.JobType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends PagingAndSortingRepository<JobType, Long> {

    JobType findFirst1ByJobTypeName(String jobTypeName);


}

