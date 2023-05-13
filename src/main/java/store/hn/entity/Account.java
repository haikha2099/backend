package store.hn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;



@Entity
@Table(name = "Account")
@Data
public class Account {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "password", length = 500, nullable = false)
	private String password;
	
	@Column(name = "fullname", length = 50, nullable = false)
	private String fullname;
	
	@Column(name = "phone", length = 50, nullable = false)
	private String phone;
	
	@Column(name = "address", length = 250, nullable = false)
	private String address;
	
	@Column(name = "email", length = 150, nullable = false)
	private String email;
	
	
	@Column(name = "dateupdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateupdate;
	
	@Column(name = "role", length = 250)
	private String role;
	
	@OneToMany(mappedBy = "account")
	private List<Cart> carts; 
}
