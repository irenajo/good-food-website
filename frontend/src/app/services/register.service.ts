import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserLogin } from '../models/userLogin';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  url = 'http://localhost:8080/register';

  register(user: User, file: File) {
    return this.http.post<UserLogin>(`${this.url}/register`, user);

  }

  uploadImage(username: string, file: File) {
    const fd: FormData = new FormData();
    fd.append('file', file);
    fd.append('username', username);
    return this.http.post<Boolean>(`${this.url}/uploadImage`, fd)
  }

  // fetch all user data for Profile page

  // register an user from Register page

  // change password 
}
