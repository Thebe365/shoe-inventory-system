import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }

  // Server url
  url = "http://localhost:8080/api/v1/auth/"

  // register user
   registerUser(user) {
    return this.http.post(this.url + "register", user);
  }

}