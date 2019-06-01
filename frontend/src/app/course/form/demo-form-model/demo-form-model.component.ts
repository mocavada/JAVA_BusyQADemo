import { FormGroup, FormControl, FormBuilder, FormArray, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-demo-form-model',
  templateUrl: './demo-form-model.component.html',
  styleUrls: ['./demo-form-model.component.css']
})
export class DemoFormModelComponent implements OnInit {
  langs: string[] = [
    'English',
    'French',
    'German',
  ];
  myform: FormGroup;
  constructor(private fb: FormBuilder, private http: HttpClient) {
  }
  ngOnInit() {
    // choose one of them to bind form
    // (1)
    this.byInitilization();

    // (2)
    // this.byFormBuilder();
  }

  byInitilization() {
    this.myform = new FormGroup({
      name: new FormGroup({
        firstName: new FormControl('', Validators.required),
        lastName: new FormControl('', Validators.required),
      }),
      email: new FormControl('', Validators.email),
      password: new FormControl('ABCabc123', Validators.compose([
        Validators.pattern('^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$'),
        Validators.max(2)
      ])),
      language: new FormControl()
    });
  }

  byFormBuilder() {
    this.myform = this.fb.group({
      name: this.fb.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required]
      }),
      email: ['default', Validators.email],
      password: ['ABCabc123', Validators.compose([Validators.pattern('^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$'), Validators.required])],
      language: ''
    });
  }

  onSubmit(f) {

    console.log(f.value.name.firstName);
    console.log(f.value);

    // Check it offline
    // if (f.valid) {
    //   console.log('This form is good to go.');
    // }

    // Post it back to server
    if (f.valid) {
      this.http
        .post<any>(environment.serverAddress + "/angular-model-form-demo", f.value)
        .subscribe(data => {
          if (data.formStatus) {

          }
          console.log(data);
        }, err => {
          console.log('Client: Something went wrong!');
          console.log(err);
        });
    } else {
      console.log("Form is not valid");
    }

  }
}
