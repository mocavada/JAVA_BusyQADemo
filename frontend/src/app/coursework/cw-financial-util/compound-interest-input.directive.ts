import {Directive, EventEmitter, HostListener, Input, OnChanges, Output} from '@angular/core';

@Directive({
  selector: '[appCompoundInterestInput]'
})
export class CompoundInterestInputDirective implements OnChanges  {

  @Input('depositInput') depositInputVariable;
  @Input('interestRateInput') interestRateInputVariable;
  @Input('yearInput') yearInputVariable;

  @Output()
  afterCalculate = new EventEmitter();

  resultVariable;

  constructor() {
  }


  @HostListener('change') ngOnChanges() {
    console.log('changeTriggered');


    this.depositInputVariable = Number(this.depositInputVariable);
    this.interestRateInputVariable = Number(this.interestRateInputVariable);
    this.yearInputVariable = Number(this.yearInputVariable);
    this.resultVariable = this.depositInputVariable * (Math.pow(1 + this.interestRateInputVariable * 0.01, this.yearInputVariable));


    // console.log([this.deposit2, this.interestRate2, this.year2, this.result2]);


    this.afterCalculate.emit(this.resultVariable);
  }


}
