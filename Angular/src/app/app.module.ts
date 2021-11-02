import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NursesComponent } from './components/nurses/nurses.component';
import { DoctorsComponent } from './components/doctors/doctors.component';
import { DiagnosisComponent } from './components/diagnosis/diagnosis.component';
import { CovidComponent } from './components/covid/covid.component';
import { DoctorFormComponent } from './patient-diagnos/components/doctor-form/doctor-form.component';
import { OldActiveCaseComponent } from './patient-diagnos/components/old-active-case/old-active-case.component';
import { PatientFormComponent } from './patient-diagnos/components/patient-form/patient-form.component';
import { CovidVerificationComponent } from './components/covidVerification/covid-verification.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NursesComponent,
    DoctorsComponent,
    DiagnosisComponent,
    CovidComponent,
    DoctorFormComponent,
    OldActiveCaseComponent,
    PatientFormComponent,
    CovidVerificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpClient
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
