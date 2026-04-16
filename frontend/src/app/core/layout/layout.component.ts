import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../../shared/shared.module';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [SharedModule, RouterModule],
  templateUrl: './layout.component.html',
  styles: [`
    .sidenav-container { height: 100vh; }
    .sidenav { width: 250px; background: var(--surface); border-right: 1px solid var(--border); }
    .nav-header { padding: 20px; font-size: 20px; font-weight: bold; border-bottom: 1px solid var(--border); color: var(--text-primary); display: flex; align-items: center; gap: 10px; }
    .nav-item { padding: 15px 20px; display: flex; align-items: center; gap: 15px; color: var(--text-secondary); text-decoration: none; font-weight: 500; transition: all 0.2s; }
    .nav-item:hover, .nav-item.active-link { background: rgba(79, 70, 229, 0.1); color: var(--primary); border-right: 4px solid var(--primary); }
    .mat-toolbar { background: var(--surface); border-bottom: 1px solid var(--border); }
    .main-content { padding: 30px; background: var(--background); height: calc(100vh - 64px); overflow-y: auto; box-sizing: border-box; }
    .spacer { flex: 1 1 auto; }
  `]
})
export class LayoutComponent {

  constructor(private authService: AuthService) {}

  logout() {
    this.authService.logout();
  }
}
