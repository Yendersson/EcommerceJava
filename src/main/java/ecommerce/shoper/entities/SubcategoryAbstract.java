package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import ecommerce.shoper.dao.SubcategoryDAO;

@MappedSuperclass
public class SubcategoryAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@JoinColumn(name = "category", referencedColumnName = "id")
	@ManyToOne
	private Category category;
	
	@JoinColumn(name = "type", referencedColumnName = "id")
	@ManyToOne
	private Type type;
	
	public static SubcategoryDAO DAO = new SubcategoryDAO();
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}
	
	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, title, type);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubcategoryAbstract other = (SubcategoryAbstract) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title) && Objects.equals(type, other.type);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubcategoryAbstract [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
	
}
