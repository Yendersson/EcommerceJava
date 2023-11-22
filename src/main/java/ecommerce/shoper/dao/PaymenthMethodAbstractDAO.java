package ecommerce.shoper.dao;

import java.util.List;

import ecommerce.shoper.entities.PaymentMethod;

public class PaymenthMethodAbstractDAO  extends ControllerDAO implements DAO<PaymentMethod, Long>{
	
	@Override
	public PaymentMethod findById(Long id) {
		em = getEntityManager();
		return em.find(PaymentMethod.class, id);
	}

	@Override
	public PaymentMethod findById(String id) {
		em = getEntityManager();
		Long voobj = Long.parseLong(id) ;
		
		return em.find(PaymentMethod.class, voobj);
	}


	@Override
	public List<PaymentMethod> findAll() {
		em = getEntityManager();
		return  em.createQuery("SELECT b FROM PaymentMethod b").getResultList();
	}

	@Override
	public void save(PaymentMethod entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.merge(entity);
		
		tx.commit();	
	}

	@Override
	public void delete(PaymentMethod entity) {
		em = getEntityManager();
		tx = getTransaction();
		
		if (!tx.isActive()) {
			tx.begin();
		}
		em.remove(entity);
		
		tx.commit();	
	}
}
