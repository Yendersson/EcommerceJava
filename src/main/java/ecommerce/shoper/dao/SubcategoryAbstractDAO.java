package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Product;
import ecommerce.shoper.entities.Subcategory;

public abstract class SubcategoryAbstractDAO extends ControllerDAO implements DAO<Subcategory, Long>{
	
	@Override
	public Subcategory findById(Long id) {
		em = getEntityManager();
		return em.find(Subcategory.class, id);
	}

	@Override
	public Subcategory findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Subcategory.class, voobj);
	}

	@Override
	public List<Subcategory> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Subcategory b").getResultList();
	}


	@Override
	public void save(Subcategory entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}


	@Override
	public void delete(Subcategory entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
