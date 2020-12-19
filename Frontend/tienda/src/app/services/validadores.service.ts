import { Injectable } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UsuariosService } from './usuarios.service';

interface ErrorValidate {
  [s: string]: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class ValidadoresService {

  hayUsuario=true;
  url = 'http://localhost:8080/usuario';
  constructor(private http: HttpClient, private usuario: UsuariosService) { 
    
  }

  passwordsIguales(pass1Name: string, pass2Name: string) {
    return (form: FormGroup) => {
      const pass1 = form.controls[pass1Name];
      const pass2 = form.controls[pass2Name];
      if ( pass1.value === pass2.value){
        pass2.setErrors(null);
      }
      else{
        pass2.setErrors({noEsIgual: true});
      }
    };
  }


  existeEmail( control: FormControl):Promise<ErrorValidate>|Observable<ErrorValidate>{

    console.log("hay usuario: ");
    if ( !control.value ) {
      return Promise.resolve(null);
    }
   console.log(control.value);

   const bb: string =control.value;
   
     this.usuario.hayEmail(bb).subscribe(value=>{
      this.hayUsuario=value;
      console.log(value);
      
      console.log("hay usuario: ");
      
      console.log(this.hayUsuario); 
     });
    
   


  }



}
