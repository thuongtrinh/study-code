import { Provider } from "react-redux";
import { applyMiddleware, createStore } from "redux";
import shoppingCartRootReducer from "./reducers";
import ProductsList from "./components/ProductList.js";
import Cart from "./components/Cart.js";
import { getAllProducts } from "./actions/index.js";
import { thunk } from "redux-thunk";
import { createLogger } from "redux-logger";

const middleware = [thunk];
if (process.env.NODE_ENV !== "production") {
  middleware.push(createLogger());
}

const store = createStore(
  shoppingCartRootReducer,
  applyMiddleware(...middleware)
);

store.dispatch(getAllProducts());

const ShoppingCart = () => {
  return (
    <>
      <Provider store={store}>
        <h2>Shopping Cart App</h2>
        <hr />
        <ProductsList />
        <hr />
        <Cart />
      </Provider>
    </>
  );
};

export default ShoppingCart;
