import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register.html',
  styleUrls: ['./register.scss']
})
export class RegisterComponent {
  username = '';
  email = '';
  password = '';

  constructor(private auth: AuthService, private router: Router) {}

  register() {
    this.auth.register({
      username: this.username,
      email: this.email,
      password: this.password
    }).subscribe({
      next: () => {
        alert('Registration successful');
        this.router.navigate(['/auth/login']);
      },
      error: () => alert('Registration failed')
    });
  }
}