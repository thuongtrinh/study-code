import * as types from "../constants/ActionTypes";

export const listAllProducts = () => {
  return {
    type: types.LIST_ALL_PRODUCTS,
  };
};

export const listCart = () => {
  return {
    type: types.LIST_CART,
  };
};

export const onAddToCart = (product) => {
  return {
    type: types.ADD_TO_CART,
    product,
  };
};

export const deleteCartItem = (product) => {
  return {
    type: types.REMOVE_PRODUCT_CART,
    product, // product : product
  };
};

export const onUpdateQuantity = (product, quantity) => {
  return {
    type: types.UPDATE_QUANTITY,
    product,
    quantity,
  };
};

export const buyProduct = (cart) => {
  return {
    type: types.BUY_PRODUCT,
    cart,
  };
};
