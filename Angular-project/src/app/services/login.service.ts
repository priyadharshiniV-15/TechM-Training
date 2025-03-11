import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private isLoggedIn: boolean = false;
  private loginStatus = new BehaviorSubject<boolean>(false);
  setLoginStatus(status: boolean, isAdmin: boolean): void {
   
    localStorage.setItem('isLoggedIn', JSON.stringify(this.isLoggedIn));
    localStorage.setItem('isAdmin', JSON.stringify(isAdmin));
    this.isLoggedIn = status;
  }

  getLoginStatus(): boolean {
    return JSON.parse(localStorage.getItem('isLoggedIn') || 'false');
  }

  getIsAdmin(): boolean {  // Added this method
    return JSON.parse(localStorage.getItem('isAdmin') || 'false');
  }
  getLoginStatusObservable(): Observable<boolean> {
    return this.loginStatus.asObservable();
  }
}
