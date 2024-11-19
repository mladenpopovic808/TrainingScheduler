import { Component } from '@angular/core';
import { TokenService } from '../../services/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'aplikacija';


  constructor(private tokenService:TokenService,private router:Router){}

  navigateToManagersPage(){
    this.router.navigate(['allManagers'])

  }
  navigateToUsersPage():any{
   
    this.router.navigate(['allUsers'])

  }

  isUserLoggedIn() : boolean{
    const decodedToken=this.tokenService.getDecodedToken();
    if (decodedToken !=null){
      
      return true;
    }
    return false;
  }

  logout():any{
    
    localStorage.removeItem("token")
    this.router.navigate([""])
  

  }

  isAdmin():boolean{
    return this.tokenService.isAdmin()
   
  }
}
