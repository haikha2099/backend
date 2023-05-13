package store.hn.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import store.hn.dto.AccountDTO;
import store.hn.entity.Account;

public interface IAccountService extends UserDetailsService{

	List<Account> getListAccounts();
	
	void updateAccount (AccountDTO acDTO);
	
	void deleteAccount(int id);
	
	void addNewAccount(AccountDTO acDTO);
	
	public void createAccount(Account ac);
	
	void changePasswordAccount(int id, String newpassword);
	
	public Account getAccountByUsername(String username);
	
	public boolean isAccountExistsByUsername(String username);
	
	
}
