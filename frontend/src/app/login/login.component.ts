import { Component } from '@angular/core';
import { UserLogin } from '../models/userLogin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  errorMessage: string = ""

  user: UserLogin = new UserLogin();

  constructor() { }

  onSubmit() {
    if (!this.verifyPassword()) {
      this.errorMessage = "Лозинку проверити коришћењем регуларног израза (минимално 6 карактера, максимално 10 карактера,од тога бар једно велико слово, три мала слова, један број и један специјални карактер, и мора почињати словом)"
      return
    }

    this.errorMessage = "";
  }

  verifyPassword() {
    const passwordRegex = /^(?=[a-zA-Z])(?=.*[A-Z])(?=(?:[^a-z]*[a-z]){3})(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\\\/-]).{6,10}$/
    //const passwordRegex = /^(?=.*[A-Z])(?=.*[a-z].*[a-z].*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.{6,10})(?=[A-Za-z])[A-Za-z][A-Za-z0-9!@#$%^&*()-_+=]{5,9}$/
    return passwordRegex.test(this.user.password)
  }

}
