import { Component } from '@angular/core';
import { faUser, faCartShopping } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent {

  faUser = faUser;
  faCart = faCartShopping;
  
}
