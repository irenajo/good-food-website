import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserLogin } from '../models/userLogin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  url = 'http://localhost:8080/login';

  login(username: string, password: string) {
    const data = {
      username: username,
      password: password,
      type: ""
    };
    return this.http.post<UserLogin>(`${this.url}/login`, data);
  }
}
