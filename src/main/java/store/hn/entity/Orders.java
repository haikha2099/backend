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
	
	@Column(name = "oder_detail", length = 50, nullable = false)
	private String oder_detail;
	
	@Column(name = "dateadd", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateadd;
	
	@Column(name = "status", nullable = false)
	//@Column(name = "status", columnDefinition = "ENUM('NOT_ACTIVE', 'ACTIVE')")
	@Enumerated(EnumType.ORDINAL)
	private OrderStatus status;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = true)
//	private Account user_id;
	
	public enum OrderStatus{
		
	}
}
