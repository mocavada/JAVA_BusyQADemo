import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-cw-financial-sub',
  templateUrl: './cw-financial-sub.component.html',
  styleUrls: ['./cw-financial-sub.component.css']
})
export class CwFinancialSubComponent implements OnInit {
  @Input('deposit2') deposit2;
  @Input('interestRate2') interestRate2;
  @Input('year2') year2;

  @Output()
  afterCalculate = new EventEmitter();

  result2;
  constructor() { }

  ngOnInit() {
  }
  onAdd() {


    this.deposit2 = Number(this.deposit2);
    this.interestRate2 = Number(this.interestRate2);
    this.year2 = Number(this.year2);
    this.result2 = this.deposit2 * (Math.pow(1 + this.interestRate2 * 0.01, this.year2));

    this.afterCalculate.emit(this.result2);
  }
}
