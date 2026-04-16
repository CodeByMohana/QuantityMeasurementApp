import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SharedModule } from '../../shared/shared.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
  totalConversions = 0;
  recentConversions: any[] = [];
  username = 'User';

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit() {
    this.http.get<any>('http://54.206.167.226:8080/api/auth/profile').subscribe(res => {
      if (res && res.username) this.username = res.username;
    });

    this.http.get<any[]>('http://54.206.167.226:8080/api/quantity/history').subscribe(data => {
      this.totalConversions = data.length;
      this.recentConversions = data.slice(-5).reverse();
    });
  }

  goToConvert() {
    this.router.navigate(['/quantity']);
  }
}
