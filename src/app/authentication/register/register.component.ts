import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, FormsModule} from '@angular/forms';
@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  formSubmitted = false;
  form: FormGroup;

  inputName: string = '';
  inputLastName: string = '';
  inputGithub: string = '';
  inputDate: string = '';
  inputEmail: string = '';
  inputPhone: string = '';
  inputPassword: string = '';
  inputConfirmPassword: string = '';
  inputCarreer: string = '';
  inputAddress: string = '';
  today = new Date();

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      inputName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]],
      inputLastName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]],
      inputGithub: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9]{1,39}$')]],
      inputDate: ['', [Validators.required]],
      inputCarreer: ['', [Validators.required]],
      inputPhone: ['', [Validators.required, Validators.pattern('[0-9]{9,15}')]],
      inputAddress: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(100)]],
      inputEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$'), Validators.email]],
      inputPassword: ['', [Validators.required, Validators.minLength(8)]]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      // Aquí puedes enviar el formulario o realizar alguna acción con los datos ingresados
      console.log('Formulario válido. Datos enviados:', this.form.value);
    } else {
      // Marca todos los campos como tocados para mostrar los mensajes de error
      Object.values(this.form.controls).forEach(control => control.markAsTouched());
    }
  }
  
}
