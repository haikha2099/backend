package store.hn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import store.hn.entity.Product;
import store.hn.repository.IProductRepository;



@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository pdRepository;
	
	
	@Override
	public List<Product> getListProducts(){
		return pdRepository.findAll();
	}


	@Override
	public List<Product> getListPagingProducts(Pageable pageale) {
		Page<Product> pro_page = pdRepository.findAll(pageale);
		return pro_page.getContent();
	}


	@Override
	public Product getProductInforByID(int id) {
		// TODO Auto-generated method stub
		return pdRepository.findById(id).get();
	}


//	@Override
//	public Product getProductInforById(int pro_id) {
//		
//		return pdRepository.getById(pro_id);
//	}


	
}
