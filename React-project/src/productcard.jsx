import React from 'react';

const ProductCard = ({ product }) => (
  <div className="card shadow p-3">
    <img
      src={product.image}
      className="card-img-top"
      alt={product.title}
      style={{ height: '200px', objectFit: 'contain' }}
    />
    <div className="card-body">
      <h5 className="card-title">{product.title}</h5>
      <p className="card-text">Price: ${product.price}</p>
      <button className="btn btn-success">Add to Cart</button>
    </div>
  </div>
);

export default ProductCard;

