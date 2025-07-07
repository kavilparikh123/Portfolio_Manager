import { Routes } from '@angular/router';
import { authGuard } from './core/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  {
    path: 'auth',
    loadChildren: () => import('./auth/routes').then((m) => m.AUTH_ROUTES),
  },
  {
    path: 'dashboard',
    loadChildren: () => import('./dashboard/routes').then((m) => m.DASHBOARD_ROUTES),
    canActivate: [authGuard],
  },
  {
    path: 'portfolio',
    loadChildren: () => import('./portfolio/routes').then((m) => m.PORTFOLIO_ROUTES),
    canActivate: [authGuard],
  }
];
