import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ProductCard from './productcard';

const ProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get('/api.json') // Accesses api.json in the `public` folder
      .then(response => setProducts(response.data))
      .catch(error => console.error('Error fetching products:', error));
  }, []);

  return (
    <div className="row mt-4">
      {products.map(product => (
        <div className="col-md-4" key={product.id}>
          <ProductCard product={product} />
        </div>
      ))}
    </div>
  );
};

export default ProductList;

