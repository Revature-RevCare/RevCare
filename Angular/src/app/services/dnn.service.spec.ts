import { TestBed } from '@angular/core/testing';

import { DnnService } from './dnn.service';

describe('DnnService', () => {
  let service: DnnService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DnnService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
