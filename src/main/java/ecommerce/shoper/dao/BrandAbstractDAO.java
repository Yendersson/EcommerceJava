package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Brand;

public class BrandAbstractDAO extends ControllerDAO implements DAO<Brand, Long>{

	@Override
	public Brand findById(Long id) {
		em = getEntityManager();
		return em.find(Brand.class, id);
	}

	@Override
	public Brand findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Brand.class, voobj);
	}

	@Override
	public List<Brand> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Brand b").getResultList();
	}

	@Override
	public void save(Brand entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(Brand entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
