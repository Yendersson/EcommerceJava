package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.BrandDAO;

@MappedSuperclass
public abstract class BrandAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String picture;

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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public static BrandDAO DAO = new BrandDAO(); 

	@Override
	public int hashCode() {
		return Objects.hash(id, picture, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BrandAbstract other = (BrandAbstract) obj;
		return Objects.equals(id, other.id) && Objects.equals(picture, other.picture)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BrandAbstract [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", picture=");
		builder.append(picture);
		builder.append("]");
		return builder.toString();
	}
	
	

}
