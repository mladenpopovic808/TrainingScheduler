import { Component } from '@angular/core';
import { UserCreateDto } from '../../model';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {


  


  newUser:UserCreateDto={email:"",firstName:"",lastName:"",username:"",password:"",dateOfBirth:""}

  constructor(private router:Router,private userService:UserService){}
  


  register(){

    this.userService.registerUser(this.newUser).subscribe(result=>{
      //ide ka login stranici
      this.router.navigate([''])

    },error =>{
      alert("Error while registring user")

    })
    





  }



}
