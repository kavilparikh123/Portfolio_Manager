import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WebSocketService } from '../../core/websocket.service';

@Component({
  selector: 'app-alerts',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './alerts.html',
  styleUrls: ['./alerts.scss']
})
export class AlertsComponent implements OnInit {
  messages: string[] = [];

  constructor(private ws: WebSocketService) { }

  ngOnInit(): void {
    this.ws.alert$.subscribe(msg => {
      if (msg) this.messages.unshift(msg);
    });
  }

}
