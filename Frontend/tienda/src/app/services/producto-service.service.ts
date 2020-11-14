import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoServiceService {

 url ='http://localhost:8080/producto/';

  constructor(private http: HttpClient) {}
  
  getProductosbycategoria(idCategoria: number): Observable<Producto []> {
    return this.http.get<Producto[]>(`${this.url}/listar/${idCategoria}`);
  }

}
