package store.hn.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import store.hn.dto.AccountDTO;
import store.hn.entity.Account;

public interface IAccountService extends UserDetailsService{

	List<Account> getListAccounts();
	
	void updateAccount (int id,Account ac);
	
	void deleteAccount(int id);
	
	
	public void createAccount(Account ac);
	
	void changePasswordAccount(int id, String newpassword);
	
	public Account getAccountByUsername(String username);
	
	public boolean isAccountExistsByUsername(String username);
	
	
}
