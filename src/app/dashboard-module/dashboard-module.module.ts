import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardModuleRoutingModule } from './dashboard-module-routing.module';
import { DashboardHomeComponent } from './dashboard-home/dashboard-home.component';
import { OverviewComponent } from './overview/overview.component';
import { OrderShoesComponent } from './order-shoes/order-shoes.component';
import { ManageInventoryComponent } from './manage-inventory/manage-inventory.component';
import { SettingsComponent } from './settings/settings.component';


@NgModule({
  declarations: [
    DashboardHomeComponent,
    OverviewComponent,
    OrderShoesComponent,
    ManageInventoryComponent,
    SettingsComponent
  ],
  imports: [
    CommonModule,
    DashboardModuleRoutingModule
  ]
})
export class DashboardModuleModule { }
