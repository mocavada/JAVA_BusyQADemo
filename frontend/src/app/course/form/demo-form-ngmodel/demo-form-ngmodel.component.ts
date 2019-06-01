import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-demo-form-ngmodel',
  templateUrl: './demo-form-ngmodel.component.html',
  styleUrls: ['./demo-form-ngmodel.component.css']
})
export class DemoFormNgmodelComponent implements OnInit {
  variableX;
  variableY;
  variableZ;

  constructor() {
  }

  ngOnInit() {
    this.variableX = {
      userName: 'CasearA'
    };
    this.variableY = {
      userName: 'CasearB'
    };
    this.variableZ = {
      userName: 'CasearC'
    };
  }

}
