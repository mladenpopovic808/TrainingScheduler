import { Component, OnInit } from '@angular/core';
import { UserDto } from '../../model';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrl: './edit-user.component.css'
})
export class EditUserComponent implements OnInit {


  user:UserDto={id:0,email:"",firstName:"",lastName:"",username:"",dateOfBirth:"",numberOfSessions:0}


  constructor(private userService:UserService,private router:Router,private route:ActivatedRoute) {
    
  }
  

  ngOnInit(): void {
    const userId:number=parseInt(<string>this.route.snapshot.paramMap.get('id'))
    this.userService.getUserById(userId).subscribe(result=>{
      this.user=result;

    },error=>{
      alert("Error while fetching user by id!")

    })
  }
  editUser(){
  //TODO nastavi ovde :)
  }

}
