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
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.RoleDAO;

@MappedSuperclass
public abstract class RoleAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "role_privileges",
	      joinColumns = @JoinColumn(name = "role"),
	      inverseJoinColumns = @JoinColumn(name = "privileges"))
	private Collection<Privilege> privileges;
	
	public static RoleDAO DAO = new RoleDAO();

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

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, privileges);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleAbstract other = (RoleAbstract) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(privileges, other.privileges);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleAbstract [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		/*builder.append(", privileges=");
		builder.append(privileges);*/
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
