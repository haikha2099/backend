package store.hn.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import store.hn.dto.OrdersDTO;
import store.hn.entity.Orders;
import store.hn.repository.IOrdersRepository;

@Service
public class OrdersService implements IOrdersService{
	
	@Autowired
	private IOrdersRepository odRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Orders> getListOrders() {
		
		return odRepository.findAll();
	}

	@Override
	public List<Orders> getListPagingProducts(Pageable pageale) {
		Page<Orders> orders_page = odRepository.findAll(pageale);
		return orders_page.getContent();
	}

	@Override
	public void creatOrders(OrdersDTO odDTO) {
		Orders newod = modelMapper.map(odDTO, Orders.class);
		
		odRepository.save(newod);
		
	}

	@Override
	public Orders updateOrders(int id) {
		Orders od = odRepository.getById(id);
		LocalDateTime now = LocalDateTime.now();
		od.setReceive_date(now.toString());
		od.setStatus(true);
		odRepository.save(od);
		return od;
	}

	
}
