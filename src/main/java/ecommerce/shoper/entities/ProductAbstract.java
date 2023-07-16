package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.ProductDAO;

@MappedSuperclass
public abstract class ProductAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cod;
	
	private String title;
	
	private String subtitle;
	
	private String textSummary;
	
	private String description;
	
	private Double iva_price;
	
	private Double unit_price;
	
	private String color;
	
	private String size;
	
	private String textatribute;
	
	private String info;
	
	private Double current_price;
	
	private String picture;
	
	private String date;
	
	@JoinColumn(name = "category", referencedColumnName = "id")
	@ManyToOne
	private Category category;
	
	@JoinColumn(name = "subcategory", referencedColumnName = "id")
	@ManyToOne
	private Subcategory subcategory;
	
	@JoinColumn(name = "type", referencedColumnName = "id")
	@ManyToOne
	private Type type;
	
	@ManyToMany
	@JoinTable(name = "product_campaign",
	      joinColumns = @JoinColumn(name = "product"),
	      inverseJoinColumns = @JoinColumn(name = "campaign"))
	private Collection<Campaign> campaigns;
	
	@ManyToMany(mappedBy = "products")
	private Collection<Purchase> purchases;
	
	public static ProductDAO DAO = new ProductDAO();
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCod() {
		return cod;
	}



	public void setCod(String cod) {
		this.cod = cod;
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



	public String getTextSummary() {
		return textSummary;
	}



	public void setTextSummary(String textSummary) {
		this.textSummary = textSummary;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getIva_price() {
		return iva_price;
	}



	public void setIva_price(Double iva_price) {
		this.iva_price = iva_price;
	}



	public Double getUnit_price() {
		return unit_price;
	}



	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public String getTextatribute() {
		return textatribute;
	}



	public void setTextatribute(String textatribute) {
		this.textatribute = textatribute;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public Double getCurrent_price() {
		return current_price;
	}



	public void setCurrent_price(Double current_price) {
		this.current_price = current_price;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Subcategory getSubcategory() {
		return subcategory;
	}



	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}



	public Collection<Campaign> getCampaigns() {
		return campaigns;
	}



	public void setCampaigns(Collection<Campaign> campaigns) {
		this.campaigns = campaigns;
	}



	@Override
	public int hashCode() {
		return Objects.hash(campaigns, category, cod, color, current_price, date, description, id, info, iva_price,
				picture, size, subcategory, subtitle, textSummary, textatribute, title, type, unit_price);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductAbstract other = (ProductAbstract) obj;
		return Objects.equals(campaigns, other.campaigns) && Objects.equals(category, other.category)
				&& Objects.equals(cod, other.cod) && Objects.equals(color, other.color)
				&& Objects.equals(current_price, other.current_price) && Objects.equals(date, other.date)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(info, other.info) && Objects.equals(iva_price, other.iva_price)
				&& Objects.equals(picture, other.picture) && Objects.equals(size, other.size)
				&& Objects.equals(subcategory, other.subcategory) && Objects.equals(subtitle, other.subtitle)
				&& Objects.equals(textSummary, other.textSummary) && Objects.equals(textatribute, other.textatribute)
				&& Objects.equals(title, other.title) && Objects.equals(type, other.type)
				&& Objects.equals(unit_price, other.unit_price);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductAbstract [id=");
		builder.append(id);
		builder.append(", cod=");
		builder.append(cod);
		builder.append(", title=");
		builder.append(title);
		builder.append(", subtitle=");
		builder.append(subtitle);
		builder.append(", textSummary=");
		builder.append(textSummary);
		builder.append(", description=");
		builder.append(description);
		builder.append(", iva_price=");
		builder.append(iva_price);
		builder.append(", unit_price=");
		builder.append(unit_price);
		builder.append(", color=");
		builder.append(color);
		builder.append(", size=");
		builder.append(size);
		builder.append(", textatribute=");
		builder.append(textatribute);
		builder.append(", info=");
		builder.append(info);
		builder.append(", current_price=");
		builder.append(current_price);
		builder.append(", picture=");
		builder.append(picture);
		builder.append(", date=");
		builder.append(date);
		builder.append(", category=");
		builder.append(category);
		builder.append(", subcategory=");
		builder.append(subcategory);
		builder.append(", type=");
		builder.append(type);
		builder.append(", campaigns=");
		builder.append(campaigns);
		builder.append("]");
		return builder.toString();
	}
	
	
}
