import { Component } from "react";
import CartItem from "./CartItem";
import { connect } from "react-redux";
import * as actions from "./../actions/index";

class CartList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      total: 0,
    };
  }

  render() {
    var { cart } = this.props;
    var total = this.state.total;
    var elmCartList = cart.map((data, index) => {
      total += data.product.price * data.quantity;
      return (
        <CartItem key={index} product={data.product} quantity={data.quantity} />
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

  buyProduct = () => {
    this.props.buyProduct(this.props.cart);
  };
}

const mapStateToProps = (state) => {
  return {
    cart: state.cart,
  };
};

const mapDispatchToProps = (dispatch, props) => {
  return {
    buyProduct: (cart) => {
      dispatch(actions.buyProduct(cart));
    },
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(CartList);
