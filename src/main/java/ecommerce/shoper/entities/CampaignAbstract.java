package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.CampaignDAO;

@MappedSuperclass
public abstract class CampaignAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Date dateTo;
	
	private Date dateFrom;
	
	private String picture;
	
	public static CampaignDAO DAO = new CampaignDAO();
	
	@ManyToMany(mappedBy = "campaigns")
	private Collection<Product> products;

	
	
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



	public Date getDateTo() {
		return dateTo;
	}



	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}



	public Date getDateFrom() {
		return dateFrom;
	}



	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public Collection<Product> getProducts() {
		return products;
	}



	public void setProducts(Collection<Product> products) {
		this.products = products;
	}



	@Override
	public int hashCode() {
		return Objects.hash(dateFrom, dateTo, id, name, picture, products);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampaignAbstract other = (CampaignAbstract) obj;
		return Objects.equals(dateFrom, other.dateFrom) && Objects.equals(dateTo, other.dateTo)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(picture, other.picture) && Objects.equals(products, other.products);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CampaignAbstract [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", dateTo=");
		builder.append(dateTo);
		builder.append(", dateFrom=");
		builder.append(dateFrom);
		builder.append(", picture=");
		builder.append(picture);
		/*builder.append(", products=");
		builder.append(products);*/
		builder.append("]");
		return builder.toString();
	}
	
	
}
