import {JobPostUser} from '../pojo/job-post-user';
import {JobType} from '../pojo/job-type';
import {Injectable} from '@angular/core';
import {BehaviorSubject, Subject, Observable, pipe} from 'rxjs';

import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, retry} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Job} from '../pojo/job';
import {map, take} from 'rxjs/operators';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JobbankService {
  fackLoginFlag = false;
  // ========get job type
  jobTypeList = new BehaviorSubject<[JobType]>(null);

  constructor(private http: HttpClient) {
  }

  // ========get jobs
  results = new BehaviorSubject<[Job]>(null);

  getData() {
    this.http
      .get<[Job]>(environment.serverAddress + '/jobs', {withCredentials: true})
      .subscribe(data => {
        this.results.next(data);
      }, err => {
        console.log('Something went wrong!');
      });
  }

  pullJobTypeList(jobTypeList: [JobType]) {
    this.jobTypeList.next(jobTypeList);
  }

  getJobTypeList() {
    this.http
      .get<[JobType]>(environment.serverAddress + '/jobtypes', {withCredentials: true})
      .subscribe(data => {
        this.pullJobTypeList(data);
      });
  }

  // ========post job
  postJob(job: Job) {
    this.http
      .post<any>(environment.serverAddress + '/job', job, {withCredentials: true})
      .subscribe(data => {
        console.log(data);
        this.results.next(data);
      }, err => {
        console.log('Something went wrong!');
      });
  }

  // ========edit job
  editJob(job: Job) {
    return this.http.patch<any>(environment.serverAddress + '/job', job, {withCredentials: true});

  }

  // ========delete job
  delJob(job: Job) {
    // notice: delete only have two argument, so you can only pass on the url with id or title
    return this.http.delete<any>(environment.serverAddress + '/job/' + job.id, {withCredentials: true});
  }

  // ========login
  login(jobPostUser: JobPostUser) {
    return this.http.post<JobPostUser>(environment.serverAddress + '/login', jobPostUser, {withCredentials: true});
  }

  // ========check-login
  checkLogin(): Observable<any> {
    return this.http.get(environment.serverAddress + '/checklogin', {withCredentials: true})
      .pipe(map((response: Response) => {
          console.log(response);
          return response;
        }, catchError(error => {
          return Observable.throw(error);
        }))
      );
  }


}
