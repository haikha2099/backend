package store.hn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;




@Entity
@Table(name = "Orders")
@Data
public class Orders {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name_product", length = 5000)
	private String name_product;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "dateadd", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateadd;
	
	@Column(name = "receive_date",length =50)
	private String receive_date;
	
	@Column(name = "status",length =50)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name ="ac_id",referencedColumnName = "id")
	private Account account;
}
