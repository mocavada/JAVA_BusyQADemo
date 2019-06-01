import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-demo-observer',
  templateUrl: './demo-observer.component.html',
  styleUrls: ['./demo-observer.component.css']
})
export class DemoObserverComponent implements OnInit {

  constructor() {

  }

  myObservable

  ngOnInit() {

    // send data
    this.myObservable = new Observable(observer => {
      observer.next('Hey');
      observer.next('Hey');
      observer.next('Hey');
      observer.next('Hey');
      observer.error('err');
      observer.complete();
    });
    let sum = 0;
    // execute and process data
    this.myObservable.subscribe(
      (x) => {
        console.log(sum++);
        console.log(x);
      },
      (x) => console.log('error:' + x),
      () => console.log('completed')
    );


  }

  ngOnDestory() {
    this.myObservable.unsubscribe();
  }


}
