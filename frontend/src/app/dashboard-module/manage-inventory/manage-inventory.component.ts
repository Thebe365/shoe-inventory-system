import { Component, OnInit } from '@angular/core';
import { faSearch } from '@fortawesome/free-solid-svg-icons';
import { ShoeServiceService } from 'src/app/services/shoe-service.service';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-manage-inventory',
  templateUrl: './manage-inventory.component.html',
  styleUrls: ['./manage-inventory.component.css']
})
export class ManageInventoryComponent implements OnInit {
  

  // Constructor
  constructor(private apiService: ShoeServiceService, private route: ActivatedRoute){}

  faSearch = faSearch

  shoeUrl = '../../../assets/images/sneakers/'
  brandUrl = '../../../assets/images/'
  shoes = [];
  brands = [];
  brandName = '';
  searchTerm = '';
  shoeObj = [] 
  brandNameModal = ''
  shoeId = 0;
  brandId = 0;

  ngOnInit(): void {
      
    // Getting all brands
    this.apiService.getAllBrands().subscribe((res) =>{
    
      this.brands = Object.values(res)
      console.log("Getting all brands")
      console.log(this.brands)
        
      });

    // // get all shoes
    // this.apiService.getAllShoes().subscribe((res) =>{
      
    //   this.shoes = Object.values(res)
    //   console.log("Getting all shoe")
    //   console.log(this.shoes)
    
    // })

    // // get shoes by brand name
    // this.apiService.getShoesByBrandName("nike").subscribe((res) =>{ 
      
    //   this.shoes = Object.values(res)
    //   console.log("Getting a shoe by brand name")
    //   console.log(this.shoes)
    
    // })

      this.route.fragment.subscribe(fragment => {
        if (fragment === 'manage-brands') {
          this.OpenModal(this.brandNameModal)
        }
  
      })
  
      this.route.fragment.subscribe(fragment => {
        if (fragment === 'manage-shoe') {
          this.ManageModalOpen(this.shoeId)
        }
  
      })
    
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
      
      this.brandNameModal = brandName

      this.shoes = Object.values(res)
      
      // res.foreach(shoe => {
      //   this.shoes.push(shoe)
      // }
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

  /**
     * This function is used to filter the shoes array based on the name
     * 
     * @returns - the search results
     */
  search(): void {

    if (this.searchTerm === "") {

      // Empty search term, reset or reload the data
      this.ngOnInit();
    } else if (this.searchTerm) {

      // Non-empty search term, filter the shoes array
      this.shoes = this.shoes.filter((res: any) => {
        
        // checking if the search term is in the shoes name
        return res.name.toLocaleLowerCase().includes(this.searchTerm.toLocaleLowerCase());
      });
    }
  }
  /**
   * This function is used to detect if the user pressed the backspace key
   * 
   * @param event - This variable is used to detect if the user pressed the backspace key
   */
  onKeyUp(event: KeyboardEvent): void {
    if (event.key === 'Backspace') {
      // Backspace key pressed and search term is less than 3 characters
      this.ngOnInit();
    }
  }

  ManageModalOpen(id: number): void {

    console.log("Shoe id " + id)
    this.shoeId = id

    let shoe = this.shoes.find(shoe => shoe.id === id)

    this.shoeObj = [shoe]
    const manageModalBackdrop = document.getElementById('manage-backdrop')!
    const manageModal = document.getElementById('manage-modal')!

    manageModalBackdrop.style.display = 'block'
    manageModal.style.display = 'block'
  }

  ManageModalClose(): void {
    const manageModalBackdrop = document.getElementById('manage-backdrop')!
    const manageModal = document.getElementById('manage-modal')!

    manageModalBackdrop.style.display = 'none'
    manageModal.style.display = 'none'

  }

  // Delete shoe
  deleteShoe(id: number): void {
    this.apiService.deleteShoesById(id).subscribe((res) =>{


    })
  }

  

}
