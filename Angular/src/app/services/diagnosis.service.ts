import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { patientForm } from 'src/app/models/patientDiagnos';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class DiagnosisService{
    private apiServerUrl = environment.baseUrl;
    constructor(private http: HttpClient){}

    public addPatientDiagnosis(patientDiagnos: string): Observable<patientForm> {
        let headers = {'content-type':"application/json"}
        return this.http.post<patientForm>(`${this.apiServerUrl}/diagnosis/add`, patientDiagnos,{'headers':headers});
      }

    // public updatePatientDiagnosis(patientDiagnos: patientForm): Observable<patientForm> {
    //     return this.http.post<patientForm>(`${this.apiServerUrl}/diagnosis/put/update`, patientDiagnos);
    // }

    public updatePatientDiagnosis(patientDiagnos: string): Observable<patientForm> {
      let headers = {'content-type':"application/json"}
      return this.http.post<patientForm>(`${this.apiServerUrl}/diagnosis/put/update`, patientDiagnos,{'headers':headers});
    }
    
}