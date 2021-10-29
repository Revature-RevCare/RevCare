import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorFormComponent } from './patient-diagnos/components/doctor-form/doctor-form.component';
import { OldActiveCaseComponent } from './patient-diagnos/components/old-active-case/old-active-case.component';
import { PatientFormComponent } from './patient-diagnos/components/patient-form/patient-form.component';

@NgModule({
  declarations: [
    AppComponent,
    DoctorFormComponent,
    OldActiveCaseComponent,
    PatientFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
