package store.hn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import store.hn.entity.Product;

public interface IProductService {

	List<Product> getListPagingProducts(Pageable pageale);
	
	List<Product> getListProducts();
	
	Product getProductInforByID(int id);
}
