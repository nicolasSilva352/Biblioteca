import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  templateUrl: './dashboard.html'
})
export class DashboardComponent {
  private authService = inject(AuthService);
  private router = inject(Router);

  // No futuro, isso pode vir direto do Token JWT
  nomeUsuario = 'Administrador';

  sair() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
