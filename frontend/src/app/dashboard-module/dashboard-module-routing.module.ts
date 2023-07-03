import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardHomeComponent } from './dashboard-home/dashboard-home.component';
import { OverviewComponent } from './overview/overview.component';
import { OrderShoesComponent } from './order-shoes/order-shoes.component';
import { ManageInventoryComponent } from './manage-inventory/manage-inventory.component';
import { AuthGuard } from '../security/auth.guard';

const routes: Routes = [
  {path: '', component: DashboardHomeComponent,
  children: [
    {path: '', component: OverviewComponent},
    {path: 'order-shoes', component: OrderShoesComponent},
    {path: 'manage-inventory', component: ManageInventoryComponent}
  ]}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardModuleRoutingModule { }
