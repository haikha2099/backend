package store.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import store.hn.entity.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart>{

	boolean existsByid(int id);
}
