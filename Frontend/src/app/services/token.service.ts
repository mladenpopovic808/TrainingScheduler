import { Injectable } from '@angular/core';
import { jwtDecode } from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  getDecodedToken():any{
    let token = localStorage.getItem('token')
    if(token){
      return jwtDecode(token)

    }
    return null;
  }
  /*      claims.put("id", user.getId());
            claims.put("role", user.getRole().getName());
            claims.put("email", user.getEmail());
            claims.put("isActive", user.getActivated());
            claims.put("isDeleted", user.getDeleted()); */

  getId(): number | null{

    const decoded=this.getDecodedToken()
    return decoded? decoded.id:null

  }
  getRole(): string | null{

    const decoded=this.getDecodedToken()
    return decoded? decoded.role:null

  }
  getEmail(): string | null{

    const decoded=this.getDecodedToken()
    return decoded? decoded.email:null

  }
  isActive(): boolean | null{

    const decoded=this.getDecodedToken()
    return decoded? decoded.isActive:null

  }
  isDeleted(): boolean | null{

    const decoded=this.getDecodedToken()
    return decoded? decoded.isDeleted:null

  }
  isAdmin():boolean{
    const role=this.getRole();
    if(role==null){
      return false;
    }
    if(role.toLocaleLowerCase()==='role_admin'){
      return true
    }else{
      return false;
    }
  }
}
