
import { Component, OnInit, TemplateRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Producto } from 'src/app/models/producto';
import { ProductoServiceService } from '../../services/producto-service.service';
import { CategoriasService } from '../../services/categorias.service';
import { Categoria } from 'src/app/models/categoria';
import { PedidosProductos } from '../../models/pedidos-productos';
import { NgForm } from '@angular/forms';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-productos2',
  templateUrl: './productos2.component.html',
  styleUrls: ['./productos2.component.css']
})
export class Productos2Component implements OnInit {
  modalRef: BsModalRef;
  id: number;
  productos: Producto[] = new Array();
  categoria: Categoria;
  productoseleccionado: Producto = new Producto();
  cantidad: number;
  public pedidosproductos: PedidosProductos[] = new Array();
  // tslint:disable-next-line: max-line-length
  constructor(private activatedRoute: ActivatedRoute, private productoService: ProductoServiceService, private catService: CategoriasService,private modalService: BsModalService) { 
    this.activatedRoute.params.subscribe(params => {
      this.id = params['idCat'];
      this.productoService.getProductosbycategoriasl(this.id).subscribe(prod => {
        this.productos = prod;
        this.productoseleccionado = this.productos[0];
      });
      
    } );
    
  }

  ngOnInit(): void {
    
  }

  cargamodal(producto: Producto){
      this.productoseleccionado = producto;
  }

  agregaralcarrito(forma: NgForm, idProducto: number){  
    this.productoService.agregaralcarrito(forma, idProducto); 
    this.modalRef.hide();
   
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  
}
