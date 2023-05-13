package store.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import store.hn.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{
	
	//Product findByproname(String pro_name);
}
