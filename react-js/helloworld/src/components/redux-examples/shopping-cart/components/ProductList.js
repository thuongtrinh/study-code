import { connect } from "react-redux";
import Product from "./Product";
import { addToCart } from "../actions/index.js";
import { getVisibleProducts } from "../reducers/products.js";
import PropTypes from "prop-types";

const ProductsList = ({ products, addToCart }) =>
  products.map((product) => (
    <div key={product.id}>
      <Product
        title={product.title}
        price={product.price}
        quantity={product.quantity}
      />
      <button
        onClick={addToCart(product.id)}
        disabled={product.inventory > 0 ? "" : "disabled"}
      >
        {product.inventory > 0 ? "Add to cart" : "Sold Out"}
      </button>
      <div style={{ marginBottom: 20 }}></div>
    </div>
  ));

const mapStateToProps = (state) => ({
  products: getVisibleProducts(state.products), //state.products,
});

ProductsList.propTypes = {
  products: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      title: PropTypes.string.isRequired,
      price: PropTypes.number.isRequired,
      inventory: PropTypes.number.isRequired
    })
  ).isRequired,
  addToCart: PropTypes.func.isRequired
}

// function mapDispatchToProps(dispatch) {
//   return {
//     addToCart: (id) => dispatch(addToCart(id)),
//   };
// }
// export default connect(mapStateToProps, mapDispatchToProps)(ProductsList);

export default connect(mapStateToProps, { addToCart })(ProductsList);
