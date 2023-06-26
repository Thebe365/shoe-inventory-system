import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2'; 

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {

  // Form
  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
    });

    
  }

  formSubmit(){

    if (this.loginForm.valid) {
      
      const userName = this.loginForm.value.userName;
      const password = this.loginForm.value.password;
      // Here you can perform your login logic using the username and password
      console.log('Username:', userName);
      console.log('Password:', password);

      Swal.fire({
        icon: 'success',
        title: 'Success',
        text: 'Your code works',
      })
    }else{

      Swal.fire({
        icon: 'error',
        title: 'Woops',
        text: 'Your code does not work',
      })
    }
  }
}
