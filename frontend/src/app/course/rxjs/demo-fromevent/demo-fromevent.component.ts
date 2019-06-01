import {Component, OnInit} from '@angular/core';
import {fromEvent} from 'rxjs/Observable/fromEvent';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-demo-fromevent',
  templateUrl: './demo-fromevent.component.html',
  styleUrls: ['./demo-fromevent.component.css']
})
export class DemoFromeventComponent implements OnInit {


  constructor() {
  }


  ngOnInit() {
    // const source = fromEvent(document, 'mousemove');
    // const example = source.pipe(map(event => `Event time: ${event.timeStamp}`));
    // const subscribe = example.subscribe(val => console.log(val));


    const source = fromEvent(document, 'click');
    const subscription = source.subscribe((e: MouseEvent) => {
      // console.log(e);
      console.log(e.x + ', ' + e.y);
    });

  }

}
