package store.hn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "Product")
@Data
public class Product {
	@Column(name = "pro_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pro_id;
	
	@Column(name = "pro_name", length = 50, nullable = false)
	private String pro_name;
	
	@Column(name = "pro_describe", length = 500, nullable = false)
	private String pro_describe;
	
	@Column(name = "price", length = 50, nullable = false)
	private String price;
	
	@Column(name = "image_url", length = 150, nullable = false)
	private String image_url;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "pro_detail", length = 500, nullable = false)
	private String pro_detail;
	
	@Column(name = "size", length = 150, nullable = false)
	private String size;
	
	@Column(name = "dateadd", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateadd;
	
	@Column(name = "cg_id", nullable = false)
	private int cg_id;
}
