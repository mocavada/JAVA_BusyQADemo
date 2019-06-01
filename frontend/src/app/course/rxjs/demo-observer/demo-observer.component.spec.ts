import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoObserverComponent } from './demo-observer.component';

describe('DemoObserverComponent', () => {
  let component: DemoObserverComponent;
  let fixture: ComponentFixture<DemoObserverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoObserverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoObserverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
