import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-demo-datashare-viewchild',
  templateUrl: './demo-datashare-viewchild.component.html',
  styleUrls: ['./demo-datashare-viewchild.component.css']
})
export class DemoDataShareViewchildComponent implements OnInit {
  defaultValue = 'CCC[child]-[ts]';
  childV = this.defaultValue;

  appendCounter = 0;
  appendCounterStr = '';

  constructor() {
  }

  ngOnInit() {
  }

  appendToMessage() {
    // this.appendCounterStr += ++this.appendCounter + ', ';

    // version 1:
    // const oriString = this.childV.split('_')[1];
    // if (oriString == null) {
    //   this.childV = ++this.appendCounter + '_' + this.childV;
    // } else {
    //   this.childV = ++this.appendCounter + '_' + oriString;
    // }

    // version 2:
    const appStr = this.childV.split('_')[1] == null ? this.childV : this.childV.split('_')[1];
    this.childV = ++this.appendCounter + '_' + appStr;
  }

  resetMessage() {
    this.childV = this.defaultValue;
  }
}
