package ecommerce.shoper.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import ecommerce.shoper.dao.CategoryDAO;
import ecommerce.shoper.entities.Category;
import ecommerce.shoper.entities.Product;
import ecommerce.shoper.entities.Subcategory;

public class InsertData {
	public static void main(String[] args) {
		Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formato.format(fechaActual);
        Random rand = new Random();
        
        Category cat = Category.DAO.findById(3L);
        
        for(Product pr :Product.DAO.productForCategory(cat)) {
        	System.out.println(pr.getTitle());
        	System.out.println(pr.getCategory().getTitle());
        	System.out.println();
        	
        }
        
        
        long numNew = (long) (rand.nextInt(3) + 22);
        
        System.out.println(numNew);
        
        /*for (Product or : Product.DAO.findAll()) {
        	
        	long numNew = (long) (rand.nextInt(3) + 22);
        	
        	if(or.getCategory().getId() == 3L) {
        		
        	}
        	
        	
        }*/
        
//        System.out.println(rand.nextInt(4) + 3);
		/*int k = 0;
		for (int i = 0; i < 100; i++) {
			k++;
			Random random = new Random();
	        Random rand = new Random();
			
			long numNew = (long) (rand.nextInt(4) + 3);
			
	        int numeroAleatorio = random.nextInt(99001) + 1000;
	        double converToDouble = numeroAleatorio;
			
	        Product product = new Product();
	        product.setTitle("Producto " + k);
	        product.setDescription("La notebook HP 14-fq0033dx es una solución tanto para trabajar y estudiar como para entretenerte. Al ser portátil, el escritorio dejará de ser tu único espacio de uso para abrirte las puertas a otros ambientes ya sea en tu casa o en la oficina.");
	    	product.setDate(fechaFormateada);
	    	product.setIva_price(15.0);
	    	product.setUnit_price(converToDouble);
	    	product.setCurrent_price(((product.getIva_price()/100) + 1) * product.getUnit_price());
	    	product.setCategory(Category.DAO.findById(numNew));
			
	    	Product.DAO.save(product);
		}*/
        
        
        
        
	}
}
