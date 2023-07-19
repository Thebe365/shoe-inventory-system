import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ShoeServiceService {

  constructor(private http: HttpClient) { }

  // Server url
  url = "http://localhost:8080/api/v1/"

  // getting brand by id
  public getBrandById(id: number) {
    return this.http.request("GET", this.url + `brand/${id}`);
  }

  // Geting all brands
  public getAllBrands() {
    return this.http.request("GET", this.url + "brand/getAll");
  }

  // Getting shoes by brand name
  public getShoesByBrandName(brand: string) {
    return this.http.request("GET", this.url + `shoes/brand/${brand}`);
  }

  // getting all shoes
  public getAllShoes() {
    return this.http.request("GET", this.url + "shoes/getAll");
  }

  // Delete shoes by id
  public deleteShoesById(Shoe: Object) {
    return this.http.post(this.url + "shoes/delete", Shoe);
  }

  //add shoes
  public addShoes(shoe: any) {
    return this.http.post(this.url + "shoes/addShoe", shoe);
  }

  // delete brand by id
  public deleteBrandById(id: number) {
    return this.http.request("DELETE", this.url + `brand/${id}`);
  }

  // Order shoes
  public orderShoes(shoes: any) {
    return this.http.post(this.url + "customer/order", shoes);
  }
}
