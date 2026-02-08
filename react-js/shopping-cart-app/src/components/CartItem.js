import { Component } from "react";

class CartItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      product: props.product,
      quantity: props.quantity,
    };
  }

  onHandleChange = (event) => {
    var value = event.target.value;
    if (value > 0) {
      this.setState({
        quantity: value,
      });
      this.props.onUpdateQuantity(this.state.product, this.state.quantity);
    }
  };

  deleteCartItem = (product) => {
    this.props.deleteCartItem(product);
  };

  showSubTotal = (price, quantity) => {
    return price * quantity;
  };

  render() {
    var { product, quantity } = this.props;
    return (
      <div className="cart-box">
        <img src={product.imagepath} alt={product.alt} className="cart-img" />
        <div className="detail-box">
          <div className="cart-product-title">{product.productTitle}</div>
          <div className="cart-price">
            {this.showSubTotal(product.price, quantity)} €
          </div>
          <input
            type="number"
            className="cart-quantity"
            value={quantity}
            onChange={this.onHandleChange}
          />
        </div>
        <i
          className="bx bxs-trash-alt cart-remove"
          onClick={() => this.deleteCartItem(product)}
        />
      </div>
    );
  }
}

export default CartItem;
