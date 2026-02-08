import { Component } from "react";
import CartItem from "./CartItem";

class CartList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      total: 0
    };
  }

  buyProduct = () => {
    this.props.buyProduct();
}

  render() {
    var { cart } = this.props;
    var total = this.state.total;
    var elmCartList = cart.map((data, index) => {
      total += data.product.price * data.quantity;
      return (
        <CartItem
          key={index}
          product={data.product}
          quantity={data.quantity}
          deleteCartItem={this.props.deleteCartItem}
          onUpdateQuantity={this.props.onUpdateQuantity}
        />
      );
    });

    return (
      <div className="cart">
        <h2 className="cart-title">Your Cart</h2>
        <div className="cart-content">
          <div className="cart-list">{elmCartList}</div>
        </div>
        <div className="total">
          <div className="total-title">Total</div>
          <div className="total-price">{total} €</div>
        </div>
        <button type="button" className="btn-buy" onClick={this.buyProduct}>
          Buy Now
        </button>
        <i className="bx bx-x" id="close-cart"></i>
      </div>
    );
  }
}

export default CartList;
