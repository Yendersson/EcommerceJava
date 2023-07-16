package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.User;

public abstract class UserAbstractDAO extends ControllerDAO implements DAO<User, Long>{
	
	@Override
	public User findById(Long id) {
		em = getEntityManager();
		return em.find(User.class, id);
	}

	@Override
	public User findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(User.class, voobj);
	}

	@Override
	public List<User> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM User b").getResultList();
	}

	@Override
	public void save(User entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(User entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
