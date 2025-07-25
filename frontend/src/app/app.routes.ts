import { Routes } from '@angular/router';
import { Dashboard } from './user/dashboard/dashboard';

export const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () =>
      import('./admin/admin-module').then(m => m.AdminModule)
  },
  {
    path: 'user',
    component: Dashboard
  },
  {
    path: '',
    redirectTo: 'user',
    pathMatch: 'full'
  }
];