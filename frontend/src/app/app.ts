import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgxSpinnerModule } from 'ngx-spinner';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FormsModule,NgxSpinnerModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {
  protected readonly title = signal('frontend');

  constructor(private spinner: NgxSpinnerService) {}

  ngOnInit(): void {
    this.spinner.show('initial-loader');

    setTimeout(() => {
      this.spinner.hide('initial-loader');
    }, 1500);
  }

}
