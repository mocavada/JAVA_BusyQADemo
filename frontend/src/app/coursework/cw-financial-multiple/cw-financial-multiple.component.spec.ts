import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CwFinancialMultipleComponent } from './cw-financial-multiple.component';

describe('CwFinancialMultipleComponent', () => {
  let component: CwFinancialMultipleComponent;
  let fixture: ComponentFixture<CwFinancialMultipleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CwFinancialMultipleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CwFinancialMultipleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should create', () => {
    expect(component).toBeTruthy();
  });
});
