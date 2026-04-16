import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/services/auth.service';
import { SharedModule } from '../../shared/shared.module';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './profile.component.html'
})
export class ProfileComponent implements OnInit {
  username = 'Loading...';

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authService.getProfile().subscribe(data => {
      if (data && data.username) {
        this.username = data.username;
      }
    });
  }

  logout() {
    this.authService.logout();
  }
}
