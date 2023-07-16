package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Purchase;

public abstract class PurchaseAbstractDAO extends ControllerDAO implements DAO<Purchase, Long>{
	@Override
	public Purchase findById(Long id) {
		em = getEntityManager();
		return em.find(Purchase.class, id);
	}

	@Override
	public Purchase findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Purchase.class, voobj);
	}

	@Override
	public List<Purchase> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Purchase b").getResultList();
	}

	@Override
	public void save(Purchase entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(Purchase entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
