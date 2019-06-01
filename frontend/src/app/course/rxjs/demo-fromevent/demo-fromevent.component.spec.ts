import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoFromeventComponent } from './demo-fromevent.component';

describe('DemoFromeventComponent', () => {
  let component: DemoFromeventComponent;
  let fixture: ComponentFixture<DemoFromeventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoFromeventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoFromeventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
