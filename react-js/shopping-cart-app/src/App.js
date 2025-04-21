import { Component } from "react";
import "./App.css";
import ItemHeader from "./components/ItemHeader";
import ItemMain from "./components/ItemMain";
import { productsData } from "./components/constants/ProductData";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: productsData,
      cart: [],
      quantity: 0,
    };
  }

  componentDidMount() {
    //componentWillMount
    if (localStorage && localStorage.getItem("PRODUCTS")) {
      var products = JSON.parse(localStorage.getItem("PRODUCTS"));
      this.setState({
        products: products,
      });
    }
    if (localStorage && localStorage.getItem("CART")) {
      var cart = JSON.parse(localStorage.getItem("CART"));
      this.setState({
        cart: cart,
      });
    }
  }

  findProductInCart = (cart, product) => {
    var index = -1;
    if (cart && cart.length > 0) {
      for (var i = 0; i < cart.length; i++) {
        if (cart[i].product.id === product.id) {
          index = i;
          break;
        }
      }
    }
    return index;
  };

  onAddToCart = (product) => {
    var quantity = 1;
    var cart = this.state.cart;
    var index = this.findProductInCart(cart, product);
    if (index !== -1) {
      var quantityNew = parseInt(cart[index].quantity) + 1;
      cart[index].quantity = quantityNew;
    } else {
      cart.push({
        product,
        quantity,
      });
    }
    this.setState({ cart });
    localStorage.setItem("CART", JSON.stringify(cart));
  };

  deleteCartItem = (product) => {
    var cart = this.state.cart;
    var index = this.findProductInCart(cart, product);
    if (index !== -1) {
      cart.splice(index, 1);
    }
    console.log("cart: ", cart);
    this.setState({ cart });
    localStorage.setItem("CART", JSON.stringify(cart));
  };

  onUpdateQuantity = (product, quantity) => {
    var cart = this.state.cart;
    var index = this.findProductInCart(cart, product);
    if (index !== -1) {
      cart[index].quantity = quantity;
    }
    this.setState({ cart });
    localStorage.setItem("CART", JSON.stringify(cart));
  };

  buyProduct = () => {
    alert('You buy product successfully')
    var cart = this.state.cart;
    cart.splice(0, cart.length);
    this.setState({ cart });
    localStorage.setItem("CART", JSON.stringify(cart));
  };

  render() {
    var { products, cart } = this.state;
    return (
      <div className="App">
        <ItemHeader></ItemHeader>
        <ItemMain
          products={products}
          onAddToCart={this.onAddToCart}
          cart={cart}
          deleteCartItem={this.deleteCartItem}
          onUpdateQuantity={this.onUpdateQuantity}
          buyProduct={this.buyProduct}
        />
      </div>
    );
  }
}

export default App;
