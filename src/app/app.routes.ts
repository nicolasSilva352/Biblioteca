import { Routes } from '@angular/router';
import { LoginComponent } from './features/login/login';
import { DashboardComponent } from './features/dashboard/dashboard';
import { CadastroComponent } from './features/cadastro/cadastro';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'cadastro', component: CadastroComponent }, // ROTA NOVA
  { path: 'dashboard', component: DashboardComponent }
];
