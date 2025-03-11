import { Component, Input } from '@angular/core';
import { CartService } from '../../../services/cart.service';
import { LoginService } from '../../../services/login.service';
@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent {
  @Input() flower: any;

  constructor(private cartService: CartService,private loginService: LoginService) {}

  addToCart(): void {
  
      this.cartService.addToCart(this.flower);
      alert(`Product added to cart: ${this.flower}`);


  }
}
