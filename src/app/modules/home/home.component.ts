import { Component } from '@angular/core';
import { MenuComponent } from '../menu/menu.component';
import { LeccionesComponent } from '../lecciones/lecciones.component';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MenuComponent, LeccionesComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {}
