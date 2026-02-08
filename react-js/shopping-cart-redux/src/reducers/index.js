import { combineReducers } from "redux";
import reducerProduct from "./products";
import reducerCart from "./cart";

const rootReducer = combineReducers({
  products: reducerProduct,
  cart: reducerCart,
});

export default rootReducer;
