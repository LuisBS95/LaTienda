import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Producto } from 'src/app/models/producto';
import { ProductoServiceService } from '../../services/producto-service.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  id: number;
  productos: Producto[];
  constructor(private activatedRoute: ActivatedRoute, private productoService: ProductoServiceService) { 
    this.activatedRoute.params.subscribe(params => {
      this.id = params['idCat'];
      console.log(this.id);
      
    } );
  }

  ngOnInit(): void {
    this.productoService.getProductosbycategoria(this.id).subscribe(prod => {
      this.productos = prod;
      console.log(prod);
      
    });
  }

}
