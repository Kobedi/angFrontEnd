import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loyalty } from '../model/loyalty';


@Injectable({
  providedIn: 'root'
})
export class LoyaltyServiceService {

  private basUrl = "http://localhost:8080/loyalty"

  constructor(private httpClient: HttpClient) {

  }

  //returen list of Loyalty collection
  getLoyaltyList(): Observable<Loyalty[]> {
    console.log("invoke code:: loyality list");
    return this.httpClient.get<Loyalty[]>(`${this.basUrl}`);
  }


  createLoyalty(user: Loyalty): Observable<Object> {
    return this.httpClient.post(`${this.basUrl}`, user);
  }

  getLoyaltyById(id: number): Observable<Loyalty>{
    return this.httpClient.get<Loyalty>(`${this.basUrl}/${id}`);
  }

  
  updateLoyalty(id:number, loyalty:Loyalty): Observable<Object>{
    return this.httpClient.put(`${this.basUrl}/${id}`, loyalty);
  }
 

  deleteLoyalty(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.basUrl}/${id}`);
  }

} 
