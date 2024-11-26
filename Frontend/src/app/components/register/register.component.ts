import { Component } from '@angular/core';
import { UserCreateDto } from '../../model';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { FormControl, FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  registerForm = new FormGroup({
    firstName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    lastName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    username: new FormControl('', [Validators.required, Validators.minLength(5)]),
    password: new FormControl('', [Validators.required, Validators.minLength(5)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    dateOfBirth: new FormControl('', [Validators.required]),
  });
  
  newUser:UserCreateDto={email:"",firstName:"",lastName:"",username:"",password:"",dateOfBirth:""}

  constructor(private router:Router,private userService:UserService){}
  


  register(){


    this.newUser.email=this.registerForm.get("email")!.value!
    this.newUser.firstName=this.registerForm.get("firstName")!.value!
    this.newUser.lastName=this.registerForm.get("lastName")!.value!
    this.newUser.username=this.registerForm.get("username")!.value!
    this.newUser.password=this.registerForm.get("password")!.value!
    this.newUser.dateOfBirth=this.registerForm.get("dateOfBirth")!.value!

    
    this.userService.registerUser(this.newUser).subscribe(result=>{
      alert("Korisnik uspesno registrovan! :)")
      this.router.navigate([''])

    },error =>{
      alert("Error while registring user")

    })
    





  }



}
