import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'; 

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit{

  constructor(private route: Router ,private formBuilder: FormBuilder, private http: HttpClient) { }

  signupForm: FormGroup;

  // sign up object
  signupData = {

    name: '',
    password: '',
    email: ''

  };

  formSubmit(){
    
    
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
