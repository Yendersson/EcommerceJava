package ecommerce.shoper.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class ControllerDAO {
	protected static EntityManager em;
	protected static EntityTransaction tx;
    private static EntityManagerFactory emf;
    private static final String PU = "PU";
    
    public ControllerDAO(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
    
    protected EntityTransaction getTransaction(){
        if(tx == null){
            tx =  em.getTransaction();
        }
        return tx;
    }
}
