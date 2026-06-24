import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/usuarios';

  login(login: string, senha: string) {
    return this.http.post<{token: string}>(`${this.apiUrl}/login`, { login, senha })
      .pipe(
        tap(response => {
          localStorage.setItem('jwt_token', response.token);
        })
      );
  }

  // NOVO MÉTODO: Envia os dados para o Java salvar no banco
  registrar(nome: string, login: string, senha: string) {
    return this.http.post(`${this.apiUrl}`, { nome, login, senha });
  }

  logout() {
    localStorage.removeItem('jwt_token');
  }
}
