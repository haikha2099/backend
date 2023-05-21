package store.hn.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class JwtResponeDTO {
	
	@NonNull
	private String token;
	
	@NonNull
	private int id;
	
	@NonNull
	private String username;
	@NonNull
	private String role;
	
	

}
