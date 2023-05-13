package store.hn.controller;

import java.util.List;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.hn.dto.CartDTO;
import store.hn.entity.Cart;
import store.hn.repository.ICartRepository;
import store.hn.service.CartService;

@RestController
@RequestMapping(value = "api/cart")
public class CartController {
	
	@Autowired
	private CartService ctService;
	
	@Autowired
	private ICartRepository ctRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping()
	public List<CartDTO> getListCartItem(){
		List<Cart> listCart = ctService.getListCartItem();
		
		List<CartDTO> listCartDTO = modelMapper.map(listCart, new TypeToken< List<CartDTO> >(){}.getType());
		
		return listCartDTO;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCartItem(@RequestBody CartDTO ctDTO){
		System.out.println(ctDTO);
		if(ctRepository.existsByid(ctDTO.getId())) {
			ctDTO.setQuantity(ctDTO.getQuantity()+1);
			System.out.println(ctDTO.getQuantity());
			ctService.updateCartItem(ctDTO.getId(), ctDTO.getQuantity());
		}
		else {
			ctService.addCartItem(ctDTO);
		}
		JSONObject message = new JSONObject();
		message.put("rusultText", "Đã thêm vào giỏ hàng");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	} 
	
}
