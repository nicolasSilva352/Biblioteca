import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../core/services/auth';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './cadastro.html' // Atenção ao nome do seu HTML aqui!
})
export class CadastroComponent {
  private fb = inject(FormBuilder);
  private authService = inject(AuthService);
  private router = inject(Router);

  cadastroForm = this.fb.group({
    nome: ['', Validators.required],
    login: ['', [Validators.required, Validators.email]],
    senha: ['', [Validators.required, Validators.minLength(6)]]
  });

  erroCadastro = false;

  onSubmit() {
    if (this.cadastroForm.valid) {
      const { nome, login, senha } = this.cadastroForm.value;

      this.authService.registrar(nome!, login!, senha!).subscribe({
        next: () => {
          // Se o Java salvar com sucesso, manda o usuário fazer login
          alert('Conta criada com sucesso! Faça seu login.');
          this.router.navigate(['/login']);
        },
        error: (err) => {
          console.error(err);
          this.erroCadastro = true;
        }
      });
    }
  }
}
