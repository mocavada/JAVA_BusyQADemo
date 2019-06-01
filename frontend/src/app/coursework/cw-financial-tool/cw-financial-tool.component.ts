import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-financial-tool',
  templateUrl: './cw-financial-tool.component.html',
  styleUrls: ['./cw-financial-tool.component.css']
})
export class CwFinancialToolComponent {
  // ======== Fomula 1
  annuity;
  interestRate;
  ammount;
  period;

  deposit;

  result;

  cal() {
    this.result =

      this.annuity
      * (((1 + (this.interestRate / 12)) * (12 * this.period)) - 1)
      / (this.interestRate / 12)
      * (1 + (this.interestRate / 12));;
  }





}
