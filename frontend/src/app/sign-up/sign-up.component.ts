import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { UserServiceService } from '../services/user-service.service';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit{

  constructor(private userService: UserServiceService, private route: Router ,private formBuilder: FormBuilder, private http: HttpClient) { }

  signupForm: FormGroup;

  // sign up object
  signupData = {

    name: '',
    password: '',
    email: ''

  };

  formSubmit(){

    this.signupData.name = this.signupForm.value.userName;
    this.signupData.password = this.signupForm.value.password;
    this.signupData.email = this.signupForm.value.email;

    this.userService.registerUser(this.signupData).subscribe(res =>{

      console.log(res);
      localStorage.setItem('token', res["token"]);
      
      if(res['role'] === 'CUSTOMER'){
        this.route.navigate(['/shop']);
      }
      this.route.navigate(['/dashboard']);
    }) 

  }

  ngOnInit(): void {

    this.signupForm  = this.formBuilder.group({
      
      userName: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      passConf: ['', Validators.required]
    
    });

  }
}