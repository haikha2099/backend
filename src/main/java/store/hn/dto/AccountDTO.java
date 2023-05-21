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
	
	private List<Order> orders;
	
	private List<Shipping> shipping;
	@Data
	static class Cart{
		private int id;
		private int quantity;
		private Product product;
		
	}
	
	@Data
	static class Order{
		private int id;
		private String name_product;
		private Date dateadd;
		private Date receive_date;
	}
	
	@Data
	static class Product{
		
		private int id;
		
		private String pro_name;
		
		private double price;
		
		private String image_url;
	}
	
	@Data
	static class Shipping{
		private int id;
		private String address;
		private String phone;
	}
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateupdate;
}
