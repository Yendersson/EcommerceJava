package ecommerce.shoper.dao;

import javax.persistence.Query;

import ecommerce.shoper.entities.User;

public class UserDAO extends UserAbstractDAO{
	
	public User authUser(User user) {
		
		User users = null;
		em = getEntityManager();
		try {
			 users = (User) em.createQuery("FROM User u WHERE u.username = :username AND u.password = :password").setParameter("username", user.getUsername()).setParameter("password", user.getPassword()).getSingleResult(); 
		} catch (Exception e) {
			e.printStackTrace();
			users = null;
		}
		
		return users;
		
	}
}
