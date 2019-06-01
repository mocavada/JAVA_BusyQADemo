import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CwFinancialSubComponent } from './cw-financial-sub.component';

describe('CwFinancialSubComponent', () => {
  let component: CwFinancialSubComponent;
  let fixture: ComponentFixture<CwFinancialSubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CwFinancialSubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CwFinancialSubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should create', () => {
    expect(component).toBeTruthy();
  });
});
