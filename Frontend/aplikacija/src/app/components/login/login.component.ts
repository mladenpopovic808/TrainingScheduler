import { Component } from '@angular/core';
import { TokenRequestDto } from '../../model';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';



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

  constructor(private userService:UserService,private router:Router) {
    
  }

  login(){
    this.userService.login(this.loginRequest).subscribe(loginResponse=>{
      
      localStorage.setItem("token",loginResponse.token);
      //this.router.navigate['/nekaStranica']
      
      this.router.navigate(["allUsers"])
      
      
    },error=>{
      alert("Login error!")
    })
    
    //Ovde mi je prvo bila ova linija,ali desi se da predjemo na drugu stranicu a da se token iz asinhrone metode ne ubaci
    //tako da sam premestio gore.
    //this.router.navigate(["allUsers"])

  
  }
  register(){
    this.router.navigate(['register'])

  }


}
