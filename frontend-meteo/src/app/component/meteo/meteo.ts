import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DecimalPipe, DatePipe } from '@angular/common';
import { MeteoService } from '../../service/meteo-service';
import { Ville } from '../../model/ville';
import { MeteoResponse } from '../../model/meteo';

@Component({
  selector: 'app-meteo',
  standalone: true,
  imports: [FormsModule, DecimalPipe, DatePipe],
  templateUrl: './meteo.html'
})
export class MeteoComponent {
  private meteoService = inject(MeteoService);

  recherche = signal('');
  villes = signal<Ville[]>([]);
  villeSelectionnee = signal<Ville | null>(null);
  meteoData = signal<MeteoResponse | null>(null);
  enChargement = signal(false);
  enChargementMeteo = signal(false);
  erreur = signal('');

  onChercher() {
    const nom = this.recherche().trim();
    if (!nom) return;

    this.enChargement.set(true);
    this.erreur.set('');
    this.meteoService.rechercherVilles(nom).subscribe({
      next: (res) => {
        this.villes.set(res);
        this.enChargement.set(false);
        if (res.length > 0) {
          this.onSelectionnerVille(res[0]);
        } else {
          this.meteoData.set(null);
          this.erreur.set('Aucune ville trouvée');
        }
      },
      error: () => {
        this.erreur.set('Erreur lors de la recherche');
        this.enChargement.set(false);
      }
    });
  }

  onSelectionnerVille(v: Ville) {
    this.villeSelectionnee.set(v);
    this.enChargementMeteo.set(true);
    this.erreur.set('');
    this.meteoService.obtenirMeteo(v.latitude, v.longitude).subscribe({
      next: (data) => {
        this.meteoData.set(data);
        this.enChargementMeteo.set(false);
      },
      error: () => {
        this.erreur.set('Erreur lors de la récupération de la météo');
        this.enChargementMeteo.set(false);
      }
    });
  }

  getWeatherIcon(code: number): string {
    if (code === 0) return '☀️';
    if (code <= 2) return '⛅';
    if (code === 3) return '☁️';
    if (code === 45 || code === 48) return '🌫️';
    if (code >= 51 && code <= 57) return '🌦️';
    if (code >= 61 && code <= 67) return '🌧️';
    if (code >= 71 && code <= 77) return '❄️';
    if (code >= 80 && code <= 82) return '🌧️';
    if (code === 85 || code === 86) return '🌨️';
    if (code >= 95) return '⛈️';
    return '🌡️';
  }
}