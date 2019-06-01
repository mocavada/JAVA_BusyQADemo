import { JobType } from '../pojo/job-type';
import { JobbankService } from './../service/jobbank.service';
import { HttpClient } from '@angular/common/http';
import { Job } from '../pojo/job';
import { FormGroup, FormControl, FormBuilder, FormArray, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-jobpost',
  templateUrl: './jobpost.component.html',
  styleUrls: ['./jobpost.component.css']
})
export class JobpostComponent implements OnInit {
  jobCreateForm: FormGroup;
  jobTypeList;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private dService: JobbankService) {
  }

  ngOnInit() {
    this.createForm();
    this.dService.jobTypeList.subscribe(data => {
      if (data != null) {
        console.log(data);
        this.jobTypeList = data;
      }
    });
    this.dService.getJobTypeList();
  }

  createForm() {
    this.jobCreateForm = this.fb.group({
      jobCompany: this.fb.group({
        companyName: [''],
        contactor: [''],
        email: ['', Validators.email],
        phonenumber: ['']
      }),
      // jobCompanyName: [''],
      jobTitle: [''],
      jobType: this.fb.group({
        id: [0],
      }),
      jobDescription: '',
      requirement: '',
      location: '',
      salary: '',
    });
  }

  onSubmit(f) {
    if (f.valid) {
      console.log('This form is good to go.');
      this.dService.postJob(f.value);
    } else {
      // f.value.jobType = parseInt(f.value.jobType, 0);
      console.log(f.value);
      // this.devjson = f.value;
    }


  }
}
