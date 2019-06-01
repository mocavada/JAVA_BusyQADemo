package com.busyqa.project.jobbank.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Job")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)//(fetch = FetchType.EAGER)
    // @JoinColumn(name = "job_company_id", referencedColumnName = "id")
//    @JsonManagedReference
    private JobCompany jobCompany;

//    private String jobCompanyName;

    @ManyToOne//(fetch = FetchType.EAGER)
    //@JoinColumn(name = "job_type_id", referencedColumnName = "id")
//    @JsonManagedReference
    private JobType jobType;

    private String jobTitle;

    private String jobDescription;

    private String requirement;

    private String location;

    private Long salary;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "past_date", insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date postDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JobCompany getJobCompany() {
        return jobCompany;
    }

    public void setJobCompany(JobCompany jobCompany) {
        this.jobCompany = jobCompany;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }


    public Job(JobCompany jobCompany, JobType jobType, String jobTitle, String jobDescription, String requirement, String location, Long salary) {
        this.jobCompany = jobCompany;
        this.jobType = jobType;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.requirement = requirement;
        this.location = location;
        this.salary = salary;
    }

    public Job() {
    }
}
