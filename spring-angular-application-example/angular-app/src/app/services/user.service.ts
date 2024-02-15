import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user.model';
import { Loyalty } from '../model/loyalty';
import { Society } from '../society.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private basUrl = "http://localhost:8080/user"

  private anotherBaseUrl = "http://localhost:8080/loyalty"

  private societyUrl = "http://localhost:8080/user/society"

  constructor(private httpClient: HttpClient) {

  }

  getUserList(): Observable<User[]> {

    //console.log("invoke code:: user list:: "+ this.getLoyaltyList());
    return this.httpClient.get<User[]>(`${this.basUrl}`);
  }

  getSocietyList(): Observable<Society[]> {

    //console.log("invoke code:: user list:: "+ this.getLoyaltyList());
    return this.httpClient.get<Society[]>(`${this.societyUrl}`);
  }

  createUser(user: User): Observable<Object> {
    return this.httpClient.post(`${this.basUrl}`, user);
  }

  getUserById(id: number): Observable<User>{
    return this.httpClient.get<User>(`${this.basUrl}/${id}`);
  }

  updateUser(id:number, user:User): Observable<Object>{
    return this.httpClient.put(`${this.basUrl}/${id}`, user);
  }

  deleteUser(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.basUrl}/${id}`);
  }

  


  //Let's try define another option here. 
  getLoyaltyList(): Observable<Loyalty[]> {
    console.log("invoke code:: loyality list::" + this.anotherBaseUrl);
    return this.httpClient.get<Loyalty[]>(`${this.anotherBaseUrl}`);
  }

  getLoyaltyById(id: number): Observable<Loyalty>{
    return this.httpClient.get<Loyalty>(`${this.anotherBaseUrl}/${id}`);
  }


} 
