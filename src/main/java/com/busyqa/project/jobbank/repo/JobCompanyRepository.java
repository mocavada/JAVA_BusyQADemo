package com.busyqa.project.jobbank.repo;

import com.busyqa.project.jobbank.pojo.JobCompany;
import com.busyqa.project.jobbank.pojo.JobType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCompanyRepository extends PagingAndSortingRepository<JobCompany, Long> {
    JobCompany findFirst1ByCompanyName(String companyName);

    JobCompany findFirst1ById(String companyName);
}

