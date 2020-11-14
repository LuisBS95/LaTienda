import { Component, OnInit } from '@angular/core';
import { Producto } from '../../../models/producto';
import { ProductoServiceService } from '../../../services/producto-service.service';


@Component({
  selector: 'app-galery',
  templateUrl: './galery.component.html',
  styleUrls: ['./galery.component.css']
})
export class GaleryComponent implements OnInit {
  productosprin: Producto[];
  constructor(private servicio: ProductoServiceService) {
    this.getGaleriaProductos(1);
  }

  ngOnInit(): void {
  }

  getGaleriaProductos(id){
    this.servicio.getProductosbycategoria(id).subscribe(prod =>
      {
        console.log(prod);
        this.productosprin = prod;
      });
  }

}
