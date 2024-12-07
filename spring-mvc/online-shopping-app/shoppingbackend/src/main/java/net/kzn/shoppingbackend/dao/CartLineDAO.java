package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

    // the common methods from previous coded one
    public CartLine get(int id);

    public boolean add(CartLine cartLine);

    public boolean update(CartLine cartLine);

    public boolean delete(CartLine cartLine);

    public List<CartLine> list(int cartId);

    // one bussiness method related to the cart lines
    public List<CartLine> listAvailable(int cartId);

    public CartLine getByCartAndProduct(int cartId, int productId);

    // update a cart
    boolean updateCart(Cart cart);
}
