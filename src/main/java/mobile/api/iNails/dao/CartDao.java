package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import mobile.api.iNails.domain.Cart;

@Service
public interface CartDao {
    public List<Cart> findAllCarts();
    public List<Cart> findCartsByOrderNumber(int orderID);
    public Cart findCart(int cartID);
    public int createCart(Cart cart);
    public int updateCart(Cart cart);
    public int deleteCart(int orderID);
}
