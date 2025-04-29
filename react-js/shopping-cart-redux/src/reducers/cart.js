import * as types from "../constants/ActionTypes";

var data = JSON.parse(localStorage.getItem("CART"));
var initialState = data ? data : [];
var reducerCart = (state = initialState, action) => {
  var index = -1;
  var quantity = -1;
  var product;
  switch (action.type) {
    case types.LIST_CART:
      return state;

    case types.ADD_TO_CART:
      product = action.product;
      console.log("action:", action);

      quantity = 1;
      index = findProductInCart(state, product);
      if (index !== -1) {
        var quantityNew = parseInt(state[index].quantity) + quantity;
        state[index].quantity = quantityNew;
      } else {
        state.push({
          product,
          quantity,
        });
      }
      localStorage.setItem("CART", JSON.stringify(state));
      return [...state];

    case types.REMOVE_PRODUCT_CART:
      product = action.product;
      index = findProductInCart(state, product);
      if (index !== -1) {
        state.splice(index, 1);
      }
      localStorage.setItem("CART", JSON.stringify(state));
      return [...state];

    case types.BUY_PRODUCT:
      if (state.length === 0) {
        alert("Not found product in cart, please add products");
      } else {
        alert("You buy product successfully");
        state.splice(0, state.length);
        localStorage.setItem("CART", JSON.stringify(state));
      }
      return [...state];

    case types.UPDATE_QUANTITY:
      product = action.product;
      quantity = action.quantity;
      index = findProductInCart(state, product);
      if (index !== -1) {
        state[index].quantity = quantity;
      }
      localStorage.setItem("CART", JSON.stringify(state));
      return [...state];
    default:
      return state;
  }
};

var findProductInCart = (cart, product) => {
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

export default reducerCart;
