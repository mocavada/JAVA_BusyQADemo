import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoHttpserviceComponent } from './demo-httpservice.component';

describe('DemoHttpserviceComponent', () => {
  let component: DemoHttpserviceComponent;
  let fixture: ComponentFixture<DemoHttpserviceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoHttpserviceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoHttpserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should create', () => {
    expect(component).toBeTruthy();
  });
});
