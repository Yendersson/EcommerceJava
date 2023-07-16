package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.BlogDAO;

@MappedSuperclass
public abstract class BlogAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String subtitle;
	
	private String description;
	
	private Date datetime;
	
	private String picture;
	
	private String autor;
	
	private String picture_autor;
	
	public static BlogDAO DAO = new BlogDAO();

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

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPicture_autor() {
		return picture_autor;
	}

	public void setPicture_autor(String picture_autor) {
		this.picture_autor = picture_autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, datetime, description, id, picture, picture_autor, subtitle, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogAbstract other = (BlogAbstract) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(datetime, other.datetime)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(picture, other.picture) && Objects.equals(picture_autor, other.picture_autor)
				&& Objects.equals(subtitle, other.subtitle) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlogAbstract [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", subtitle=");
		builder.append(subtitle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", datetime=");
		builder.append(datetime);
		builder.append(", picture=");
		builder.append(picture);
		builder.append(", autor=");
		builder.append(autor);
		builder.append(", picture_autor=");
		builder.append(picture_autor);
		builder.append("]");
		return builder.toString();
	}
	
	
}
