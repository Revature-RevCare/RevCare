import { Injectable } from '@angular/core';
import { User } from '../models/userModel';
import {HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

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
