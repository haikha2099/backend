package store.hn.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.CurrentTimestampFunction;
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
		AccountDTO acDTO = modelMapper.map(acRepository.findAccountByUsername(username),AccountDTO.class);
		
		System.out.println("load user: ");
		System.out.println(acDTO);
		
		if (acDTO == null) throw new UsernameNotFoundException(username);
		if (acDTO.getRole() != null) {
			return new User(
					acDTO.getUsername(),
					acDTO.getPassword(),
					AuthorityUtils.createAuthorityList(acDTO.getRole().toString())
			);
		}else {
			return new User(
					acDTO.getUsername(),
					acDTO.getPassword(),
					AuthorityUtils.createAuthorityList("Customer")
			);
		}
	}

	@Override
	public List<Account> getListAccounts() {
		return acRepository.findAll();
	}

	@Override
	public void deleteAccount(int id) {
		acRepository.deleteById(id);
		
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

	@Override
	public void updateAccount(int id, Account ac) {
		Account acinfor = acRepository.getById(id);
		
		acinfor.setFullname(ac.getFullname());
		acinfor.setPhone(ac.getPhone());
		acinfor.setAddress(ac.getAddress());
		acinfor.setDateupdate(ac.getDateupdate());
		
		acRepository.save(acinfor);
	}

	
	

}
