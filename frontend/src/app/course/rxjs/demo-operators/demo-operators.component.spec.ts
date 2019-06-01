import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoOperatorsComponent } from './demo-operators.component';

describe('DemoOperatorsComponent', () => {
  let component: DemoOperatorsComponent;
  let fixture: ComponentFixture<DemoOperatorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoOperatorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoOperatorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
