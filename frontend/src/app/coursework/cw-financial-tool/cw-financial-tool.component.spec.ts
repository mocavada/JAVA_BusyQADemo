import { ReactiveFormsModule } from '@angular/forms';
/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { CwFinancialToolComponent } from './cw-financial-tool.component';
import { FormsModule } from '@angular/forms';

describe('CwFinancialToolComponent', () => {
  let component: CwFinancialToolComponent;
  let fixture: ComponentFixture<CwFinancialToolComponent>;
  let amountEl: DebugElement;
  let annuityEl: DebugElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CwFinancialToolComponent],
      imports: [FormsModule, ReactiveFormsModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CwFinancialToolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    amountEl = fixture.debugElement.query(By.css('input[id=amount]'));
    annuityEl = fixture.debugElement.query(By.css('input[id=annuity]'));
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('test', () => {
    // expect(component.doTheAddition(6)).toEqual(10);
    // let amount;
    // component.loggedIn.subscribe((value) => amount = value);
    annuityEl.nativeElement.value = 100;
    amountEl.nativeElement.value = annuityEl.nativeElement.value * 1.5;
    console.log(amountEl.nativeElement.value);
    expect(amountEl.nativeElement.value).toBe('150');
  });
});
