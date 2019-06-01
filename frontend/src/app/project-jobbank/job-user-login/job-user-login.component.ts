import {JobbankService} from './../service/jobbank.service';
import {FormGroup, FormBuilder} from '@angular/forms';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-job-user-login',
  templateUrl: './job-user-login.component.html',
  styleUrls: ['./job-user-login.component.css']
})
export class JobUserLoginComponent implements OnInit {
  jobUserLoginForm: FormGroup;
  devjson;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private dService: JobbankService) {
  }

  ngOnInit() {
    this.createForm();

  }

  createForm() {
    this.jobUserLoginForm = this.fb.group({
      userName: '',
      password: ''
    });
  }

  onSubmit(f) {
    this.dService.fackLoginFlag = true;
    console.log('fackLoginFlag = ' + this.dService.fackLoginFlag);

    if (f.valid) {
      console.log('This form is good to go.');
    }
    // f.value.jobType = parseInt(f.value.jobType, 0);
    console.log(f.value);
    this.devjson = f.value;
    this.dService.login(f.value)
      .subscribe(data => {
        console.log(data);
        // after login, move the page to create job
        this.router.navigate(['/PostJob']);
      }, err => {
        console.log('Something went wrong!');
      });

  }

  logout() {
    this.dService.fackLoginFlag = false;
    console.log('fackLoginFlag = ' + this.dService.fackLoginFlag);
  }
}
