import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {  MeteoResponse } from '../model/meteo';
import { Ville } from '../model/ville';
@Injectable({
  providedIn: 'root'
})
export class MeteoService {
  // L'URL de votre backend Spring Boot
  private baseUrl = 'http://localhost:8080/meteo';

  constructor(private http: HttpClient) { }

  rechercherVilles(nom: string): Observable<Ville[]> {
    const params = new HttpParams().set('name', nom);
    return this.http.get<Ville[]>(`${this.baseUrl}/search`, { params });
  }

  
  obtenirMeteo(latitude: number, longitude: number): Observable<MeteoResponse> {
    const params = new HttpParams()
      .set('latitude', latitude.toString())
      .set('longitude', longitude.toString());
      
    return this.http.get<MeteoResponse>(`${this.baseUrl}/forecast`, { params });
  }
}