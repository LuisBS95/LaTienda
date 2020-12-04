import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Producto } from 'src/app/models/producto';
import { ProductoServiceService } from '../../services/producto-service.service';
import { CategoriasService } from '../../services/categorias.service';
import { Categoria } from 'src/app/models/categoria';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  id: number;
  productos: Producto[];
  categoria: Categoria;
  productoseleccionado: Producto = null;
  // tslint:disable-next-line: max-line-length
  constructor(private activatedRoute: ActivatedRoute, private productoService: ProductoServiceService, private catService: CategoriasService) { 
    this.activatedRoute.params.subscribe(params => {
      this.id = params['idCat'];
      console.log(this.id);
      this.productoService.getProductosbycategoriasl(this.id).subscribe(prod => {
        this.productos = prod;
        console.log(prod);      
        this.productoseleccionado = this.productos[0];
      });
      
    } );
    
  }

  ngOnInit(): void {
    
  }

  cargamodal(producto: Producto){
      this.productoseleccionado = producto;
  }
}
