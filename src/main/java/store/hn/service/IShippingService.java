package store.hn.service;

import java.util.List;

import store.hn.dto.ShippingDTO;
import store.hn.entity.Shipping;

public interface IShippingService {
	
	List<Shipping> getListShipping();
	
	public void creatShipping(ShippingDTO spDTO);
	
	void updateShipping(int id, Shipping sp);
	
	void deleteShipping(int id);
}
