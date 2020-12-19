import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ValidadoresService } from '../../services/validadores.service';
import { Usuario } from '../../models/Usuario';
import { UsuariosService } from '../../services/usuarios.service';
import { Router } from '@angular/router';
import { Token } from '../../models/Token';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {
  existeEmail: boolean;
  registro: FormGroup;
  usuario: Usuario;
  token: Token = new Token();
  usu: boolean;
  constructor( private fb: FormBuilder, private validadores: ValidadoresService, private usuariosService: UsuariosService , private router : Router) {
      this.crearFormulario();
      this.usuario = new Usuario();
      ;
    if(JSON.parse(localStorage.getItem('token')) != null){
      this.router.navigateByUrl('/home');      
    }
   }

  ngOnInit(): void {
    
  }

  crearFormulario() {
    this.registro = this.fb.group({
      nombre :['', Validators.required],
      apellido :['', Validators.required],
      // tslint:disable-next-line: max-line-length
      email :['', Validators.pattern('[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}')],
      fechaNacimiento :['', Validators.required],
      password :['', Validators.required],
      pass2 :['', Validators.required]
    }, {
      validators: this.validadores.passwordsIguales('password', 'pass2')
    });
  }

  get nombreNoValido(){
    return this.registro.get('nombre').invalid && this.registro.get('nombre').touched;
  }

  get apellidoNoValido(){
    return this.registro.get('apellido').invalid && this.registro.get('apellido').touched;
  }
  
  get emailNoValido(){
    return this.registro.get('email').invalid && this.registro.get('email').touched;
  }

  get fechaNacimientoNoValido(){
    return this.registro.get('fechaNacimiento').invalid && this.registro.get('fechaNacimiento').touched;
  }

  get passwordNoValido(){
    return this.registro.get('password').invalid && this.registro.get('password').touched;
  }

  get pass2NoValido(){
    const pass1 = this.registro.get('password').value;
    const pass2 = this.registro.get('pass2').value;
    return (pass1 === pass2) ? false : true;
  }
  


  registar(){
    console.log(this.registro);

    this.usuariosService.hayEmail(this.registro.get('email').value).subscribe(valor=>{
      this.existeEmail=valor;
      console.log(valor);
      
      if(valor==false){
        Swal.fire({
          text: 'Autenticacion Correcta',
          icon: 'success'
        });
        this.usuario.nombre = this.registro.get('nombre').value;
    this.usuario.apellido = this.registro.get('apellido').value;
    this.usuario.email = this.registro.get('email').value;
    this.usuario.fechaNacimiento = this.registro.get('fechaNacimiento').value;
    this.usuario.password = this.registro.get('password').value;
    console.log(this.usuario);
    this.usuariosService.insertarUsuario(this.usuario).subscribe( resp =>{
      console.log(resp);
      this.token.user = this.registro.get('email').value;
        this.token.pass = this.registro.get('password').value;
        localStorage.setItem('token', JSON.stringify(this.token));
        
        window.location.reload();
      
    } );
      }

      else{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Ese email ya fue registrado!',
          footer: 'Revise sus Credenciales'
        });
        //this.registro.reset();
      }

    });

    if(this.registro.invalid) {

      return Object.values( this.registro.controls).forEach( control=> {
        control.markAsTouched();
      });
    }

    
    
  }
}
