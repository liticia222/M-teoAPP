import { Component, signal } from '@angular/core';
import { MeteoComponent } from './component/meteo/meteo';
@Component({
  imports: [MeteoComponent],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
   
})
export class App {
  protected readonly title = signal('frontend-meteo');
}
