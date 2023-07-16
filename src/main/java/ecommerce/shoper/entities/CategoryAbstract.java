package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.CategoryDAO;

@MappedSuperclass
public abstract class CategoryAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;

	@JoinColumn(name = "subactegory", referencedColumnName = "id")
	@ManyToOne
	private Subcategory subcategory;

	public static CategoryDAO DAO = new CategoryDAO();
	

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



	public Subcategory getSubcategory() {
		return subcategory;
	}



	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, subcategory, title);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryAbstract other = (CategoryAbstract) obj;
		return Objects.equals(id, other.id) && Objects.equals(subcategory, other.subcategory)
				&& Objects.equals(title, other.title);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryAbstract [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", subcategory=");
		builder.append(subcategory);
		builder.append("]");
		return builder.toString();
	}
	
	
}
