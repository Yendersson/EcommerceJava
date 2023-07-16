package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Supplier;

public class SupplierAbstractDAO  extends ControllerDAO implements DAO<Supplier, Long>{
	
	@Override
	public Supplier findById(Long id) {
		em = getEntityManager();
		return em.find(Supplier.class, id);
	}

	@Override
	public Supplier findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Supplier.class, voobj);
	}

	@Override
	public List<Supplier> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Supplier b").getResultList();
	}

	@Override
	public void save(Supplier entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(Supplier entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
