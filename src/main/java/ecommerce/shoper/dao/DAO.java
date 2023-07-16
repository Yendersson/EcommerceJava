package ecommerce.shoper.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, ID extends Serializable> {
	
	T findById(ID id);
	
	T findById(String id);
	
    List<T> findAll();
    
    void save(T entity);
    
    void delete(T entity);
}
