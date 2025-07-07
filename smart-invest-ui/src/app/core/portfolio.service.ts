import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class PortfolioService {
    private baseUrl = 'http://localhost:8080/api/portfolios';

    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<any[]>(this.baseUrl);
    }

    create(name: string) {
        return this.http.post(this.baseUrl + '?name=' + encodeURIComponent(name), {});
    }
    getRisk(id: number) {
        return this.http.get(`http://localhost:8080/api/risk/${id}`);
    }

}
