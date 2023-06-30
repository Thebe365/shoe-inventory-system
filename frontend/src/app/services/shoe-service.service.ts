import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShoeServiceService {

  constructor(private http: HttpClient) { }

  // Server url
  url = "http://localhost:8080/api/v1/"

  // getting brand by id
  public getBrandById(id: number) {
    return this.http.request("GET", this.url + `brand/${id}`);
  }
}
