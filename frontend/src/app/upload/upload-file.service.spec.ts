import { TestBed, inject } from '@angular/core/testing';

import { UploadFileService } from './upload-file.service';

describe('UploadFileService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UploadFileService]
    });
  });

  xit('should be created', inject([UploadFileService], (service: UploadFileService) => {
    expect(service).toBeTruthy();
  }));
});
