import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PortfolioService } from '../../core/portfolio.service';

@Component({
  selector: 'app-portfolio-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './list.html',
  styleUrls: ['./list.scss']
})
export class ListComponent implements OnInit {
  portfolios: any[] = [];
  newPortfolioName = '';
  riskData: Record<number, { score: number; level: string }> = {};

  constructor(private portfolioService: PortfolioService) { }

  ngOnInit() {
    this.loadPortfolios();
  }

  loadPortfolios() {
    this.portfolioService.getAll().subscribe((data) => {
      this.portfolios = data;
    });
  }

  createPortfolio() {
    if (!this.newPortfolioName.trim()) return;

    this.portfolioService.create(this.newPortfolioName).subscribe(() => {
      this.newPortfolioName = '';
      this.loadPortfolios();
    });
  }


  loadRisk(portfolioId: number) {
    this.portfolioService.getRisk(portfolioId).subscribe((res: any) => {
      this.riskData[portfolioId] = {
        score: res.riskScore,
        level: res.riskLevel
      };
    });
  }
}
