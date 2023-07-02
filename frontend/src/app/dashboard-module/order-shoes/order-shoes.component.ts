import { Component, OnInit } from '@angular/core';
import { ShoeServiceService } from 'src/app/services/shoe-service.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-order-shoes',
  templateUrl: './order-shoes.component.html',
  styleUrls: ['./order-shoes.component.css']
})
export class OrderShoesComponent implements OnInit{

  // Constructor
  constructor(private apiServices: ShoeServiceService, private formBuilder: FormBuilder){}
  
  selectedItem: string
  brands = [];
  shoes = []
  allShoes = []
  orderForm: FormGroup

  shoeobj = {
    brandName: '',
    shoeName: '',
    color: '',
    size: ''
  }

  ngOnInit(): void {
    
    // Fetch all brand data
    this.apiServices.getAllBrands().subscribe(res =>{
      
      this.brands = Object.values(res)

    })

    // Order shoes form
    this.orderForm = this.formBuilder.group({
      brandName: ['', Validators.required],
      shoeName: ['', Validators.required],
      color: ['', Validators.required],
      size: ['', Validators.required]
    })

  }

  // Get all the shoes
  getShoes(brandName: string){
    
    console.log("selected brand " + brandName)
    this.apiServices.getShoesByBrandName(brandName).subscribe(res =>{

      this.shoes = Object.values(res)
      console.log(this.shoes)
    })
  }


  orderShoe(){
    
    if(this.orderForm.valid){

    }else{

      Swal.fire({
        icon: 'error',
        title: 'Woops',
        text: 'Form not complete',
      })
    }
  }
}
