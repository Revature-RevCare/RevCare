import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { patientForm } from '../models/patientDiagnos';
import { map, catchError } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';


@Injectable({
  providedIn: 'root'
})
export class DnnService {

  private baseUrl: string = "http://localhost:8080/diagnosis";

  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) { }

  jwtToken = this.tokenStorage.getUser();

  headers = new HttpHeaders().set('content-type', 'application/json')
                             .set('Access-Control-Allow-Origin', '*')
                             .set('Authorization', this.jwtToken);

  getDiagnosis(): Observable<any> {
    this.setHeaders();
    return this.http.get(this.baseUrl + "/all")
    .pipe(
      map(response => response as patientForm[]),
      catchError(err => err)
    )
  };

  getByConfirm(): Observable<any> {
    this.setHeaders();
    return this.http.get(this.baseUrl + "/active")
    .pipe(
      map(response => response as patientForm[]),
      catchError(err => err)
    )
  };

  setHeaders(): void {
    this.jwtToken = this.tokenStorage.getUser().token;

    this.headers = new HttpHeaders().set('Content-type', 'application/json')
                             .set('authorization', this.jwtToken);
  }
}
