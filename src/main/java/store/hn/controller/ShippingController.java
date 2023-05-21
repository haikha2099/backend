package store.hn.controller;

import java.util.List;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.hn.dto.ShippingDTO;
import store.hn.entity.Shipping;
import store.hn.service.ShippingService;

@RestController
@RequestMapping(value = "api/ship")
public class ShippingController {
	
	@Autowired
	private ShippingService spService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/list")
	private List<ShippingDTO> getLisShipping(){
		List<Shipping> listShipping = spService.getListShipping();
		
		List<ShippingDTO> listShippingDTO = modelMapper.map(listShipping, new TypeToken< List<ShippingDTO> >(){}.getType());
		return listShippingDTO;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> creatShipping(@RequestBody ShippingDTO spDTO){
		System.out.println(spDTO);
		spService.creatShipping(spDTO);
		
		JSONObject message = new JSONObject();
		message.put("rusultText", "creat shipping success");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") int id, @RequestBody Shipping sp) {
		System.out.println("id: " + id);
		
		spService.updateShipping(id, sp);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Shipping updated successfully");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id) {
		spService.deleteShipping(id);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Shipping deleted");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
}
