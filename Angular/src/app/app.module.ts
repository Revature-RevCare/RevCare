import { HttpClientModule } from '@angular/common/http';
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
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { BoardModeratorComponent } from './components/board-moderator/board-moderator.component';
import { BoardUserComponent } from './components/board-user/board-user.component';
// import { OldActiveCaseComponent } from './components/old-active-case/old-active-case.component';
// import { CovidVerificationService } from './services/covid-verification.service';
import { HeaderComponent } from './components/includes/header/header.component';
import { FooterComponent } from './components/includes/footer/footer.component';
import { HeroComponent } from './components/hero/hero.component';
import { OldActiveCaseComponent } from './components/old-active-case/old-active-case.component';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { CookieService } from 'ngx-cookie-service';
import { DoctorFormComponent } from './components/doctor-form/doctor-form.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NursesComponent,
    DoctorsComponent,
    DiagnosisComponent,
    // OldActiveCaseComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    HeroComponent,
    OldActiveCaseComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    OldActiveCaseComponent,
    DoctorFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders, CookieService],
  
  exports: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
