package store.hn.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import store.hn.dto.ProductDTO;
import store.hn.entity.Product;
import store.hn.repository.IProductRepository;



@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository pdRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	


	@Override
	public List<Product> getListPagingProducts(Pageable pageale) {
		Page<Product> pro_page = pdRepository.findAll(pageale);
		return pro_page.getContent();
	}


	@Override
	public Product getProductInforByID(int id) {
		return pdRepository.findById(id).get();
	}


	


	@Override
	public void deleteProduct(int pro_id) {
		pdRepository.deleteById(pro_id);
	}


	@Override
	public void updateProduct(int id, Product pd) {
		Product pdInfor = pdRepository.getById(id);
		
		pdInfor.setPro_name(pd.getPro_name());
		pdInfor.setPro_describe(pd.getPro_describe());
		pdInfor.setPrice(pd.getPrice());
		pdInfor.setImage_url(pd.getImage_url());
		pdInfor.setPro_detail(pd.getPro_detail());
		pdInfor.setQuantity(pd.getQuantity());
		pdInfor.setSize(pd.getSize());
		
		pdRepository.save(pdInfor);
	}

	@Override
	public void creatProduct(ProductDTO pdDTO) {
		Product newpd = modelMapper.map(pdDTO, Product.class);
		pdRepository.save(newpd);
		
	}


	@Override
	public List<Product> getListProducts() {
		
		return pdRepository.findAll(Sort.by(Sort.Direction.DESC, "dateadd"));
	}


	@Override
	public List<Product> searchProduct(String search) {
		return pdRepository.searchProduct(search);
	}


	@Override
	public List<Product> getListFeaturedProducts() {
		return null;
	}


	@Override
	public List<Product> getListProductByPrice(double firtPrice, double lastPrice) {
		List<Product> prolist = pdRepository.findAll();
		
		List<Product> list = new ArrayList<Product>();
		
		for(int i=0 ;i< prolist.size(); i++) {
			if(prolist.get(i).getPrice() >= firtPrice && prolist.get(i).getPrice() < lastPrice) {
				
				list.add(prolist.get(i));
			}
		}
		
		return list;
	}


	@Override
	public List<Product> getListProductByCategory(int cg_id) {
		
		return pdRepository.getListByCategory(cg_id);
	}


	
}
