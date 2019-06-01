import { JobbankService } from './../project-jobbank/service/jobbank.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { map, take } from 'rxjs/operators';
import { catchError, retry } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { BehaviorSubject, Subject, Observable, pipe } from 'rxjs';
import { of } from 'rxjs';

@Component({
  selector: 'app-exp-cookie-session',
  templateUrl: './exp-cookie-session.component.html',
  styleUrls: ['./exp-cookie-session.component.css']
})
export class ExpCookieSessionComponent implements OnInit {

  constructor(private http: HttpClient, private auth: JobbankService) { }

  ngOnInit() {




  }
  onClickMe() {
    this.http.get<string[]>(environment.serverAddress + '/checklogin', { withCredentials: true }).subscribe(response => {
      console.log('checklogin');
    });
    this.http.get<string[]>(environment.serverAddress + '/checkCount', { withCredentials: true }).subscribe(response => {
      console.log(response);
    });
  }
}
