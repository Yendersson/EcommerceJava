package ecommerce.shoper.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import ecommerce.shoper.dao.PrivilegeDAO;

@MappedSuperclass
public abstract class PrivilegeAbstract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;
	
	public static PrivilegeDAO DAO = new PrivilegeDAO();

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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrivilegeAbstract other = (PrivilegeAbstract) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(roles, other.roles);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrivilegeAbstract [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		/*builder.append(", roles=");
		builder.append(roles);*/
		builder.append("]");
		return builder.toString();
	}

	
}
