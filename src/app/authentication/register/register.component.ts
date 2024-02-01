import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  Usuario: string = 'Emerc0d';
  input: any;
  saveName(username:string){
    this.input = username;
    this.Usuario = username
  }
}
