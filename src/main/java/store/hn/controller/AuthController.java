package store.hn.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.hn.dto.AccountDTO;
import store.hn.dto.JwtResponeDTO;
import store.hn.dto.SigninDTO;
import store.hn.dto.SignupDTO;
import store.hn.entity.Account;
import store.hn.repository.IAccountRepository;
import store.hn.service.AccountService;
import store.hn.utils.JwtUtils;

@RestController
@RequestMapping(value = "api/auth")
@Validated
@CrossOrigin("*")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AccountService acService;
	
	@Autowired
	private IAccountRepository acRepository;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody SigninDTO signinDTO){
		System.out.println("SigninDTO: ");
		System.out.println(signinDTO);
		
		//Account ac = acRepository.findAccountByUsername(signinDTO.getUsername());
		AccountDTO acDTO = modelMapper.map(acRepository.findAccountByUsername(signinDTO.getUsername()), AccountDTO.class);
//		System.out.println(ac);
		
		if (acDTO == null) throw new UsernameNotFoundException(signinDTO.getUsername());
		
		
		Authentication auth = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(signinDTO.getUsername(), signinDTO.getPassword())
		);
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String jwtToken = jwtUtils.generateJwtToken(auth);
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return ResponseEntity.ok(new JwtResponeDTO(
			jwtToken,acDTO.getId(),userDetails.getUsername(), userDetails.getAuthorities().toString()
		));
	}
	
	@PostMapping("/signup") 
	@Transactional
	public ResponseEntity<?> registerUser(@RequestBody @Valid SignupDTO SignupDTO) {
		System.out.println(SignupDTO.toString());
		
		if (acRepository.existsByUsername(SignupDTO.getUsername())) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}
		
		if (acRepository.existsByEmail(SignupDTO.getEmail())) {
			return ResponseEntity.badRequest().body("Error: Email is already taken!");
		}
		
		Account ac = modelMapper.map(SignupDTO, Account.class);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String enCryptPassword = passwordEncoder.encode(SignupDTO.getPassword());
		ac.setPassword(enCryptPassword);
		
		//ac.setStatus(Account.AccountStatus.NOT_ACTIVE);
		
		//acRepository.save(ac);
		
		acService.createAccount(ac);//Send mail active
		
		return ResponseEntity.ok().body("User registered successfully!");
	}

}
