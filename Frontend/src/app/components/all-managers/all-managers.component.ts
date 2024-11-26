import { Component } from '@angular/core';
import { ManagerDto } from '../../model';
import { UserService } from '../../services/user.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-all-managers',
  templateUrl: './all-managers.component.html',
  styleUrl: './all-managers.component.css'
})
export class AllManagersComponent {

  managers:ManagerDto[]=[]
  currentPage: number = 0;  // Trenutna stranica
  totalPages: number = 3;    // Ukupno stranica
  sort = ["id"]; // Sortiranje u formatu "property,asc|desc"

  constructor(private userService:UserService,private router:Router) {
    
  }


  ngOnInit(): void {
  this.getManagersByPage(this.currentPage,10,this.sort)

  
}
changePage(page: number): void {
  if (page >= 0 && page < this.totalPages) {
    this.currentPage = page;
    this.getManagersByPage(this.currentPage,10,this.sort)// Pozivamo getUsers sa novom stranicom
  }
}

getManagersByPage(page: number, size: number, sort: string[]){
  this.userService.getAllManagers(page,size, sort)!.subscribe(result => {
    if (result && result.content) {
      this.managers = result.content;
    } else {
      console.error('No manager found or content is undefined');
    }
  }, error => {
    alert("Error while fetching Managers");
  });

}
navigateToEditManager(manager:ManagerDto){

  this.router.navigate([`editManager/${manager.id}`])
  
}

}
