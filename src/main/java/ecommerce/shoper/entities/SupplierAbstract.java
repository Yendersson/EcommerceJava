package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.SupplierDAO;

@MappedSuperclass
public abstract class SupplierAbstract implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cod;
	
	private String link;
	
	public static SupplierDAO DAO = new SupplierDAO();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return cod;
	}

	public void setCode(String code) {
		this.cod = code;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, id, link, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplierAbstract other = (SupplierAbstract) obj;
		return Objects.equals(cod, other.cod) && Objects.equals(id, other.id) && Objects.equals(link, other.link)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplierAbstract [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", code=");
		builder.append(cod);
		builder.append(", link=");
		builder.append(link);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
