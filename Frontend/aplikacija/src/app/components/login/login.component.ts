import { Component } from '@angular/core';
import { TokenRequestDto } from '../../model';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginRequest:TokenRequestDto={
    email:'admin@gmail.com',
    password:'admin'
  };

  loginForm=new FormGroup({
    email:new FormControl('',[Validators.required,Validators.email]),
    password:new FormControl('',[Validators.required,Validators.minLength(5)]),

  })

  constructor(private userService:UserService,private router:Router,private formBuilder:FormBuilder) { 
  }

  login(){

    this.loginRequest.email=this.loginForm.get("email")!.value!
    this.loginRequest.password=this.loginForm.get("password")!.value!

    this.userService.login(this.loginRequest).subscribe(loginResponse=>{
      
      localStorage.setItem("token",loginResponse.token);
      this.router.navigate(["allUsers"])
      
      
    },error=>{
      if(error.status === 404){
        alert("User with email was not found")
      }
    })
    
    //Ovde mi je prvo bila ova linija,ali desi se da predjemo na drugu stranicu a da se token iz asinhrone metode ne ubaci
    //tako da sam premestio gore.
    //this.router.navigate(["allUsers"])

  
  }
  register(){
    this.router.navigate(['register'])

  }
  

}
