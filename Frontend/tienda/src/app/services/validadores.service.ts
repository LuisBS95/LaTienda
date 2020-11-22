import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ValidadoresService {

  constructor() { }

  passwordsIguales (pass1Name: string, pass2Name: string) {
    return (form: FormGroup) => {
      const pass1 = form.controls[pass1Name];
      const pass2 = form.controls[pass2Name];
      if ( pass1.value === pass2.value){
        pass2.setErrors(null);
      }
      else{
        pass2.setErrors({noEsIgual: true});
      }
    }
  }
}
