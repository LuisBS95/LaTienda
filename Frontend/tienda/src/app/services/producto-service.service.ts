import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';
import { PedidosProductos } from '../models/pedidos-productos';
import { NgForm } from '@angular/forms';



@Injectable({
  providedIn: 'root'
})
export class ProductoServiceService {

 url = 'http://localhost:8080/producto/';
 public pedidosproductos: PedidosProductos[] = new Array();
 producto: Producto;

  constructor(private http: HttpClient) {
    if(localStorage.getItem('carrito') != null){
    this.pedidosproductos = JSON.parse(localStorage.getItem('carrito'));
    }
  }

  getProductosbycategoria(idCategoria: number): Observable<Producto []> {
    return this.http.get<Producto[]>(`${this.url}/listar/${idCategoria}`);
  }

  getProductosbycategoriasl(idCategoria: number): Observable<Producto []> {
    return this.http.get<Producto[]>(`${this.url}/listarsl/${idCategoria}`);
  }

  getProductosbyid(idProducto: number): Observable<Producto>{
      return this.http.get<Producto>(`${this.url}/carrito/${idProducto}`);
  }

  agregaralcarrito(forma: NgForm, idProducto: number){

    console.log(forma.control.value.cantidad);
    if (forma.control.value.cantidad > 0){

    const pp: PedidosProductos = new PedidosProductos();

    pp.cantidad = forma.control.value.cantidad;
    pp.idProducto = idProducto;

    console.log(pp);
    this.pedidosproductos.push(pp);
    localStorage.setItem('carrito', JSON.stringify(this.pedidosproductos));
    console.log(this.pedidosproductos);



  }

  }



}
