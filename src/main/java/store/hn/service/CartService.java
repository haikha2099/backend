package store.hn.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import store.hn.dto.CartDTO;
import store.hn.entity.Cart;
import store.hn.repository.ICartRepository;


@Service
public class CartService implements ICartService{
	
	@Autowired
	private ICartRepository ctRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Cart> getListCartItem() {
		
		return ctRepository.findAll();
	}

	@Override
	public void addCartItem(CartDTO ctitem) {
		Cart ctitemnew = modelMapper.map(ctitem, Cart.class);
		Cart itemnew = ctRepository.save(ctitemnew);
	}

	@Override
	public void deleteCartItem(int id) {
		ctRepository.deleteById(id);
		
	}


	@Override
	public void clearCart() {
		ctRepository.deleteAll();
		
	}

	@Override
	public int getCountItem() {
		
		return 0;
	}

	@Override
	public Cart updateCartItem(int id, int qty) {
		Cart ctitem = ctRepository.getById(id);
		ctitem.setQuantity(qty);
		ctRepository.save(ctitem);
		return ctitem;
	}

	@Override
	public Cart getTotalPrice(int id) {
		Cart item = ctRepository.getById(id);
		item.setPrice(item.getPrice()*item.getQuantity());
		return item;
	}

	

}
