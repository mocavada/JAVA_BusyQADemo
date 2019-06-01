import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoFormNgmodelComponent } from './demo-form-ngmodel.component';

describe('DemoFormNgmodelComponent', () => {
  let component: DemoFormNgmodelComponent;
  let fixture: ComponentFixture<DemoFormNgmodelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoFormNgmodelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoFormNgmodelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should create', () => {
    expect(component).toBeTruthy();
  });
});
