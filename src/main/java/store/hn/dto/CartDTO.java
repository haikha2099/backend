package store.hn.dto;


import lombok.Data;

@Data
public class CartDTO {
	
	private int id;
	
	private int quantity;
	
	private Product2 product;
	
	private Account2 account;
	
	@Data
	static class Account2{
		private int id;
	}
	
	@Data
	static class Product2{
		
		private int pro_id;
		
		private String pro_name;
		
		private double price;
		
		private String image_url;
	}

}
