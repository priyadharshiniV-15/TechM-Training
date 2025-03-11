import { Component } from '@angular/core';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent {
  cartItems: any[] = [];

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.cartItems = this.cartService.getCart();
  }
  handleImageError(item: any) {
    item.image = 'assets/images/placeholder.jpg';  // Default fallback image
  }
  getTotalPrice(): number {
    return this.cartItems.reduce((total, item) => total + item.price, 0);
  }
  checkout() {
    if (this.cartItems.length === 0) {
      alert('Your cart is empty. Please add items before proceeding.');
      return;
    }
  
    alert('Thank you for your purchase! Your order has been placed successfully.');
  
    // Clear cart array
    this.cartItems = [];
  
    // Clear persistent storage if used
    localStorage.removeItem('cart'); // or sessionStorage.removeItem('cart');
  
    // If using a service, clear the data there too
    this.cartService.clearCart();
  }
  
  
  removeFromCart(flower: any): void {
    this.cartService.removeFromCart(flower);
    this.cartItems = this.cartService.getCart(); // Refresh cart after removal
    alert(`${flower.name} has been removed from your cart.`);
  }
}
