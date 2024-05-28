import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserLogin } from '../models/userLogin';
import { User } from '../models/user';
import { ResponseMessage } from '../models/responseMessage';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  url = 'http://localhost:8080/register';

  register(user: User, file: File) {
    alert("E")
    return this.http.post<UserLogin>(`${this.url}/register`, user);

  }

  hello(){
    alert("here")
    const data = { username: 'yourUsername' };
    this.http.post<void>(`${this.url}/hello`, data);
  }

  uploadImage(username: string, file: File) {
    
    const fd: FormData = new FormData();
    fd.append('profilePicture', file);
    fd.append('username', username);
    alert("UPLOAD")
    return this.http.post<ResponseMessage>(`${this.url}/uploadImage`, fd)
    .pipe(
        map(response => response.success) // Extract the boolean value
    );
  }

  // fetch all user data for Profile page

  // register an user from Register page

  // change password 
}
