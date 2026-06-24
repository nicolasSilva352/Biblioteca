import { Component } from '@angular/core';
import { RouterLink } from '@angular/router'; // Necessário para os links funcionarem!

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home.html' // ou home.component.html (verifique como o Angular gerou)
})
export class HomeComponent { }
