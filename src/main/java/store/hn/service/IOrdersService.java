package store.hn.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import store.hn.dto.OrdersDTO;
import store.hn.entity.Orders;

public interface IOrdersService {
	
	List<Orders> getListOrders();
	
	List<Orders> getListPagingProducts(Pageable pageale);
	
	public void creatOrders(OrdersDTO odDTO);
	
	public Orders updateOrders(int id);
}
