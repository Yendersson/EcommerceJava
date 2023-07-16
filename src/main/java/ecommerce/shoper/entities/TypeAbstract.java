package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.TypeDAO;

@MappedSuperclass
public abstract class TypeAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	public static TypeDAO DAO = new TypeDAO();
	
	

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



	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeAbstract other = (TypeAbstract) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TypeAbstract [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
