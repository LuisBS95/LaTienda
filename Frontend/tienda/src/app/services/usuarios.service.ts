import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  url = 'http://localhost:8080/usuario';
  public auten:boolean;
  constructor( private http: HttpClient
              ) { }

  insertarUsuario( usuario: Usuario) : Observable<Usuario>{

    return this.http.post<Usuario>(`${this.url}/registar`, usuario);
  }
  hayEmail(email:String) : Observable<boolean>{
    return this.http.get<boolean>(`${this.url}/email/${email}`);
  }

  getToken(email: string, pass ): Observable<Usuario>{

  
    return this.http.get<Usuario>(`${this.url}/token/${email}/${pass}`);
  }

  autenticar(aut:boolean)
  {
      this.auten= aut;
  }
}
