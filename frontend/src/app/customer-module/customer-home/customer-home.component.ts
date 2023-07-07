import { Component } from '@angular/core';
import { faUser, faCartShopping, faSearch } from '@fortawesome/free-solid-svg-icons';
import { HostListener, ElementRef, Renderer2 } from '@angular/core';


@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent {

  private readonly transparentClass = 'transparent';
  private readonly whiteClass = 'white';

  constructor(private renderer: Renderer2, private elementRef: ElementRef) { }

  faUser = faUser;
  faCart = faCartShopping;
  faSearch = faSearch
 
  @HostListener('window:scroll', [])
  onWindowScroll() {

    // Add logic to change the color of the navigation div based on the scroll position
    const scrollPosition = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;

    if (scrollPosition > 0) {
      
      this.renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'red');
    } else {

      console.log("we on top")
      this.renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'transparent');
    }
  }
}
