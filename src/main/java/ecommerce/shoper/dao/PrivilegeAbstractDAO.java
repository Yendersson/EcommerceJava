package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Privilege;

public abstract class PrivilegeAbstractDAO extends ControllerDAO implements DAO<Privilege, Long>{
	
	@Override
	public Privilege findById(Long id) {
		em = getEntityManager();
		return em.find(Privilege.class, id);
	}


	@Override
	public Privilege findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Privilege.class, voobj);
	}


	@Override
	public List<Privilege> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Privilege b").getResultList();
	}


	@Override
	public void save(Privilege entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}


	@Override
	public void delete(Privilege entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
