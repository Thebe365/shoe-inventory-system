import { Component } from '@angular/core';
import { faChartBar, faSearch, faBars, faUser, faEdit, faGears, faSignOut, faClipboardList } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-dashboard-home',
  templateUrl: './dashboard-home.component.html',
  styleUrls: ['./dashboard-home.component.css']
})
export class DashboardHomeComponent {

  faChartBar = faChartBar
  faSearch = faSearch
  faBars = faBars
  faUser = faUser
  faEdit = faEdit
  faGears = faGears
  faSignOut = faSignOut
  faClipboardList = faClipboardList
  

toggleMenu(): void {

  const toggle: HTMLElement | null = document.querySelector('.toggle');
  const navigation: HTMLElement | null = document.querySelector('.navigation');
  const main: HTMLElement | null = document.querySelector('.main');

  if (toggle && navigation && main) {
    toggle.classList.toggle('active');
    navigation.classList.toggle('active');
    main.classList.toggle('active');
  }
}
}
