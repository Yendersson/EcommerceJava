package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.PurchaseDAO;

@MappedSuperclass
public abstract class PurchaseAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cod;
	
	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "id")
	private User user;
	
	private Date date;
	
	@ManyToMany
	@JoinTable(name = "purchase_products",
	      joinColumns = @JoinColumn(name = "purchase"),
	      inverseJoinColumns = @JoinColumn(name = "products"))
	private Collection<Product> products;
	
	private Double amount;
	
	private Double amountIva;
	
	private Double amountTotal;
	
	private String purchaseId;
	
	private String status;
	
	public static PurchaseDAO DAO = new PurchaseDAO();
	
	

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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Collection<Product> getProducts() {
		return products;
	}



	public void setProducts(Collection<Product> products) {
		this.products = products;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public Double getAmountIva() {
		return amountIva;
	}



	public void setAmountIva(Double amountIva) {
		this.amountIva = amountIva;
	}



	public Double getAmountTotal() {
		return amountTotal;
	}



	public void setAmountTotal(Double amountTotal) {
		this.amountTotal = amountTotal;
	}



	public String getPurchaseId() {
		return purchaseId;
	}



	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		return Objects.hash(amount, amountIva, amountTotal, cod, date, id, products, purchaseId, status, user);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseAbstract other = (PurchaseAbstract) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(amountIva, other.amountIva)
				&& Objects.equals(amountTotal, other.amountTotal) && Objects.equals(cod, other.cod)
				&& Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(products, other.products) && Objects.equals(purchaseId, other.purchaseId)
				&& Objects.equals(status, other.status) && Objects.equals(user, other.user);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PurchaseAbstract [id=");
		builder.append(id);
		builder.append(", cod=");
		builder.append(cod);
		builder.append(", user=");
		builder.append(user);
		builder.append(", date=");
		builder.append(date);
		builder.append(", products=");
		builder.append(products);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", amountIva=");
		builder.append(amountIva);
		builder.append(", amountTotal=");
		builder.append(amountTotal);
		builder.append(", purchaseId=");
		builder.append(purchaseId);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}






