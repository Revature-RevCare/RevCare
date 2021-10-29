import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CovidVerificationComponent } from './covid-verification.component';

describe('CovidVerificationComponent', () => {
  let component: CovidVerificationComponent;
  let fixture: ComponentFixture<CovidVerificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CovidVerificationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CovidVerificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('testing component',()=>{
    expect(component.ngOnInit()).toBeTruthy;
  });

  it('testing covid result',()=>{
    expect(component.onSubmit).toBe(false);
  });
  
});
