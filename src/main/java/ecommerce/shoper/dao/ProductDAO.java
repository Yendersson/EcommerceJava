package ecommerce.shoper.dao;

import java.util.Collection;

import javax.persistence.Query;

import ecommerce.shoper.entities.Category;
import ecommerce.shoper.entities.Product;
import ecommerce.shoper.entities.Subcategory;

public class ProductDAO extends ProductAbstractDAO{
	
	public Collection<Product> productForCategory(Category category){
		em = getEntityManager();
		return em.createQuery("FROM Product p WHERE p.category = :category").setParameter("category", category).getResultList();
	}
	
	public Collection<Product> productForSubCategory(Subcategory subcategory){
		em = getEntityManager();
		return em.createQuery("FROM Product p WHERE p.subcategory = :subcategory").setParameter("subcategory", subcategory).getResultList();
	}
}
