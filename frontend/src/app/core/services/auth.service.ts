import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly TOKEN_KEY = 'jwt_token';
  private loggedIn = new BehaviorSubject<boolean>(this.hasToken());
  public isLoggedIn$ = this.loggedIn.asObservable();
  
  private apiUrl = 'http://15.135.226.120:8080/api/auth';

  constructor(private http: HttpClient, private router: Router) {}

  public hasToken(): boolean {
    return !!localStorage.getItem(this.TOKEN_KEY);
  }

  public saveToken(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
    this.loggedIn.next(true);
  }

  public getToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  public login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, credentials).pipe(
      tap(response => {
        if (response && response.token) {
          this.saveToken(response.token);
        }
      })
    );
  }

  public signup(details: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/signup`, details);
  }

  public logout(): void {
    localStorage.removeItem(this.TOKEN_KEY);
    this.loggedIn.next(false);
    this.router.navigate(['/auth/login']);
  }

  public loginWithGoogle(): void {
    window.location.href = 'http://15.135.226.120:8080/api/auth/login/google';
  }

  public getProfile(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/profile`);
  }
}
