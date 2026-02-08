import * as types from "../constants/ActionTypes";
import { productsData } from "../constants/ProductData";

var initialState = productsData;
var reducerProduct = (state = initialState, action) => {
  switch (action.type) {
    case types.LIST_ALL_PRODUCTS:
      return state;
    default:
      return state;
  }
};

export default reducerProduct;
