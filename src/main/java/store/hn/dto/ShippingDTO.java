package store.hn.dto;

import lombok.Data;

@Data
public class ShippingDTO {
	
	private String phone;
	
	private String address;
	
	private Account2 account;
	
	@Data
	static class Account2{
		private int id;
	}
}
