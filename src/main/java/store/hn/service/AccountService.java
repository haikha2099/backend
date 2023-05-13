package store.hn.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import store.hn.dto.AccountDTO;
import store.hn.entity.Account;
import store.hn.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private IAccountRepository acRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account ac = acRepository.findByUsername(username);
		
		System.out.println("load user: ");
		System.out.println(ac);
		
		if (ac == null) throw new UsernameNotFoundException(username);
		if (ac.getRole() != null) {
			return new User(
					ac.getUsername(),
					ac.getPassword(),
					AuthorityUtils.createAuthorityList(ac.getRole().toString())
			);
		}else {
			return new User(
					ac.getUsername(),
					ac.getPassword(),
					AuthorityUtils.createAuthorityList("Customer")
			);
		}
	}

	@Override
	public List<Account> getListAccounts() {
		return acRepository.findAll();
	}

	@Override
	public void updateAccount(AccountDTO acDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(int id) {
		acRepository.deleteById(id);
		
	}

	@Override
	public void addNewAccount(AccountDTO acDTO) {
		Account ac = modelMapper.map(acDTO, Account.class);
		Account account = acRepository.save(ac);
	}

	@Override
	public void createAccount(Account ac) {
		acRepository.save(ac);
		
	}

	@Override
	public void changePasswordAccount(int id, String newpassword) {
		acRepository.changePasswordAccount(id, newpassword);
		
	}

	@Override
	public Account getAccountByUsername(String username) {
		return acRepository.findByUsername(username);
	}

	@Override
	public boolean isAccountExistsByUsername(String username) {
		return acRepository.existsByUsername(username);
	}

}
