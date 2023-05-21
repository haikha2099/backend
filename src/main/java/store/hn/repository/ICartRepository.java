package store.hn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store.hn.entity.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart>{

	boolean existsByid(int id);
	
//	@Query("SELECT ct FROM Cart ct WHERE ct.ac_id=:accountidParameter")
//	List<Cart> getCartByAccountId(@Param("accountidParameter") int ac_id);
}
