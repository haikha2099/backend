package store.hn.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrdersDTO {
	
	private int id;
	
	private String name_product;
	
	private double price;
	
	private Date dateadd;
	
	private Date receive_date;
	
	private boolean status;
	
	private Account2 account;
	@Data
	static class Account2{
		private int id;
	}
}
