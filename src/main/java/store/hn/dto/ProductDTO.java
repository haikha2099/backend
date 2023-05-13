package store.hn.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int pro_id;
	
	private String pro_name;
	
	private String pro_describe;
	
	private long price;
	
	private String image_url;
	
	private int quantity;
	
	private String pro_detail;
	
	private String size;
	
	private Date dateadd;
	
	private int cg_id;
}
