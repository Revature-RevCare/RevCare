import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { patientForm } from '../models/patientDiagnos';
import { map, catchError } from 'rxjs/operators';
import { DoctorFormComponent } from '../components/doctor-form/doctor-form.component';



@Injectable({
  providedIn: 'root'
})
export class DnnService {

  private baseUrl: string = "http://localhost:8080/diagnosis";

  private headers = {'Content-Type': 'application/json'}

  constructor(private http: HttpClient) { }

  getDiagnosis(): Observable<any> {
    return this.http.get(this.baseUrl + "/all")
    .pipe(
      map(response => response as patientForm[]),
      catchError(err => err)
    )
  };

  getByConfirm(): Observable<any> {
    return this.http.get(this.baseUrl + "/active")
    .pipe(
      map(response => response as patientForm[]),
      catchError(err => err)
    )
  };
}
