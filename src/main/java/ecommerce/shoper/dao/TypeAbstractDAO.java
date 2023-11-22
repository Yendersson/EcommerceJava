package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Type;

public abstract class TypeAbstractDAO extends ControllerDAO implements DAO<Type, Long>{
	 
	@Override
	public Type findById(Long id) {
		em = getEntityManager();
		return em.find(Type.class, id);
	}

	@Override
	public Type findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Type.class, voobj);
	}

	@Override
	public List<Type> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Type b").getResultList();
	}

	@Override
	public void save(Type entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}


	@Override
	public void delete(Type entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
