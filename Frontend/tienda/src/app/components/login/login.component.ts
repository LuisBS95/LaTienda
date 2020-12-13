import { Component, EventEmitter, OnInit, Output, TemplateRef } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { UsuariosService } from '../../services/usuarios.service';
import {  BsModalRef } from 'ngx-bootstrap/modal';
import { Token } from '../../models/Token';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  registro: FormGroup;
  token: Token;

  
  
  // tslint:disable-next-line: max-line-length
  constructor(private fb: FormBuilder , private router: Router, private userService: UsuariosService,public bsModalRef: BsModalRef ) {
    this.crearFormulario();
    this.token = new Token();

  }

  ngOnInit(): void {
  }

  openModal(template: TemplateRef<any>) {
    
  }

  crearFormulario(){
    this.registro = this.fb.group({
      // tslint:disable-next-line: max-line-length
      email :['',[Validators.required,Validators.pattern('[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}')]],
      password :['', Validators.required]
    });
  }

  get emailNoValido(){
    return this.registro.get('email').invalid && this.registro.get('email').touched;
  }

  get passwordNoValido(){
    return this.registro.get('password').invalid && this.registro.get('password').touched;
  }

 
 
  login(){
    console.log(this.registro);

    if(this.registro.invalid) {

      return Object.values( this.registro.controls).forEach( control=> {
        control.markAsTouched();
      });
    }

    Swal.fire({
      title: 'Espere',
      text: 'Comprobando Credenciales',
      icon: 'info',
      allowOutsideClick: false
    });

    Swal.showLoading();

    let userName = this.registro.get('email').value;
    let pass = this.registro.get('password').value;

    console.log('Holñlllll'+userName+'  '+pass);
    

    this.userService.getToken(userName, pass).subscribe( resp => {
      console.log(resp);
      
      if ( resp !== null){
        Swal.fire({
          text: 'Autenticacion Correcta',
          icon: 'success'
        });
        this.token.user = resp.email;
        this.token.pass = resp.password;
        localStorage.setItem('token', JSON.stringify(this.token));
        this.registro.reset();
        this.userService.autenticar(true);
        window.location.reload();
       this.bsModalRef.hide();
       this.router.navigate(['/home']);
       
      }
      else{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Credenciales incorrectas!',
          footer: 'Revise sus Credenciales'
        });
        this.registro.reset();
        this.userService.autenticar(false);
      }
    });

   

  }

  resetForm(){
    this.registro.reset();
  }



}
