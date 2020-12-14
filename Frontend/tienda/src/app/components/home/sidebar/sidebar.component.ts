import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/models/categoria';
import { CategoriasService } from '../../../services/categorias.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  clase: string;
  categorias: Categoria[];
  categoriasSecundarias: Categoria[];
  tieneSubCategorias: boolean;
  constructor(private service: CategoriasService, private router:Router) {
  service.categoriasprincipales().subscribe(cat => {

      console.log(cat);
      this.categorias= cat;
      console.log(this.categorias);

  });
  console.log('Categorias');

  }
   public categoriassecundarias(id: Number){
    this.service.categoriassecundarias(id).subscribe(cat => {

      console.log(cat);
      this.categoriasSecundarias= cat;
      console.log(this.categoriasSecundarias);
      if (this.categoriasSecundarias.length > 0){
        this.tieneSubCategorias = true;
        console.log(this.tieneSubCategorias);

      }
      else{
        this.tieneSubCategorias = false;
        console.log(this.tieneSubCategorias);
      }
  });
   }

public irProductos(id:number)
{
  if(id>0){
    this.router.navigateByUrl('productos/'+id);
   }
}
}
