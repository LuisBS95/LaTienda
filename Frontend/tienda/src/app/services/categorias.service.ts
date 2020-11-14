import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../models/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {
  categoriasPrincipales: Categoria;
  url ='http://localhost:8080/categoria/';

  constructor(private http: HttpClient) {

   }

   public  categoriassecundarias(id : Number) : Observable<Categoria []>{
    return this.http.get<Categoria[]>(this.url + 'sub/' + id); 
    } 

   public  categoriasprincipales() : Observable<Categoria []>{
    return this.http.get<Categoria[]>(this.url + 'super'); 
    }

}
