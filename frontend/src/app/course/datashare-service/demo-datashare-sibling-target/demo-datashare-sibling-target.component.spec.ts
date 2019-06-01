/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { DemoDatashareSiblingTargetComponent } from './demo-datashare-sibling-target.component';

describe('DemoDatashareServiceComponent', () => {
  let component: DemoDatashareSiblingTargetComponent;
  let fixture: ComponentFixture<DemoDatashareSiblingTargetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoDatashareSiblingTargetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoDatashareSiblingTargetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
