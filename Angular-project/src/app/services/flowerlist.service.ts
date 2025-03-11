import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Flower } from '../model/flower';

@Injectable({
  providedIn: 'root',
})
export class FlowerlistService {
  private apiUrl = 'http://localhost:4500/flowers'; 
  constructor(private http: HttpClient) {}

  getFlowers(): Observable<Flower[]> {
    return this.http.get<Flower[]>(this.apiUrl);
  }
}
