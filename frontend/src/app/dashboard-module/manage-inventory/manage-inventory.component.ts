import { Component, OnInit } from '@angular/core';
import { faSearch } from '@fortawesome/free-solid-svg-icons';
import { ShoeServiceService } from 'src/app/services/shoe-service.service';


@Component({
  selector: 'app-manage-inventory',
  templateUrl: './manage-inventory.component.html',
  styleUrls: ['./manage-inventory.component.css']
})
export class ManageInventoryComponent implements OnInit {
  

  // Constructor
  constructor(private apiService: ShoeServiceService){}

  faSearch = faSearch

  shoeUrl = '../../../assets/images/sneakers/'
  brandUrl = '../../../assets/images/'
  shoes = [];
  brands = [];
  brandName = '';

  ngOnInit(): void {
      
    // Getting all brands
    this.apiService.getAllBrands().subscribe((res) =>{

      this.brands = Object.values(res)
      console.log(this.brands)
        
      });
    
  }

  CloseModal(): void {

    // Get the modal and the backdrop
    const modal = document.getElementById('modal')!
    const modal2 = document.getElementById('modal2')!
   

    // close the modal and back drop
    modal.style.display = 'none'
    modal2.style.display = 'none'
    
    // Enable scrolling abillity
    document.body.style.overflow = 'auto';
    
  }

  OpenModal(brandName: string): void {

    // get shoe by brand name
    this.apiService.getShoesByBrandName(brandName).subscribe((res) =>{
      
      this.brandName = brandName
      this.shoes = Object.values(res)
      console.log(this.shoes)
    })

    // Get the modal and the backdrop
    const modal = document.getElementById('modal')!
    const modal2 = document.getElementById('modal2')!

    // Display the modal and the backdrop
    modal.style.display = 'block'
    modal2.style.display = 'block'

    // Disable page scrolling
    document.body.style.overflow = 'hidden';
  }

}
