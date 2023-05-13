package store.hn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store.hn.dto.AccountDTO;
import store.hn.entity.Account;


@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account>{

	@Query("UPDATE Account SET password =: newPassword WHERE id =: id")
	List<Account> changePasswordAccount(int id, String newPaswword);
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);
	
	//Account findByEmail(String email);
	
	Account findByUsername(String username);
	

	@Query("SELECT ac FROM Account ac WHERE ac.username=:usernameParameter")
    Account findAccountByUsername(@Param("usernameParameter") String username);
}
