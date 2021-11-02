import { TestBed } from '@angular/core/testing';

import { CovidVerificationService } from './covid-verification.service';


describe('CovidVerificationService', () => {
  
  let covidVerificationService: CovidVerificationService;
  let service: CovidVerificationService;


  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CovidVerificationService);

  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  

});
