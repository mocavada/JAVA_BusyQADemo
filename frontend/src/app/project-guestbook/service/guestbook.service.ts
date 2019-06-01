import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/index';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Message} from '../pojo/message';
import {Job} from '../../project-jobbank/pojo/job';

@Injectable({
  providedIn: 'root'
})
export class GuestbookService {

  private urlRoot = environment.serverAddress;

  constructor(private http: HttpClient) {
  }

  // ========
  private results = new BehaviorSubject<[Message]>(null);
  currentMessage = this.results.asObservable();

  // ========
  getData() {
    this.http
      .get<[Message]>(this.urlRoot + '/messages')
      .subscribe(data => {
        this.results.next(data);
      }, err => {
        console.log('Something went wrong!');
      });
  }

  // ========
  postData(msg: Message) {
    this.http
      .post<[Message]>(this.urlRoot + '/message', msg)
      .subscribe(data => {
        this.results.next(data);
        console.log(data);
      }, err => {
        console.log('Something went wrong!');
      });
  }
}
