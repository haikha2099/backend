package store.hn.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AccountDTO {
	private int id;
	
	private String  username;
	
	private String password;
	
	private String  fullname;
	
	private String phone;
	
	private String address;
	
	private String email;
	
	private String role;
	
	private List<Cart> carts;
	@Data
	static class Cart{
		private int id;
		private int quantity;
	}
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateupdate;
}
