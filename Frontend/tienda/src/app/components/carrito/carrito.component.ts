import { Component, OnInit } from '@angular/core';
import { ProductoServiceService } from '../../services/producto-service.service';
import { Producto } from '../../models/producto';
import { Carrito } from '../../models/carrito';
import { PedidosProductos } from '../../models/pedidos-productos';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {

public carritos: Carrito[] = new Array();
can = false;
edit = 'Editar';
total=0;
vacio=false;
carritosCantidad=0;
margenes="margen";
inputId=0;
  constructor(public productosServicio: ProductoServiceService, private route: Router) {
      this.carritos = this.productosServicio.pedidosproductos;
      this.carritosCantidad=this.carritos.length;
      this.crearArreglo();
      if(this.carritosCantidad>0){
        this.vacio=false;
        
        if(this.carritosCantidad==1){
          this.margenes="margen";
        }
        if(this.carritosCantidad==2){
          this.margenes="mar";
        }
        if(this.carritosCantidad>2){
          this.margenes="mari";
        }
      }
      else{
        this.vacio=true;
      }

    
    }

  ngOnInit(): void {
   
    

 }
  
  
  borrar ( car: Carrito ) {
    let i = this.carritos.indexOf( car );

    if ( i !== -1 ) {
       this.productosServicio.pedidosproductos.splice(i, 1);
      }
      this.crearArreglo();
    localStorage.setItem('carrito', JSON.stringify(this.productosServicio.pedidosproductos));
    window.location.reload();
}
edite(car : Carrito, cantidad: number){

  if(cantidad > 0){

  let carro: Carrito = new Carrito();
  let pp: PedidosProductos = new PedidosProductos();
  let i = this.carritos.indexOf( car );
  pp.idProducto = car.idProducto;
  pp.cantidad = cantidad;
  
  
  
  if ( i !== -1 ) {
     this.productosServicio.pedidosproductos.splice(i, 1, pp);
    }
  this.carritos = this.productosServicio.pedidosproductos;
  this.crearArreglo();
  localStorage.setItem('carrito', JSON.stringify(this.productosServicio.pedidosproductos));

  }
  else
  {

  }
}

// tslint:disable-next-line: typedef
crearArreglo(){
  this.total=0;
  this.carritos.forEach( ped => {
    this.productosServicio.getProductosbyid(ped.idProducto).subscribe(
      (prod: Producto) =>
      {ped.producto = prod.producto;
       ped.precio = prod.precio;
       ped.imagen = prod.imagen.substr(4);
       this.total= this.total + (ped.cantidad*ped.precio);
  });
});
}

edita(input : number){
this.can = !this.can;
this.inputId=input;
if(this.can){
  this.edit = 'Aceptar';
  
}
else{
  this.edit = 'Editar';
}

}
regresar(){
  this.route.navigateByUrl("/home");
}
guardar(){}
}
