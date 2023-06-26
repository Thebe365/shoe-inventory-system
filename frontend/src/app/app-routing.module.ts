import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './sign-in/sign-in.component';

const routes: Routes = [
  {path: '', component: SignInComponent},
  {path: 'dashboard', loadChildren: () => import('./dashboard-module/dashboard-module.module').then(m => m.DashboardModuleModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }