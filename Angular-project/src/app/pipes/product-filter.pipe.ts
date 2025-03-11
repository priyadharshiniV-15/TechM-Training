import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'productFilter'
})
export class ProductFilterPipe implements PipeTransform {

  transform(products: any[], searchText: string): any[] {
    if (!products) return [];
    if (!searchText) return products;

    searchText = searchText.toLowerCase();

    return products.filter(product => 
      product.name.toLowerCase().includes(searchText) ||
      product.price.toString().includes(searchText)
    );
  }
}
