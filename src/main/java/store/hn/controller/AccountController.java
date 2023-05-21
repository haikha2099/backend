package store.hn.controller;

import java.util.List;


import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import store.hn.dto.AccountDTO;
import store.hn.dto.ProductDTO;
import store.hn.entity.Account;
import store.hn.entity.Product;
import store.hn.repository.IAccountRepository;
import store.hn.service.AccountService;




@RestController
@RequestMapping(value = "api/accounts")
public class AccountController {

	@Autowired
	private AccountService acService;
	
	@Autowired
	private IAccountRepository acRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/list")
	public List<AccountDTO> getListAccounts() {
		
		List<Account> listAccount = acService.getListAccounts();
		
		List<AccountDTO> listAccountDTO = modelMapper.map(listAccount, new TypeToken< List<AccountDTO> >(){}.getType());
		
		return listAccountDTO;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") int id) {
		acService.deleteAccount(id);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Account deleted");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id") int id, @RequestBody Account ac) {
		System.out.println("id: " + id);
		
		acService.updateAccount(id, ac);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Account updated successfully");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@GetMapping(value = "/{username}")
	public AccountDTO getAccountByUserName(@PathVariable(name="username") String username) {
		Account ac = acService.getAccountByUsername(username);
		
		AccountDTO acDTO = modelMapper.map(ac, new TypeToken<AccountDTO>(){}.getType());
		System.out.println(acDTO);
		return acDTO;
	}
}
