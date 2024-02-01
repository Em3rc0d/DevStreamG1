import { Component } from '@angular/core';
import { MenuComponent } from '../menu/menu.component';
import { LeccionesComponent } from '../lecciones/lecciones.component';
import { CategoriesComponent } from '../categories/categories.component';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MenuComponent, LeccionesComponent, CategoriesComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {}
