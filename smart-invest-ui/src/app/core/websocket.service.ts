import { Injectable } from '@angular/core';
import { Client, IMessage } from '@stomp/stompjs';
import SockJS from 'sockjs-client/dist/sockjs.min.js';
import { BehaviorSubject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class WebSocketService {
  private client: Client;
  private alertSubject = new BehaviorSubject<string | null>(null);
  public alert$ = this.alertSubject.asObservable();

  constructor() {
    this.client = new Client({
      webSocketFactory: () => new SockJS('http://localhost:8080/ws'),
      reconnectDelay: 5000
    });

    this.client.onConnect = () => {
      this.client.subscribe('/topic/alerts', (msg: IMessage) => {
        this.alertSubject.next(msg.body);
      });
    };

    this.client.activate();
  }

  disconnect() {
    this.client.deactivate();
  }
}
