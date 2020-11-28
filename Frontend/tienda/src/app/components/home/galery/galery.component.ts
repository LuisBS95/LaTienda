import { Component, OnInit } from '@angular/core';
import { Producto } from '../../../models/producto';
import { ProductoServiceService } from '../../../services/producto-service.service';
import { CategoriasService } from '../../../services/categorias.service';
import { Categoria } from 'src/app/models/categoria';
import {map} from 'rxjs/operators';
import { Router } from '@angular/router';



@Component({
  selector: 'app-galery',
  templateUrl: './galery.component.html',
  styleUrls: ['./galery.component.css']
})
export class GaleryComponent implements OnInit {
  productosprin: Producto[];
  categorias: Categoria[];
  
  productosprin1: Producto[];
  productosprin2: Producto[];
  productosprin3: Producto[];
  productosprin4: Producto[];

 
  
  constructor(private servicio: ProductoServiceService, private servicio2: CategoriasService, private router: Router) {
   
   this.getArregloProductos();
  this.getGaleriaProductos1();
  this.getGaleriaProductos2();
  this.getGaleriaProductos3();
  this.getGaleriaProductos4();
    
    
  }
  ngOnInit(): void {
  }
  
  public getArregloProductos(){
    this.servicio2.categoriasprincipales().subscribe(categ =>{
      this.categorias = categ;
      });
    
  }

  public getGaleriaProductos(id): Producto[]{

    this.servicio.getProductosbycategoria(id).subscribe(prod =>
      {
        console.log(prod);
        this.productosprin = prod;
        
      });
    return this.productosprin;
  }
 
  public getGaleriaProductos1(){
    this.servicio.getProductosbycategoria(1).subscribe(prod =>
      {
        console.log(prod);
        this.productosprin1 = prod;

      });
  }
  public getGaleriaProductos2(){
    this.servicio.getProductosbycategoria(2).subscribe(prod =>
      {
        console.log(prod);
        this.productosprin2 = prod;

      });
  }
  public getGaleriaProductos3(){
    this.servicio.getProductosbycategoria(3).subscribe(prod =>
      {
        console.log(prod);
        this.productosprin3 = prod;

      });
  }
  public getGaleriaProductos4(){
    this.servicio.getProductosbycategoria(4).subscribe(prod =>
      {
        console.log(prod);
        this.productosprin4 = prod;

      });
  }

  public listaProductos(idCat: number){
    this.router.navigate(['/productos', idCat]);
    console.log("id: ");
    
    console.log(idCat);
    
  }
}

