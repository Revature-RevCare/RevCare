import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NursesComponent } from './components/nurses/nurses.component';
import { DoctorsComponent } from './components/doctors/doctors.component';
import { DiagnosisComponent } from './components/diagnosis/diagnosis.component';
import { CovidComponent } from './components/covid/covid.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { BoardModeratorComponent } from './components/board-moderator/board-moderator.component';
import { BoardUserComponent } from './components/board-user/board-user.component';
import { DoctorFormComponent } from './patient-diagnos/components/doctor-form/doctor-form.component';
import { OldActiveCaseComponent } from './patient-diagnos/components/old-active-case/old-active-case.component';
import { PatientFormComponent } from './patient-diagnos/components/patient-form/patient-form.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
import { authInterceptorProviders } from './helpers/auth.interceptor';



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
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
