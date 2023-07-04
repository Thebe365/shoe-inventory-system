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
  shoePrice = 0


  shoeobj = {

    brandName: '',
    shoeName: '',
    color: '',
    size: '',
    quantity: ''
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
      size: ['', Validators.required],
      quantity: ['', Validators.required]
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


  addShoe(){
    
    if(this.orderForm.valid){
      
      // get selected item's price
      this.allShoes.forEach(element => {
        
        if(element.shoeName == this.orderForm.value.shoeName){
          
          this.shoePrice = element.price
        }
      })

      // create shoe object
      this.shoeobj.shoeName = this.orderForm.value.shoeName
      this.shoeobj.brandName = this.orderForm.value.brandName
      this.shoeobj.color = this.orderForm.value.color
      this.shoeobj.size = this.orderForm.value.size
      this.shoeobj.quantity = this.orderForm.value.quantity
      
      // add shoe to allshoes
      this.allShoes.push(this.shoeobj)
      
      //clear shoe object
      this.shoeobj = {
        
        brandName: '',
        shoeName: '',
        color: '',
        size: '',
        quantity: ''
      }
      // clear form
      this.orderForm.reset()


    }else{

      Swal.fire({
        icon: 'error',
        title: 'Woops',
        text: 'Order Unsuccessful',
      })
    }
  }


  completeOrder(){

    
    //loop through allshoes and add to order
    this.allShoes.forEach(element => {
      
      this.apiServices.addShoes(element).subscribe(res =>{

        console.log(res)
        Swal.fire({
          icon: 'success',
          title: 'Success',
          text: 'Order completed',
        
      })
    
    })
  });

  }
}
