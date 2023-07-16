package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.Campaign;

public abstract class CampaignAbstractDAO extends ControllerDAO implements DAO<Campaign, Long>{
	
	@Override
	public Campaign findById(Long id) {
		em = getEntityManager();
		return em.find(Campaign.class, id);
	}

	@Override
	public Campaign findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(Campaign.class, voobj);
	}

	@Override
	public List<Campaign> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM Campaign b").getResultList();
	}

	@Override
	public void save(Campaign entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(Campaign entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
