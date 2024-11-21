import { Injectable } from '@angular/core';
import { ManagerCreateDto, ManagerDto, TokenRequestDto, TokenResponseDto, UserChangeDto, UserCreateDto, UserDto } from '../model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //Dole sam ga podesio, zato sto ako bi ga ovde podesio, localStorage u momentu kreiranja servisa ce biti prazan i nece imati token
  //tako da kada se ulogujem, morao bih da refreshujem stranicu da se servis ponovo kreira a to necu
  headers=new HttpHeaders()
  

  constructor(private httpClient:HttpClient) { }

  login(loginRequest:TokenRequestDto){
   

    // u <..> zagradama je povratna vrednost, tako da se ovde vraca TokenResponseDTO
    return this.httpClient.post<TokenResponseDto>(`${environment.userServiceURL}/loginUser`,loginRequest)
    
  }

  // Svaki od ovih parametara (page, size, i sort) se dodaju u URL kao query parametri (?page=1&size=10&sort=name,asc).
  getAllUsers(page: number, size: number, sort: string[]) {
    const token = localStorage.getItem('token');  // Dobijamo token iz localStorage

    this.headers=new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
     'Authorization': `Bearer ${localStorage.getItem('token')}`
  
    })
  
    if (!token) {
      console.error('Token not found!');
      return; // Ako nema tokena, vraćamo da ne šaljemo zahtev
    }
  
    // Kreiramo query parametre za paginaciju
    let params = new HttpParams()
      .set('page', page.toString())    // Strana
      .set('size', size.toString());   // Broj stavki po stranici
  
    // Ako je sort prosleđen, dodajemo parametre za sortiranje
    if (sort && sort.length > 0) {
      sort.forEach(s => {
        params = params.append('sort', s); // Dodajemo sortiranje
      });
    }
    
    return this.httpClient.get<any>(`${environment.userServiceURL}/getAll`, { headers:this.headers, params });
  }
  getAllManagers(page: number, size: number, sort: string[]) {
    const token = localStorage.getItem('token');  // Dobijamo token iz localStorage

    this.headers=new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
     'Authorization': `Bearer ${localStorage.getItem('token')}`
  
    })
  
    if (!token) {
      console.error('Token not found!');
      return; // Ako nema tokena, vraćamo da ne šaljemo zahtev
    }
  
    // Kreiramo query parametre za paginaciju
    let params = new HttpParams()
      .set('page', page.toString())    // Strana
      .set('size', size.toString());   // Broj stavki po stranici
  
    // Ako je sort prosleđen, dodajemo parametre za sortiranje
    if (sort && sort.length > 0) {
      sort.forEach(s => {
        params = params.append('sort', s); // Dodajemo sortiranje
      });
    }
    // Vraćamo HTTP GET poziv sa paginacijom i sortiranje parametrima
    return this.httpClient.get<any>(`${environment.userServiceURL}/getAllManagers`, { headers:this.headers, params });
  }
  

  getUserById(id:number):Observable<any>{

    return this.httpClient.get<UserDto>(`${environment.userServiceURL}/getUser/${id}`,{headers:this.headers})

  }
  getManagerById(id:number):Observable<any>{

    return this.httpClient.get<ManagerDto>(`${environment.userServiceURL}/getManager/${id}`,{headers:this.headers})

  }

  editUser(userChangeDto:UserChangeDto):Observable<any>{

    return this.httpClient.post<UserDto>(`${environment.userServiceURL}/updateProfile/`,userChangeDto,{headers:this.headers})

  }
  editManager(dto:ManagerCreateDto,managerId:number):Observable<any>{
  
    return this.httpClient.post<UserDto>(`${environment.userServiceURL}/updateManagerProfile/${managerId}`,dto,{headers:this.headers})

  }
  registerUser(dto:UserCreateDto):Observable<any>{
  
    return this.httpClient.post<UserDto>(`${environment.userServiceURL}/registerUser/`,dto)

  }
 
}
