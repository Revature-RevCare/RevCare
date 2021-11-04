import { Injectable } from '@angular/core';
<<<<<<< HEAD
import { User } from '../models/userModel';
import {HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

=======
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


const API_URL = 'http://localhost:8080/api/test/';

>>>>>>> loginJwt
@Injectable({
  providedIn: 'root'
})
export class UserService {

<<<<<<< HEAD
private springServerUrl= environment.baseUrl;

  constructor(private http: HttpClient) { }
  // Get
public getUser(user_id:number): Observable<User[]> {

  return this.http.get<User[]>(`${this.springServerUrl}/users/find/${user_id}`);

}

public getAllUsers() : Observable<User[]> {
  return this.http.get<User[]>(`${this.springServerUrl}/users/find`);
}


  // Post

  public addUser(user: any) {
    return this.http.post(`${this.springServerUrl}/users/addUser`, user);
  }


  // Put

  public updateUser(user : any, id: number) {
    console.log(user);
    localStorage.setItem('currentUser', JSON.stringify(user));
    return this.http.put(`${this.springServerUrl}/users/update/${id}`, user);
  }


  // Delete

  public deleteUser(user_id: number)  {
    return this.http.delete(`${this.springServerUrl}/users/delete/${user_id}`);
  }

}
=======
  // private springServerUrl= environment.baseUrl;

  constructor(private http: HttpClient) { }
  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
  
}






>>>>>>> loginJwt
