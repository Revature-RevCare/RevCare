import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Covid } from '../models/covidVerification';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { TokenStorageService } from './token-storage.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Injectable({
  providedIn: 'root'
})
export class CovidVerificationService {
  private baseUrl: string = "http://localhost:8080/covid";
  // headers = new HttpHeaders().set('content-type', 'application/json')
  // .set('Access-Control-Allow-Origin', '*')

  


  constructor(private http: HttpClient, private tokenStorage: TokenStorageService ) { }

  jwtToken
  = this.tokenStorage.getUser();

  headers
   = new HttpHeaders().set('content-type', 'application/json')
                             .set('Access-Control-Allow-Origin', '*')
                             .set('Authorization', this.jwtToken);

  addCovid(covid: Covid): Observable<any>{
    
    this.setHeaders();
    console.log(this.jwtToken);
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

  setHeaders(): void {
    this.jwtToken = this.tokenStorage.getUser().token;


    this.headers = new HttpHeaders().set('content-type', 'application/json')
    .set('Authorization', `Bearer ${this.jwtToken}`);
  }


}
