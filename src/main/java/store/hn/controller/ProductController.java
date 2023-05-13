package store.hn.controller;

import java.util.List;

//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import store.hn.dto.ProductDTO;
import store.hn.entity.Product;
import store.hn.service.ProductService;

@RestController
@RequestMapping(value = "api/product")
public class ProductController {
	
	@Autowired
	private ProductService pdService;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
//	@GetMapping(value = "/list")
//	public List<ProductDTO> getListAccounts() {
//		
//		List<Product> listProduct = pdService.getListProducts();
//		
//		List<ProductDTO> listProductDTO = modelMapper.map(listProduct, new TypeToken< List<ProductDTO> >(){}.getType());
//		
//		return listProductDTO;
//	}
	@GetMapping(value = "/list")
	private List<Product> getLisProducts(){
		return pdService.getListProducts();
	}
	
	@GetMapping(value = "/listpage")
	private List<Product> getListProducts(Pageable pageable){
		return pdService.getListPagingProducts(pageable);
	}
	
	@GetMapping(value = "/{pro_id}")
	public Product getProductById(@PathVariable(name="pro_id") int id) {
		Product product = pdService.getProductInforByID(id);
		System.out.println(product);
		return product;
	}
}
