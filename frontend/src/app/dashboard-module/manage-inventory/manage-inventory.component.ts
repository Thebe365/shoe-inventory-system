import { Component } from '@angular/core';
import { faSearch } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-manage-inventory',
  templateUrl: './manage-inventory.component.html',
  styleUrls: ['./manage-inventory.component.css']
})
export class ManageInventoryComponent {

  
  faSearch = faSearch

  shoeUrl = '../../../assets/images/sneakers/'
  CloseModal(): void {
    const modal = document.getElementById('modal')!
    modal.style.display = 'none'
  }

  OpenModal(): void {
    const modal = document.getElementById('modal')!
    modal.style.display = 'block'
  }

  shoes: any[] = [
    {
      "name": "air max 90",
      "brand": "nike",
      "colors": ["black", "grey", "white", "red"]
    },
    {
      "name": "air force 1",
      "brand": "nike",
      "colors": ["black", "grey", "blue", "red"]
    },
    {
      "name": "gel nimbus 23",
      "brand": "asics",
      "colors": ["black", "grey", "white", "red", "orange"]
    },
    {
      "name": "run star hike",
      "brand": "converse",
      "colors": ["black", "grey", "white", "red", "orange"]
    },
    {
      "name": "nano 9",
      "brand": "reebok",
      "colors": ["black", "grey", "white", "red", "orange"]
    },
    {
      "name": "old skool",
      "brand": "vans",
      "colors": ["black", "grey", "white", "red"]
    },
    {
      "name": "era",
      "brand": "vans",
      "colors": ["black", "grey", "white", "red"]
    },
    {
      "name": "all star chuck taylor",
      "brand": "converse",
      "colors": ["black"]
    },
    {
      "name": "air max 270",
      "brand": "nike",
      "colors": ["black", "grey", "white", "red"]
    }
  ]
}
