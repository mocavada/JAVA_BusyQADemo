import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-cw-financial-multiple',
  templateUrl: './cw-financial-multiple.component.html',
  styleUrls: ['./cw-financial-multiple.component.css']
})
export class CwFinancialMultipleComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

// ======== Fomula 2
  deposit2;
  interestRate2;
  year2;
  result2;

  onAdd() {

    this.deposit2 = Number(this.deposit2);
    this.interestRate2 = Number(this.interestRate2);
    this.year2 = Number(this.year2);
    // this.result2 = this.deposit2 * ((1 + this.interestRate2 * 0.01) ^ this.year2);
    // this.result2 = this.deposit2 * (Math.pow(1 + this.interestRate2 * 0.01, this.year2));

    console.log(this.deposit2 + ':' + this.interestRate2 + ':' + this.year2);

  }


  // ======== From other component
  showResultFromOtherComponent($event) {
    this.result2 = $event;


  }


  // ======== Fomula 2
  deposit4;
  interestRate4;
  year4;
  result4;

  showResultFromDirectiveChanged($event) {

    if (!isNaN($event)) {
      this.result4 = $event;
    }


  }
}
