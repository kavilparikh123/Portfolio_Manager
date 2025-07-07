import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { WebSocketService } from '../../core/websocket.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrls: ['./home.scss']
})
export class HomeComponent implements OnInit {
  stocks: any[] = [];

  constructor(private http: HttpClient, private ws: WebSocketService) { }

  alerts: string[] = [];
  ngOnInit() {
    // this.ws.connect();

    this.ws.alert$.subscribe(msg => {
      if (msg) this.alerts.unshift(msg);
    });

    this.http.get<any[]>('http://localhost:8080/api/stocks')
      .subscribe(data => this.stocks = data);
  }
}
