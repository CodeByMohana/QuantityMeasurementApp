import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import { SharedModule } from '../../../shared/shared.module';

@Component({
  selector: 'app-callback',
  standalone: true,
  imports: [SharedModule],
  template: `
    <div style="height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center; color: white;">
      <mat-spinner diameter="40"></mat-spinner>
      <p style="margin-top: 20px;">Authenticating...</p>
    </div>
  `
})
export class CallbackComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const token = params['token'];
      if (token) {
        this.authService.saveToken(token);
        this.router.navigate(['/dashboard']);
      } else {
        this.router.navigate(['/auth/login']);
      }
    });
  }
}
