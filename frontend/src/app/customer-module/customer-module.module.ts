import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerModuleRoutingModule } from './customer-module-routing.module';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    CustomerHomeComponent
  ],
  imports: [
    CommonModule,
    CustomerModuleRoutingModule,
    FontAwesomeModule 
  ]
})
export class CustomerModuleModule { }
