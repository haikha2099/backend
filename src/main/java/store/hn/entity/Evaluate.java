package store.hn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Evaluate")
public class Evaluate {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "point", nullable = false)
	private int point;
	
	@Column(name = "content", length = 500, nullable = false)
	private String content;
	
//	@ManyToOne
//	@JoinColumn(name = "pro_id", nullable = true)
//	private Product pro_id;
//	
//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = true)
//	private Account user_id;
}
