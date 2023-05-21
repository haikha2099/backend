package store.hn.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.hn.dto.OrdersDTO;
import store.hn.dto.ProductDTO;
import store.hn.entity.Orders;
import store.hn.service.OrdersService;

@RestController
@RequestMapping(value = "api/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService odService;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@GetMapping(value = "/list")
	private List<OrdersDTO> getListOrders(){
		List<Orders> listOrders = odService.getListOrders();
		
		List<OrdersDTO> listOrdersDTO = modelMapper.map(listOrders, new TypeToken< List<OrdersDTO> >(){}.getType());
		return listOrdersDTO;
	}
	
	@GetMapping(value = "/listpage")
	private List<OrdersDTO> getListPagingOrders(Pageable pageable){
		List<Orders> listOrders = odService.getListPagingProducts(null);
		
		List<OrdersDTO> listOrdersDTO = modelMapper.map(listOrders, new TypeToken< List<OrdersDTO> >(){}.getType());
		return listOrdersDTO;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> creatOrders(@RequestBody OrdersDTO odDTO){
		System.out.println(odDTO);
		odService.creatOrders(odDTO);
		
		JSONObject message = new JSONObject();
		message.put("rusultText", "creat orders success");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateOrders(@PathVariable(name = "id") int id ) {
		System.out.println("id: " + id);
		
		odService.updateOrders(id);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Orders updated successfully");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
}
