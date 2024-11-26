import { Component, OnInit } from '@angular/core';
import { ManagerCreateDto, ManagerDto } from '../../model';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-manager',
  templateUrl: './edit-manager.component.html',
  styleUrl: './edit-manager.component.css'
})
export class EditManagerComponent implements OnInit{

  manager:ManagerDto={id:0,emailManager:"",firstName:"",lastName:"",usernameManager:"",password:"",salaName:""}


  constructor(private userService:UserService,private router:Router,private route:ActivatedRoute) {
    
  }
  

  ngOnInit(): void {
    const managerId:number=parseInt(<string>this.route.snapshot.paramMap.get('id'))
    this.manager.id=managerId
    this.userService.getManagerById(managerId).subscribe(result=>{
    
      this.manager=result;

    },error=>{
      alert("Error while fetching manager by id!")

    })
  }


  editManager(){
    //Create je isti kao change, tako da koristimo jedan
    let managerDto:ManagerCreateDto={
      
      emailManager:this.manager.emailManager,
      firstName:this.manager.firstName,
      lastName:this.manager.lastName,
      usernameManager:this.manager.usernameManager,
      password:this.manager.password,
      salaName:this.manager.salaName
      
    }

    this.userService.editManager(managerDto,this.manager.id).subscribe(result=>{
      this.manager=result

    },error=>{
      alert("ERROR: Update Manager")
    })
    


  
  }

}
