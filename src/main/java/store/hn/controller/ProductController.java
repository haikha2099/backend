package store.hn.controller;

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

import store.hn.dto.ProductDTO;
import store.hn.entity.Product;
import store.hn.service.ProductService;

@RestController
@RequestMapping(value = "api/product")
public class ProductController {
	
	@Autowired
	private ProductService pdService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/list")
	private List<ProductDTO> getLisProducts(){
		List<Product> listProduct = pdService.getListProducts();
		
		List<ProductDTO> listProductDTO = modelMapper.map(listProduct, new TypeToken< List<ProductDTO> >(){}.getType());
		return listProductDTO;
	}
	
	@GetMapping(value = "/listpage")
	private List<ProductDTO> getListProducts(Pageable pageable){
		List<Product> listProduct =  pdService.getListPagingProducts(pageable);
		
		List<ProductDTO> listProductDTO = modelMapper.map(listProduct, new TypeToken< List<ProductDTO> >(){}.getType());
		
		return listProductDTO;
	}
	
	@GetMapping(value = "/listsearch")
	private List<ProductDTO> getListSearchProducts(@RequestParam(name = "stringSearch") String search){
		List<Product> listProduct = pdService.searchProduct(search);
		
		List<ProductDTO> listProductDTO = modelMapper.map(listProduct, new TypeToken< List<ProductDTO> >(){}.getType());
		return listProductDTO;
	}
	
	@GetMapping(value = "/{pro_id}")
	public ProductDTO getProductById(@PathVariable(name="pro_id") int id) {
		Product product = pdService.getProductInforByID(id);
		
		ProductDTO productDTO = modelMapper.map(product, new TypeToken<ProductDTO>(){}.getType());
		System.out.println(productDTO);
		return productDTO;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> creatProduct(@RequestBody ProductDTO pdDTO){
		System.out.println(pdDTO);
		pdService.creatProduct(pdDTO);
		
		JSONObject message = new JSONObject();
		message.put("rusultText", "creat product success");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") int id, @RequestBody Product pd) {
		System.out.println("id: " + id);
		
		pdService.updateProduct(id, pd);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Product updated successfully");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id) {
		pdService.deleteProduct(id);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Product deleted");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@GetMapping(value = "/listfilter")
	private List<ProductDTO> getListProductFilter(@RequestParam double firstPrice,@RequestParam double lastPrice){
		List<Product> listProduct = pdService.getListProductByPrice(firstPrice, lastPrice);
		
		List<ProductDTO> listProductDTO = modelMapper.map(listProduct, new TypeToken< List<ProductDTO> >(){}.getType());
		return listProductDTO;
	}
	
	@GetMapping(value = "/listbycategory/{cg_id}")
	private List<ProductDTO> getListProductByCategory(@PathVariable(name = "cg_id") int cg_id){
		List<Product> listProduct = pdService.getListProductByCategory(cg_id);
		
		List<ProductDTO> listProductDTO = modelMapper.map(listProduct, new TypeToken< List<ProductDTO> >(){}.getType());
		return listProductDTO;
	}
}
