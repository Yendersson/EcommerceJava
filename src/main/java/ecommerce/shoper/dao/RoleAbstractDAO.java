package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Role;

public abstract class RoleAbstractDAO extends ControllerDAO implements DAO<Role, Long> {
	@Override
	public Role findById(Long id) {
		em = getEntityManager();
		return em.find(Role.class, id);
	}


	@Override
	public Role findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Role.class, voobj);
	}


	@Override
	public List<Role> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Role b").getResultList();
	}

	@Override
	public void save(Role entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}


	@Override
	public void delete(Role entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
