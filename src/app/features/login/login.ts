import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './login.html'
})
export class LoginComponent {
  private fb = inject(FormBuilder);
  private authService = inject(AuthService);
  private router = inject(Router);

  loginForm = this.fb.group({
    login: ['', Validators.required],
    senha: ['', Validators.required]
  });

  erroLogin = false;

  onSubmit() {
    if (this.loginForm.valid) {
      const { login, senha } = this.loginForm.value;

      this.authService.login(login!, senha!).subscribe({
        next: () => {
          this.erroLogin = false;
          // Se deu certo, manda o usuário para a tela inicial (dashboard)
          this.router.navigate(['/dashboard']);
        },
        error: (err) => {
          console.error(err);
          this.erroLogin = true;
        }
      });
    }
  }
}
