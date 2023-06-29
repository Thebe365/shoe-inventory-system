import { Component, OnInit } from '@angular/core';
import { faSearch } from '@fortawesome/free-solid-svg-icons';
import { HttpClient } from '@angular/common/http';
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
  shoeObject: object

  ngOnInit(): void {
      
    this.apiService.getBrandById(1).subscribe(res =>{
    
      console.log(res)
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

  OpenModal(): void {

    // Get the modal and the backdrop
    const modal = document.getElementById('modal')!
    const modal2 = document.getElementById('modal2')!

    // Display the modal and the backdrop
    modal.style.display = 'block'
    modal2.style.display = 'block'

    // Disable page scrolling
    document.body.style.overflow = 'hidden';
  }

  shoes: any[] = [
    {
      "name": "air max 90",
      "brand": "nike",
      "colors": ["black", "grey", "white", "red"],
      "sizes": [6,7,8,9,10]
    },
    {
      "name": "air force 1",
      "brand": "nike",
      "colors": ["black", "grey", "blue", "red"],
      "sizes": [6,7,8,10]
    },
    {
      "name": "gel nimbus 23",
      "brand": "asics",
      "colors": ["black", "grey", "white", "red", "orange"],
      "sizes": [6,7,8,9]
    },
    {
      "name": "run star hike",
      "brand": "converse",
      "colors": ["black", "grey", "white", "red", "orange"],
      "sizes": [6,8,9,10]
    },
    {
      "name": "nano 9",
      "brand": "reebok",
      "colors": ["black", "grey", "white", "red", "orange"],
      "sizes": [6,7,8,9,10,11]
    },
    {
      "name": "old skool",
      "brand": "vans",
      "colors": ["black", "grey", "white", "red"],
      "sizes": [6,7,8,10,11]
    },
    {
      "name": "era",
      "brand": "vans",
      "colors": ["black", "grey", "white", "red"],
      "sizes": [5,6,7,8,9,10,11]
    },
    {
      "name": "all star chuck taylor",
      "brand": "converse",
      "colors": ["black"],
      "sizes": [6,7,8,9,11]
    },
    {
      "name": "air max 270",
      "brand": "nike",
      "colors": ["black", "grey", "white", "red"]
    }
  ]
}
