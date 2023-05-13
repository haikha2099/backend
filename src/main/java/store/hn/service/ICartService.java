package store.hn.service;

import java.util.List;

import store.hn.dto.CartDTO;
import store.hn.entity.Cart;

public interface ICartService {
	
	List<Cart> getListCartItem();

	void addCartItem(CartDTO ctitem);
	
	void deleteCartItem(int id);
	
	public Cart updateCartItem(int id, int qty);
	
	void clearCart();
	
	public int getCountItem();
	
	public Cart getTotalPrice(int id);
}
