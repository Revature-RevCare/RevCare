import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
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

//   it("Should show options when toggle option is clicked",fakeAsync(() => {
//     fixture.detectChanges();
//     let toggleButton = fixture.debugElement.queryAll(By.css('[covidStatus]'));
//     toggleButton[0].nativeElement.click();
//     tick();
//     fixture.detectChanges();
//     let list = fixture.debugElement.queryAll(By.css('select.covidStatus'));  
//     console.log(list[0]);
// }));
  
});
