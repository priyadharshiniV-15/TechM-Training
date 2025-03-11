import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cart: any[] = JSON.parse(localStorage.getItem('cart') || '[]');

  addToCart(flower: any): void {
    this.cart.push(flower);
    localStorage.setItem('cart', JSON.stringify(this.cart));
  }

  getCart(): any[] {
    return this.cart;
  }

  removeFromCart(flower: any): void {
    this.cart = this.cart.filter(item => item.name !== flower.name);
    localStorage.setItem('cart', JSON.stringify(this.cart));
  }
  updateCart(cart: any[]) {
    this.cart = cart;
    
  }

  clearCart() {
    this.cart = [];
}
}
