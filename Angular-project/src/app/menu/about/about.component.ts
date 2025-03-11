import { Component } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent {
    subscribe() {
        alert('🎉 Thank you for subscribing! Enjoy 20% off your first order.');
    }
}
