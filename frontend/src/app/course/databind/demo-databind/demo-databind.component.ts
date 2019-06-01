import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-demo-databind',
  templateUrl: './demo-databind.component.html',
  styleUrls: ['./demo-databind.component.css']
})
export class DemoDatabindComponent implements OnInit {
  messageValue = 'value from [ts] property....';
  cssValue = 'text-danger';
  msg = 0;
  constructor() { }

  ngOnInit() { }

  flag = false;
  
  // oneway-method
  processString(event) {
    this.messageValue = event; // + '=>' + this.messageValue
    
    // change
    if(this.flag = !this.flag){
      this.cssValue = 'text-danger';
    }else{
      this.cssValue = 'text-primary'
    }
    console.log(this.messageValue);

  }
}
