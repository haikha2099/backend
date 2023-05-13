package store.hn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Cart")
@Data
public class Cart {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private long price;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "ac_id",referencedColumnName = "id" )
	private Account account;
	
}
