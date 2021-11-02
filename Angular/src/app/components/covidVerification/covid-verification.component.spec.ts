import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import { CovidVerificationComponent } from './covid-verification.component';
import { Covid } from 'src/app/models/covidVerification';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CovidVerificationService } from 'src/app/services/covid-verification.service';
import { Input } from '@angular/core';


describe('CovidVerificationComponent', () => {
  let service: CovidVerificationService;
  let component: CovidVerificationComponent;
  let fixture: ComponentFixture<CovidVerificationComponent>;
  let httpMock: HttpTestingController;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CovidVerificationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CovidVerificationComponent);
    service = TestBed.inject(CovidVerificationService);
    component = fixture.componentInstance;
    fixture.detectChanges();
    httpMock = TestBed.inject(HttpTestingController);

  });

  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });
  // it('should return covid when addCovid called', () => {
  //   component.addCovid(Input).subscribe((result: Input) => {
  //     expect(result).toEqual(new Input)
  //   })
  //   const req = httpMock.expectOne(`http://localhost:8080/covid`, 'create new covid');
  //   expect(req.request.method).toBe('POST');

  //   req.flush(new Input);

  //   httpMock.verify();

  // });
  
});
