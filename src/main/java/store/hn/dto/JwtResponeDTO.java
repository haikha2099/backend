package store.hn.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class JwtResponeDTO {
	
	
//	public JwtResponeDTO(String jwtToken, int id2, String username2, String string) {
//		this.token = jwtToken;
//		this.id = id2;
//		this.username = username2;
//		this.role = string;
//	}
	@NonNull
	private String token;
	
	@NonNull
	private int id;
	
	@NonNull
	private String username;
	@NonNull
	private String role;
	
	

}
