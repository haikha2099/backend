package store.hn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Categories")
@Data
public class Category {
	@Column(name = "cg_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cg_id;
	
	@Column(name = "cg_name", length = 50)
	private String cg_name;
	
	@OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
	private List<Product> products;
}
