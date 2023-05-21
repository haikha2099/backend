package store.hn.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDTO {
	
	private int cg_id;
	
	private String cg_name;
	
	private List<Product2> products;
	@Data
	static class Product2{
		private int pro_id;
		
		private String image_url;
		
		private String pro_name;
	}
}
