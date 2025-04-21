import { Component } from "react";

class ProductItem extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    var { product } = this.props;
    return (
      <div className="product-box">
        <img
          src={this.props.product.imagepath}
          alt={this.props.product.alt}
          className="product-img"
        />
        <h2 className="product-title">{this.props.product.productTitle}</h2>
        <span className="price">{this.props.product.price} €</span>
        <i
          className="bx bx-shopping-bag add-cart"
          onClick={() => this.onAddToCart(product)}
        ></i>
      </div>
    );
  }

  onAddToCart = (product) => {
    this.props.onAddToCart(product);
  };
}

export default ProductItem;
