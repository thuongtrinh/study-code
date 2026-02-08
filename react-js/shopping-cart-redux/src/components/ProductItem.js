import { Component } from "react";
import { connect } from "react-redux";
import * as actions from "./../actions/index";

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
          src={product.imagepath}
          alt={product.alt}
          className="product-img"
        />
        <h2 className="product-title">{product.productTitle}</h2>
        <span className="price">{product.price} €</span>
        <i
          className="bx bx-shopping-bag add-cart"
          onClick={this.onAddToCart}
        ></i>
      </div>
    );
  }

  onAddToCart = () => {
    this.props.onAddToCart(this.props.product);
  };
}

const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = (dispatch, props) => {
  return {
    onAddToCart: (product) => {
      dispatch(actions.onAddToCart(product));
    },
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(ProductItem);
