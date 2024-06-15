import { Component } from '@angular/core';
import { User } from '../models/user';
import { NgForm } from '@angular/forms';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  myUser: User = new User();
  errorMessage: string = "test";
  file?: File;

  constructor(private registerService: RegisterService) {
  }

  onSubmit(form: NgForm) {
    this.registerService.hello();
    if (this.file) {
      //OBSERVABLE, NAPRAVI DA OSLUSKUJE !!!!! i da vrati potvrdu kad zavrsi.
      let upload = this.registerService.uploadImage(this.myUser.username, this.file).subscribe((res) => {
        alert(res)
        alert("MA ALLOOOO")
        alert(upload)
      })
      //let reg = this.registerService.register(this.myUser, this.file)
    }
    else {
    }

    // if (form.invalid) {
    //   this.errorMessage = ""
    //   this.getFormValidationErrors(form);
    // } else {
    //   // Process the form data
    //   console.log('Form Submitted!');
    //   this.errorMessage = ""
    // }
  }

  getFormValidationErrors(form: NgForm) {
    Object.keys(form.controls).forEach(key => {
      const controlErrors = form.controls[key].errors;
      if (controlErrors != null) {
        Object.keys(controlErrors).forEach(keyError => {
          let errorType = " not valid"
          console.log('Key control: ' + key + ', keyError: ' + keyError + ', err value: ', controlErrors[keyError]);
          switch (keyError) {
            case "email":
              errorType = "is not in email format."
              break;
            case "required":
              errorType = "is not filled."
              break;
            case "3":
              errorType = "is not in valid format"
              break;
            default:
              errorType = " not valid"
          }
          this.errorMessage += key += " "
          this.errorMessage += errorType += "\n"

        });
      }
    });
  }


  getFile(event: any) {
    //this.file = document.getElementById('imageUpload') as HTMLImageElement
    // this.file = event.target.files
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.file = input.files[0];
    }

  }

  //Only JPG/PNG formats are supported. Minimum size is 100x100px and maximum size is 300x300px.


}
