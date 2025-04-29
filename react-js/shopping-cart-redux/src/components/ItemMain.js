import { Component } from "react";
import ProductItem from "./ProductItem";
import CartList from "./CartList";
import { connect } from "react-redux";

class ItemMain extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    var { products } = this.props;
    var elmProducts = products.map((product, index) => {
      return <ProductItem key={index} product={product} />;
    });

    return (
      <section className="shop container">
        <h2 className="section-title">Products</h2>
        <div className="shop-content">{elmProducts}</div>
        <CartList />
      </section>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    products: state.products,
  };
};

const mapDispatchToProps = (dispatch, props) => {
  return {};
};

export default connect(mapStateToProps, mapDispatchToProps)(ItemMain);
