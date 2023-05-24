package store.hn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import store.hn.dto.ProductDTO;
import store.hn.entity.Product;

public interface IProductService {

	List<Product> getListPagingProducts(Pageable pageale);
	
	List<Product> getListProducts();
	
	List<Product> searchProduct(String search);
	
	List<Product> getListFeaturedProducts();
	
	Product getProductInforByID(int id);
	
	void creatProduct(ProductDTO pdDTO);
	
	void deleteProduct(int pro_id);
	
	void updateProduct(int id, Product pd);
	
	List<Product> getListProductByPrice(double firtPrice, double lastPrice);
	
	List<Product> getListProductByCategory(int cg_id);
}
