import { TestBed } from '@angular/core/testing';

import { CovidVerificationService } from './covid-verification.service';

import {HttpClientModule} from '@angular/common/http'
import { Covid } from '../models/covidVerification';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ComponentFixture } from '@angular/core/testing';


describe('CovidVerificationService', () => {
  
  let httpMock: HttpTestingController;

  let covidVerificationService: CovidVerificationService;
  let service: CovidVerificationService;

  beforeEach(() => {

    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule], 
      providers: [CovidVerificationService]

    });
    httpMock = TestBed.inject(HttpTestingController);
    service = TestBed.inject(CovidVerificationService);

  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  it('should return covid when addCovid called', () => {
    service.addCovid(new Covid).subscribe((result: Covid) => {
      expect(result).toEqual(new Covid)
    })
    const req = httpMock.expectOne(`http://localhost:8080/covid`, 'create new covid');
    expect(req.request.method).toBe('POST');

    req.flush(new Covid);

    httpMock.verify();

  });

  // it('should return a covid when getting covid',()=>{
  //   service.getCovid().subscribe((result:Covid) =>{
  //     expect(result).toEqual(new Covid)
  //   })

  // })

  it('should return posts by userId when getPostByUserId called', () => {
    service.getCovid().subscribe((result: any) => {
      expect(result).toEqual(jasmine.arrayContaining(typeof Covid));
    })

    const req = httpMock.expectOne(`http://localhost:8080/covid`, 'get posts by user id');

    expect(req.request.method).toBe('GET');

    req.flush(jasmine.arrayContaining(typeof Covid));

    httpMock.verify();
  })



});
