package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Product;

public abstract class ProductAbstractDAO extends ControllerDAO implements DAO<Product, Long>{

	@Override
	public Product findById(Long id) {
		em = getEntityManager();
		return em.find(Product.class, id);
	}

	@Override
	public Product findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Product.class, voobj);
	}

	@Override
	public List<Product> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Product b").getResultList();
	}

	@Override
	public void save(Product entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(Product entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
	
}
