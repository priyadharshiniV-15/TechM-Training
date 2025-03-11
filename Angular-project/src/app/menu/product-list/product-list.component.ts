import { Component, OnInit } from '@angular/core';
import { FlowerlistService } from '../../services/flowerlist.service';
import { Flower } from '../../model/flower';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  flowers: Flower[] = [];
  searchText: string = ''; 
  constructor(private flowerService: FlowerlistService) {}

  ngOnInit(): void {
    this.flowerService.getFlowers().subscribe((data) => {
      this.flowers = data;
      

    });
  }
}
