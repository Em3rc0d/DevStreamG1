import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { LeccionesComponent } from './lecciones/lecciones.component';
import { LoginComponent } from './login/login.component';
export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'menu',
    component: MenuComponent,
  },
  {
    path: 'lecciones',
    component: LeccionesComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
];
