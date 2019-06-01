import { Component, OnInit } from '@angular/core';
import { Observable, of, BehaviorSubject, Subject, ReplaySubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-demo-subject',
  templateUrl: './demo-subject.component.html',
  styleUrls: ['./demo-subject.component.css']
})
export class DemoSubjectComponent implements OnInit {

  constructor() { }

  ngOnInit() {

    // console.log('========Subject');
    // this.testSubject();
    
    // console.log('========BehaviorSubject');
    // this.testBehaviorSubject();

    // console.log('========ReplaySubject');
    this.testReplaySubject();

  }

  replaySubject;
  testReplaySubject() {
    this.replaySubject = new ReplaySubject();  // 0 is the initial value

    this.replaySubject.subscribe(
      (v: any) => { console.log('observerA: ' + v); } // output initial value, then new values on `next` triggers
    );

    this.replaySubject.next(1);  // output new value 1 for 'observer A'
    this.replaySubject.next(2);  // output new value 2 for 'observer A', current value 2 for 'Observer B' on subscription
    this.replaySubject.next('last value');

    this.replaySubject.subscribe(
      (v: any) => { console.log('observerB: ' + v); }  // output current value 2, then new values on `next` triggers
    );

    this.replaySubject.next(3);
  }


  behaviorSubject;
  testBehaviorSubject() {
    this.behaviorSubject = new BehaviorSubject(0);  // 0 is the initial value

    this.behaviorSubject.subscribe(
      (v: any) => { console.log('observerA: ' + v); } // output initial value, then new values on `next` triggers
    );

    this.behaviorSubject.next(1);  // output new value 1 for 'observer A'
    this.behaviorSubject.next(2);  // output new value 2 for 'observer A', current value 2 for 'Observer B' on subscription
    this.behaviorSubject.next('last value');

    this.behaviorSubject.subscribe(
      (v: any) => { console.log('observerB: ' + v); }  // output current value 2, then new values on `next` triggers
    );

    this.behaviorSubject.next(3);
  }

  subject;
  testSubject() {
    this.subject = new Subject();

    this.subject.subscribe(
      (v: any) => { console.log('observerA: ' + v); },
      (x) => console.log('error:' + x),
      () => console.log('completed')
    );
    this.subject.next(1); // observerB will not output this value

  
    this.subject.next(999);

    this.subject.subscribe(
      (v: any) => { console.log('observerB: ' + v); }
    );

    this.subject.next(2);
    this.subject.next(3);
    // this.subject.console.error("errrr");
    
    this.subject.complete();

    this.subject.next(200);
  }

}
