import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoPromiseComponent } from './demo-promise.component';

describe('DemoPromiseComponent', () => {
  let component: DemoPromiseComponent;
  let fixture: ComponentFixture<DemoPromiseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoPromiseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoPromiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
