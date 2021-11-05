import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { patientForm } from 'src/app/models/patientDiagnos';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class DiagnosisService{
    private apiServerUrl = environment.baseUrl;
    constructor(private http: HttpClient){}

    public addPatientDiagnosis(patientDiagnos: patientForm): Observable<patientForm> {
        //header here
        return this.http.post<patientForm>(`${this.apiServerUrl}/diagnosis/add`, patientDiagnos);
      }

    public updatePatientDiagnosis(patientDiagnos: patientForm): Observable<patientForm> {
        return this.http.post<patientForm>(`${this.apiServerUrl}/diagnosis/put/update`, patientDiagnos);
      }
    
}