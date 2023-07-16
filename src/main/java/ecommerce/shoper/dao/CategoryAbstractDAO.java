package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Category;

public abstract class CategoryAbstractDAO extends ControllerDAO implements DAO<Category, Long>{
	@Override
	public Category findById(Long id) {
		em = getEntityManager();
		return em.find(Category.class, id);
	}

	@Override
	public Category findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Category.class, voobj);
	}

	@Override
	public List<Category> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Category b").getResultList();
	}

	@Override
	public void save(Category entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(Category entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
