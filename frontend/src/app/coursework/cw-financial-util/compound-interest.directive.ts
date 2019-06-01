import {Directive, EventEmitter, HostListener, Input, Output} from '@angular/core';

@Directive({
  selector: '[appCompoundInterest]'
})
export class CompoundInterestDirective {
  @Input('deposit2') deposit2;
  @Input('interestRate2') interestRate2;
  @Input('year2') year2;

  @Output()
  afterCalculate = new EventEmitter();

  result2;
  numberOfClicks = 0;

  constructor() {
  }


  @HostListener('click') onClick(btn) {

    console.log('button', btn, 'number of clicks:', this.numberOfClicks++);


    this.deposit2 = Number(this.deposit2);
    this.interestRate2 = Number(this.interestRate2);
    this.year2 = Number(this.year2);
    this.result2 = this.deposit2 * (Math.pow(1 + this.interestRate2 * 0.01, this.year2));


    // console.log([this.deposit2, this.interestRate2, this.year2, this.result2]);


    this.afterCalculate.emit(this.result2);
  }
}
