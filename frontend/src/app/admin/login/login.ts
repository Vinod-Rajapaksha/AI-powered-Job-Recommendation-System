import { Component } from '@angular/core';
import { AuthService } from '../../services/auth';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgxSpinnerModule } from 'ngx-spinner';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule,NgxSpinnerModule],
  templateUrl: './login.html'
})
export class Login {
  username = '';
  password = '';
  errorMessage = '';

  constructor(
    private spinner: NgxSpinnerService,
    private authService: AuthService,
    private router: Router
  ) {}

  handleLogin() {
    this.errorMessage = '';
    this.spinner.show();

    const credentials = { username: this.username, password: this.password };

    this.authService.login(credentials).subscribe({
      next: (res) => {
        this.spinner.hide();
        this.authService.saveToken(res.token); 
        this.router.navigate(['/admin/dashboard']); 
      },
      error: () => {
        this.spinner.hide();
        this.errorMessage = 'Invalid username or password.';
      }
    });
  }
}
