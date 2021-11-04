import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Covid } from '../models/covidVerification';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CovidVerificationService {
  private baseUrl: string = "http://localhost:8080/covid";
  headers = new HttpHeaders().set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*')

  constructor(private http: HttpClient) { }

  addCovid(covid: Covid): Observable<any>{
    return this.http.post(
      this.baseUrl,
      JSON.stringify(covid),
      {
        headers: this.headers,
        withCredentials: true
      }
    ).pipe(
      map(res => res),
      catchError(err => err)
    )
  }

  getCovid(): Observable<any> {
    return this.http.get(this.baseUrl)
      .pipe(
        map(res => res as Covid[]),
        catchError(err => err)
      )
  };

}
