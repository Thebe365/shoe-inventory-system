import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderShoesComponent } from './order-shoes.component';

describe('OrderShoesComponent', () => {
  let component: OrderShoesComponent;
  let fixture: ComponentFixture<OrderShoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderShoesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderShoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
