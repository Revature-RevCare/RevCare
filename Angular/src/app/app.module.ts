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
import { HeaderComponent } from './components/includes/header/header.component';
import { FooterComponent } from './components/includes/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { HeroComponent } from './components/hero/hero.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NursesComponent,
    DoctorsComponent,
    DiagnosisComponent,
    CovidComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    HeroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
