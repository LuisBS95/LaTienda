import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RegistroUsuarioComponent } from './components/registro-usuario/registro-usuario.component';
import { ProductosComponent } from './components/productos/productos.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'registrar', component: RegistroUsuarioComponent},
  { path: 'productos/:idCat', component: ProductosComponent},
  { path: '**', pathMatch: 'full', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
