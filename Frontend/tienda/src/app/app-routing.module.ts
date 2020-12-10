import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RegistroUsuarioComponent } from './components/registro-usuario/registro-usuario.component';
import { ProductosComponent } from './components/productos/productos.component';
import { CarritoComponent } from './components/carrito/carrito.component';
import { Productos2Component } from './components/productos2/productos2.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'registrar', component: RegistroUsuarioComponent},
  { path: 'productos2/:idCat', component: ProductosComponent},
  { path: 'productos/:idCat', component: Productos2Component},
  { path: 'carrito', component: CarritoComponent},
  { path: '**', pathMatch: 'full', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
