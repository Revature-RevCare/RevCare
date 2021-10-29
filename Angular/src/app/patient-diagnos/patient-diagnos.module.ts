import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OldActiveCaseComponent } from './components/old-active-case/old-active-case.component';
import { PatientFormComponent } from './components/patient-form/patient-form.component';
import { DoctorFormComponent } from './components/doctor-form/doctor-form.component';



@NgModule({
  declarations: [
    OldActiveCaseComponent,
    PatientFormComponent,
    DoctorFormComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PatientDiagnosModule { }
