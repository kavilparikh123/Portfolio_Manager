import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AlertsComponent } from './shared/alerts/alerts';
import { AuthService } from './core/auth.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, CommonModule, AlertsComponent],
  templateUrl: './app.html',
  styleUrls: ['./app.scss']
})
export class App {
  constructor(private auth: AuthService, private router: Router) {}

  isLoggedIn(): boolean {
    return this.auth.isAuthenticated();
  }

  logout() {
    this.auth.logout();
    this.router.navigate(['/auth/login']);
  }
}
