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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import store.hn.dto.AccountDTO;
import store.hn.entity.Account;
import store.hn.repository.IAccountRepository;
import store.hn.service.AccountService;




@RestController
@RequestMapping(value = "api/accounts")
@Validated
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private AccountService acService;
	
	@Autowired
	private IAccountRepository acRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getListAccounts() {
		System.out.println("denday ");
//		List<Account> listAccount = acService.getListAccounts();
//		
//		List<AccountDTO> listAccountDTO = modelMapper.map(listAccount, new TypeToken< List<AccountDTO> >(){}.getType());
//		
		return ResponseEntity.status(HttpStatus.OK).body("oke");
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") int id) {
		acService.deleteAccount(id);
		JSONObject message = new JSONObject();
		message.put("rusultText", "Account deleted");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
//	@RequestMapping(value = "/changing-password", method = RequestMethod.POST)
//	public ResponseEntity<?> changePassword(@RequestParam(value = "username") String username, @RequestParam(value = "newPassword") String newPassword) {
//		System.out.println("new password: " + username);
//		System.out.println("new password: " + newPassword);
//		Account ac = acService.getAccountByUsername(username);
//		
//		System.out.println(ac.getId());
//		
//		acService.changePasswordAccount(ac.getId(), newPassword);
//		
//		JSONObject message = new JSONObject();
//		message.put("rusultText", "Account's password changed successfully");
//		message.put("status", 200);
//		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
//	}
	
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public ResponseEntity<?> addNewAccount(@RequestBody AccountDTO acDTO) {
//		System.out.println(acDTO);
//		acService.addNewAccount(acDTO);
//		JSONObject message = new JSONObject();
//		message.put("rusultText", "Account inserted successfully");
//		message.put("status", 200);
//		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
//	}
//	
//	@GetMapping(value="/{username}")
//	public Account getAccountByUsername(String username) {
//		
//		return acRepository.findAccoutByUsername(username);
//	}
	
	
	
}
