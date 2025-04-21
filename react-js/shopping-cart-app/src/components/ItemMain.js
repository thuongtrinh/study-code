import { Component } from "react";
import ProductItem from "./ProductItem";
import CartList from "./CartList";

class ItemMain extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    var { products, cart } = this.props;
    var elmProducts = products.map((product, index) => {
      return (
        <ProductItem
          key={index}
          product={product}
          onAddToCart={this.props.onAddToCart}
        />
      );
    });

    return (
      <section className="shop container">
        <h2 className="section-title">Products</h2>
        <div className="shop-content">{elmProducts}</div>
        <CartList
          cart={cart}
          deleteCartItem={this.props.deleteCartItem}
          onUpdateQuantity={this.props.onUpdateQuantity}
          buyProduct={this.props.buyProduct}
        />
      </section>
    );
  }
}

export default ItemMain;
