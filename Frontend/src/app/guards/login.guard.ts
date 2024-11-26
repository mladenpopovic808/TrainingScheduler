import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanDeactivate,
  Router,
  RouterStateSnapshot,
  UrlTree
} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate,CanDeactivate<any> {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot,state: RouterStateSnapshot):boolean {

    //ako je vec ulogovan, da ga prebacis sa login stranice na neku pocetnu.
    if(localStorage.getItem('token')!=null){
        this.router.navigate(['allUsers'])
    }
    return true

  }

  canDeactivate(component: any, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState: RouterStateSnapshot):boolean {

  if(localStorage.getItem("token")!==null){
    return true
  }
    return false;
  }

}
