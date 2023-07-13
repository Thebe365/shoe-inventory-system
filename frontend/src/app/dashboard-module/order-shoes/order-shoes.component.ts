import { Component, OnInit } from '@angular/core';
import { ShoeServiceService } from 'src/app/services/shoe-service.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { ShoeInstance } from 'src/app/model/shoe';


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
  shoesToAdd = []
  orderForm: FormGroup
  shoePrice = ''

  sizes = [
    {value: '6', viewValue: '6'},
    {value: '7', viewValue: '7'},
    {value: '8', viewValue: '8'},
    {value: '9', viewValue: '9'},
    {value: '10', viewValue: '10'},
    {value: '11', viewValue: '11'}
  ]
  colors = [
    {value: 'black', viewValue: 'Black'},
    {value: 'red', viewValue: 'Red'},
    {value: 'white', viewValue: 'White'}
  ]
  selectedSize: string
  selectedColor: string
  selectedShoe: string


  shoeobj = {
    id : '',
    brandName: '',
    name: '',
    color: '',
    size: '',
    quantity: ''
    
  }


  


  ngOnInit(): void {
    
    // Fetch all brand data
    this.apiServices.getAllBrands().subscribe(res =>{
      
      this.brands = Object.values(res)

    })

    this.apiServices.getAllShoes().subscribe(res =>{
      this.allShoes = Object.values(res)
    })

    // Order shoes form
    this.orderForm = this.formBuilder.group({
      brandName: ['', Validators.required],
      name: ['', Validators.required],
      color: ['', Validators.required],
      size: ['', Validators.required],
      quantity: [, Validators.required]
    })

    

  }

  /**
   * This method is called when a brand is selected
   * It gets the brand's shoes
   * 
   * @param brandName - The brand of the shoes to be fetched
   */
  getShoes(brandName: string){
    
    console.log("selected brand " + brandName)
    this.apiServices.getShoesByBrandName(brandName).subscribe((res) =>{

      this.shoes = Object.values(res)
      console.log(this.shoes)
    })
  }

  /**
   * This method adds
   */
  targetShoe:any; 
  addShoe(){
    

    this.orderForm.setValue({
      brandName: this.orderForm.value.brandName,
      name: this.orderForm.value.name,
      color: this.orderForm.value.color,
      size: this.orderForm.value.size,
      quantity: this.orderForm.value.quantity
    })
    this.allShoes.forEach(element => {
      if(element.name == this.orderForm.value.name){
        this.targetShoe = element
      }
    })

    
    
    if(this.orderForm.valid){
      
      // create shoe object
      this.shoeobj = this.orderForm.value

      // populating form controls

      console.log('Shoe Object: ',this.shoeobj)
      
      
      // add shoe to allshoes
      this.shoesToAdd.push(this.shoeobj)
      
      //clear shoe object
      
      
      // clear form
      this.orderForm.reset()
    }else{
      console.error("Invalid Form: ", this.orderForm.value)
    
      Swal.fire({
        icon: 'error',
        title: 'Woops',
        text: 'Order Unsuccessful',
      })
    }
  }


  completeOrder(){

    //loop through allshoes and add to order
    this.apiServices.addShoes(this.shoeobj).subscribe((res) =>{
      if (res) {
        this.shoeobj = {
          id: '',
          brandName: '',
          name: '',
          color: '',
          size: '',
          quantity: ''
        }
        console.log("Shoe added successfully: ",res)
      }
      else {
        console.error("Error adding shoe: ", res)
      }
    })
    
  }
}