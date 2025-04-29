import { Component } from "react";
import * as actions from "./../actions/index";
import { connect } from "react-redux";

class CartItem extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

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
          onClick={this.deleteCartItem}
        />
      </div>
    );
  }

  showSubTotal = (price, quantity) => {
    return price * quantity;
  };

  onHandleChange = (event) => {
    var value = event.target.value;
    if (value > 0) {
      this.props.quantity = value;
      this.props.onUpdateQuantity(this.props.product, this.props.quantity);
    }
  };

  deleteCartItem = () => {
    this.props.deleteCartItem(this.props.product);
  };

}

const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = (dispatch, props) => {
  return {
    deleteCartItem: (product) => {
      dispatch(actions.deleteCartItem(product));
    },
    onUpdateQuantity: (product, quantity) => {
      dispatch(actions.onUpdateQuantity(product, quantity));
    },
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(CartItem);
