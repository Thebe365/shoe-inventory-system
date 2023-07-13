import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'; 
import { faCoffee } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {

  // Form
  loginForm: FormGroup;

  constructor(private route: Router ,private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
    });

    
  }

  registrationData = {
    email: '',
    password: ''
  };

  formSubmit(){

    if (this.loginForm.valid) {
      
      this.registrationData.email = this.loginForm.value.userName;
      this.registrationData.password = this.loginForm.value.password;

      this.http.post('http://localhost:8080/api/v1/auth/authenticate', this.registrationData)
      .subscribe(
        (response) => {
          if (response) {
            localStorage.setItem("token",response["token"]);
            sessionStorage.setItem("email", this.registrationData.email)

            this.route.navigate(["./dashboard"])
          }
          else {
            Swal.fire({
              icon: 'error',
              title: 'Woops',
              text: 'Could not log in, check your credentials',
            })
          }
          
        },
        (error: Response) => {
          
          if(error.status === 401){

            Swal.fire({
              icon: 'error',
              title: 'Woops',
              text: 'Could not log in, check your credentials',
            })
          }
          
        }
      );
    }else{

      Swal.fire({
        icon: 'error',
        title: 'Woops',
        text: 'Input fields are empty',
      })
    }
  }
}
