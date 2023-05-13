package store.hn.dto;

import lombok.Data;

@Data
public class CartDTO {
	
	private int id;
	
	private String name;
	
	private long price;
	
	private int quantity=1;
	
	private int ac_id;

}
