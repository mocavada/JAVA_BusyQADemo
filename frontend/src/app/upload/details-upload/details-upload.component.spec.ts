import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsUploadComponent } from './details-upload.component';

describe('DetailsUploadComponent', () => {
  let component: DetailsUploadComponent;
  let fixture: ComponentFixture<DetailsUploadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsUploadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should be created', () => {
    expect(component).toBeTruthy();
  });
});
