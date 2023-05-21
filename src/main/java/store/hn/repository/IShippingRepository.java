package store.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import store.hn.entity.Shipping;

@Repository
public interface IShippingRepository extends JpaRepository<Shipping, Integer>, JpaSpecificationExecutor<Shipping>{

}
