package store.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import store.hn.entity.Orders;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Integer>, JpaSpecificationExecutor<Orders>{

}
