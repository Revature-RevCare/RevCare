import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< HEAD
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NursesComponent } from './components/nurses/nurses.component';
import { DoctorsComponent } from './components/doctors/doctors.component';
import { DiagnosisComponent } from './components/diagnosis/diagnosis.component';
import { CovidComponent } from './components/covid/covid.component';
=======
import { DoctorFormComponent } from './patient-diagnos/components/doctor-form/doctor-form.component';
import { OldActiveCaseComponent } from './patient-diagnos/components/old-active-case/old-active-case.component';
import { PatientFormComponent } from './patient-diagnos/components/patient-form/patient-form.component';
>>>>>>> 6cf58c2a470e22069ca504d7f4e1ee00981da2d2

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    LoginComponent,
    RegisterComponent,
    NursesComponent,
    DoctorsComponent,
    DiagnosisComponent,
    CovidComponent
=======
    DoctorFormComponent,
    OldActiveCaseComponent,
    PatientFormComponent
>>>>>>> 6cf58c2a470e22069ca504d7f4e1ee00981da2d2
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
