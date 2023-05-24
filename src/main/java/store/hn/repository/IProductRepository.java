package store.hn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store.hn.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{
	
	//Product findByproname(String pro_name);
	
	@Query(value ="SELECT * FROM Product pd WHERE pd.pro_name like %?1%", nativeQuery = true)
	List <Product> searchProduct(String search);
	
	@Query(value ="SELECT * FROM Product pd WHERE pd.cg_id = ?1", nativeQuery = true)
	List <Product> getListByCategory(int cg_id);
}
