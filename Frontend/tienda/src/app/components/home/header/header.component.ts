import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Token } from 'src/app/models/Token';
import { UsuariosService } from 'src/app/services/usuarios.service';
import { LoginComponent } from '../../login/login.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  bsModalRef: BsModalRef;
  autenticado: boolean;
  token: Token;
  constructor(private modalService: BsModalService, private userService: UsuariosService, private router: Router) {}

  ngOnInit(): void {
    this.userService.autenticar(true);
    this.token = JSON.parse(localStorage.getItem('token'));
    if(this.token != null){
      this.autenticado = true;
      
    }
  }
  openModal() {
    
    this.bsModalRef = this.modalService.show(LoginComponent);
    
  }
  cerrar(){
    this.autenticado = false;
    localStorage.removeItem('token');
    this.router.navigateByUrl('/home');
    
  }

}
