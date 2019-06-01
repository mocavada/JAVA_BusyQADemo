import {Component, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-demo-datashare-output',
  templateUrl: './demo-datashare-output.component.html',
  styleUrls: ['./demo-datashare-output.component.css']
})
export class DemoDataShareOutputComponent implements OnInit {
  @Output()
  outputEvent = new EventEmitter();

  outputCounter = 0;
  outputConent = ' from [child]-[ts]-[outputEvent.emit]';

  constructor() {
  }

  ngOnInit() {
    // this.outputEvent.emit(++this.outputCounter + this.outputConent);
  }

  triggerOutput() {
    this.outputEvent.emit(++this.outputCounter + this.outputConent);
  }
}
