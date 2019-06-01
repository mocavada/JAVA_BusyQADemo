import { Component, OnInit } from '@angular/core';
import { Observable, of, BehaviorSubject, Subject, ReplaySubject } from 'rxjs';
import 'rxjs/add/observable/interval';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/merge';


import { take, map, filter, mergeMap, switchMap } from 'rxjs/operators';


@Component({
  selector: 'app-demo-operators',
  templateUrl: './demo-operators.component.html',
  styleUrls: ['./demo-operators.component.css']
})
export class DemoOperatorsComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    this.merge();
  }

  merge() {
    const oeLetter = Observable.of('a', 'b', 'c');
    const oeNumber = Observable.interval(1000);
    const oeCombine = Observable.merge(oeLetter, oeNumber).pipe(take(10));
    oeCombine.subscribe(x => console.log(x));
  }

  switchMap() {
    const oeLetter = Observable.of('a', 'b', 'c');
    const oeNumber = Observable.interval(1000);

    const oeCombine = oeLetter.pipe(switchMap(l =>
      oeNumber.pipe(take(5)).pipe(map(n => l + n))
    ));

    oeCombine.subscribe(x => console.log(x));
  }

  testMap() {
    const oeLetter = Observable.of('a', 'b', 'c');
    const oeNumber = Observable.interval(1000);

    const oeCombine = oeLetter.pipe(mergeMap(l =>
      oeNumber.pipe(take(5)).pipe(map(n => l + n))
    ));

    oeCombine.subscribe(x => console.log(x));
  }

  testOperators() {
    // generate number every second
    const oeNumber = Observable.interval(1000);
    // ========
    const example1 = oeNumber.pipe(take(5));
    example1.subscribe(x => console.log('take():' + x));

    const example2 = oeNumber.pipe(take(5)).pipe(map(val => val + 10));
    example2.subscribe(x => console.log('map():' + x));

    const example3 = oeNumber.pipe(take(5)).pipe(map(val => val + 10)).pipe(filter(val => (val % 2) != 1));
    example3.subscribe(x => console.log('filter:' + x));
  }

  // ========
  subject;
  count = 0;

  testReplaySubject() {
    this.subject = new Subject();  // 0 is the initial value
    setInterval(() => {
      this.subject.next(this.count++);
    }, 2000);


    this.subject.subscribe(
      (v: any) => {
        console.log('observerA: ' + v);
      } // output initial value, then new values on `next` triggers
    );


  }

}
