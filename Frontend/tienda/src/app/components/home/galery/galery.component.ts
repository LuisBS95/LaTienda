import { Component, OnInit, TemplateRef } from '@angular/core';
import { Producto } from '../../../models/producto';
import { ProductoServiceService } from '../../../services/producto-service.service';
import { CategoriasService } from '../../../services/categorias.service';
import { Categoria } from 'src/app/models/categoria';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Router } from '@angular/router';

import { NgForm } from '@angular/forms';





@Component({
  selector: 'app-galery',
  templateUrl: './galery.component.html',
  styleUrls: ['./galery.component.css']
})
export class GaleryComponent implements OnInit {
  modalRef: BsModalRef;
  productosprin: Producto[] = new Array();
  categorias: Categoria[] = new Array();
  productoseleccionado: Producto = new Producto();
 

 
  
  // tslint:disable-next-line: max-line-length
  constructor(private servicio: ProductoServiceService, private servicio2: CategoriasService, private router: Router,private modalService: BsModalService) {
   
   this.getArregloProductos();    
    
  }
  ngOnInit(): void {
  }
  
  public getArregloProductos(){
    this.servicio2.categoriasprincipales().subscribe((categ: Categoria[]) => {

      categ.forEach(cat => {
        this.servicio.getProductosbycategoria(cat.idCategoria).subscribe(prod =>
          {
            cat.productos = prod;
            this.categorias.push(cat);
          });
     });

      });
    console.log(this.categorias);
  }

  public getGaleriaProductos(id): Producto[]{

    this.servicio.getProductosbycategoria(id).subscribe(prod =>
      {
        console.log(prod);
        this.productosprin = prod;
        
      });
    return this.productosprin;
  }
 
  

  // tslint:disable-next-line: typedef
  public listaProductos(idCat: number){
    this.router.navigate(['/productos', idCat]);
    console.log("id: ");
    console.log(idCat);
    
  }

  cargamodal(producto: Producto){
    this.productoseleccionado = producto;
}

agregaralcarrito(forma: NgForm, idProducto: number){
  
 this.servicio.agregaralcarrito(forma , idProducto);
 this.modalRef.hide();   
}
openModal(template: TemplateRef<any>,producto: Producto) {
  this.productoseleccionado = producto;
  this.modalRef = this.modalService.show(template);
}
}
