import { Component, OnInit } from '@angular/core';
import { UserDto } from '../../model';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrl: './all-users.component.css'
})
export class AllUsersComponent implements OnInit{

  users:UserDto[]=[]
  currentPage: number = 0;  // Trenutna stranica
  totalPages: number = 3;    // Ukupno stranica
  sort = ["id"]; // Sortiranje u formatu "property,asc|desc"

  constructor(private userService:UserService,private router:Router) {
    
  }


  ngOnInit(): void {
  this.getUsersByPage(this.currentPage,10,this.sort)

  
}
changePage(page: number): void {
  if (page >= 0 && page < this.totalPages) {
    this.currentPage = page;
    this.getUsersByPage(this.currentPage,10,this.sort)// Pozivamo getUsers sa novom stranicom
  }
}

getUsersByPage(page: number, size: number, sort: string[]){
  this.userService.getAllUsers(page,size, sort)!.subscribe(users => {
    if (users && users.content) {
      this.users = users.content;
    } else {
      console.error('No users found or content is undefined');
    }
  }, error => {
    alert("Error while fetching all users");
  });

}
navigateToEditUser(user:UserDto){

  this.router.navigate([`editUser/${user.id}`])
  
}

  

}
