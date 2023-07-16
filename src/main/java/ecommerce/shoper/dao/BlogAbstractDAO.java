package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Blog;
import ecommerce.shoper.entities.Blog;

public abstract class BlogAbstractDAO extends ControllerDAO implements DAO<Blog, Long>{
	
	@Override
	public Blog findById(Long id) {
		em = getEntityManager();
		return em.find(Blog.class, id);
	}

	@Override
	public Blog findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Blog.class, voobj);
	}

	@Override
	public List<Blog> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Blog b").getResultList();
	}

	@Override
	public void save(Blog entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(Blog entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
	
	
}
