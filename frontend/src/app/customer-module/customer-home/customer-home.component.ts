import { Component, OnInit } from '@angular/core';
import { ShoeServiceService } from 'src/app/services/shoe-service.service';
import { faUser, faCartShopping, faSearch, faTimes } from '@fortawesome/free-solid-svg-icons';
import { HostListener, ElementRef, Renderer2 } from '@angular/core';
import Swal  from 'sweetalert2';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit{

  constructor(private shoeService: ShoeServiceService) { }

  // ICONS
  faUser = faUser;
  faCart = faCartShopping;
  faSearch = faSearch
  faTimes = faTimes

  cartOpen = false;

  // cart list
  cartList = []
  shoes = []
  shoe = {
    name: "",
    price: 0,
    image: "",
    id: 0
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {

    // Add logic to change the color of the navigation div based on the scroll position
    const scrollPosition = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    const icon = document.getElementById("user-icon")
    const cart = document.getElementById("cart-icon")
    const navbar = document.getElementById("navigation");

    if (scrollPosition > 0) {

      navbar.style.backgroundColor = "white";
      navbar.style.boxShadow = "rgba(0, 0, 0, 0.2) 0px 20px 30px";
      icon.style.color = "black"
      cart.style.color = "black"
    } else {

      console.log("we there")
      navbar.style.backgroundColor = "transparent";
      icon.style.color = "white"
      cart.style.color = "white"
      navbar.style.boxShadow = "none"
    }
  }

  // DISPLAY MODAL
  displayModal(id: number){

    // Find shoe by id
    const shoe = this.shoes.find(shoe => shoe.id === id)

    this.shoe = {
      name: shoe.name,
      price: shoe.price,
      image: shoe.name,
      id: shoe.id
    }

    console.log(shoe)

    // Get shoe data
    const modal = document.getElementById("modal")
    const backdrop = document.getElementById("backDrop")

    modal.style.display = "flex"
    backdrop.style.display = "block"

  }

  // Close modal
  closeModal(){

    const modal = document.getElementById("modal")
    const backdrop = document.getElementById("backDrop")
    const cart = document.getElementById("cart")

    modal.style.display = "none"
    backdrop.style.display = "none"

    if(this.cartOpen){
      cart.style.transform = "translateX(100%)"
    }
  }

  // Open cart
  openCart(){
    this.cartOpen = true;
    
    // Open cart
    const cart = document.getElementById("cart")
    const backdrop = document.getElementById("backDrop")

    cart.style.transform = "translateX(0%)"
    backdrop.style.display = "block"
  }

  // Close cart
  closeCart(){

    const cart = document.getElementById("cart")
    const backdrop = document.getElementById("backDrop")

    cart.style.transform = "translateX(100%)"
    backdrop.style.display = "none"
  
  }

  ngOnInit(): void {

    // get cart data from local storage
    this.cartList = JSON.parse(localStorage.getItem("cart")) || []
      
    // Get all shoes
    this.shoeService.getAllShoes().subscribe(res => {

      this.shoes = Object.values(res);
      console.log(this.shoes)
    
    })
  }

  // Add shoe to cart
  addToCart(id: number){

    // make sure there is no duplicate shoe in cart
    if(this.cartList.find(shoe => shoe.id === id)){
      
      // alert user that shoe is already in cart
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'This shoe is already in your cart!'
        
        })
        
    }else{

      // find shoe by id and store in cart
      this.cartList.push(this.shoes.find(shoe => shoe.id === id))

      // shoe list to local storage
      localStorage.setItem("cart", JSON.stringify(this.cartList))

      // cart list 
      console.log(this.cartList)
    }
      

  }

  // Remove shoe from cart
  removeFromCart(id: number){
    
    // find shoe by id and remove from cart
    this.cartList = this.cartList.filter(shoe => shoe.id !== id)

    // shoe list to local storage
    localStorage.setItem("cart", JSON.stringify(this.cartList))

    // cart list 
    console.log(this.cartList)

  }
}
