import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { SharedModule } from '../../shared/shared.module';

@Component({
  selector: 'app-history',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './history.component.html'
})
export class HistoryComponent implements OnInit {
  displayedColumns: string[] = ['operationType', 'measurementType', 'operand1', 'operand2', 'result', 'createdAt'];
  dataSource = new MatTableDataSource<any>([]);
  loading = true;

  @ViewChild(MatSort) sort!: MatSort;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchHistory();
  }

  fetchHistory() {
    this.http.get<any[]>('http://54.206.167.226:8080/api/quantity/history').subscribe({
      next: (data) => {
        this.dataSource.data = data.reverse();
        this.dataSource.sort = this.sort;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
