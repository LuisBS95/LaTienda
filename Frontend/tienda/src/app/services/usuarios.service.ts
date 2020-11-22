import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  url = 'http://localhost:8080/usuario';

  constructor( private http: HttpClient
              ) { }

  insertarUsuario( usurio: Usuario) : Observable<Usuario>{

    return this.http.post<Usuario>(`${this.url}/registar`,usurio);
  }
}
