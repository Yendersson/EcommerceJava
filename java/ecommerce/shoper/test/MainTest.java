package ecommerce.shoper.test;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import ecommerce.shoper.dao.PrivilegeDAO;
import ecommerce.shoper.dao.ProductDAO;
import ecommerce.shoper.dao.PurchaseDAO;
import ecommerce.shoper.dao.RoleDAO;
import ecommerce.shoper.dao.UserDAO;
import ecommerce.shoper.entities.Brand;
import ecommerce.shoper.entities.BrandAbstract;
import ecommerce.shoper.entities.Campaign;
import ecommerce.shoper.entities.PaymentMethod;
import ecommerce.shoper.entities.PaymentMethodAbstract;
import ecommerce.shoper.entities.Privilege;
import ecommerce.shoper.entities.Product;
import ecommerce.shoper.entities.Purchase;
import ecommerce.shoper.entities.Role;
import ecommerce.shoper.entities.Supplier;
import ecommerce.shoper.entities.SupplierAbstract;
import ecommerce.shoper.entities.User;

public class MainTest {
	public static void main(String[] args) {
		ProductDAO prDAO = new ProductDAO();
		UserDAO userDao = new UserDAO();
		RoleDAO roleDAO = new RoleDAO();
		PrivilegeDAO privDAO = new PrivilegeDAO();
		PurchaseDAO purchDAO = new PurchaseDAO();
		Purchase purchase = new Purchase();
		Brand brand = BrandAbstract.DAO.findById(1L);
		Supplier sp = SupplierAbstract.DAO.findById(1L);
		PaymentMethod pm = PaymentMethodAbstract.DAO.findById(1L);
		Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formato.format(fechaActual);
        System.out.println(fechaFormateada);
        
        Random random = new Random();
        int numeroAleatorio = random.nextInt(99001) + 1000;
        double converToDouble = numeroAleatorio;
	        
        /*for (int j = 0; j < 100; j++) {
        	Product product = new Product();
        	product.setDate(fechaFormateada);
        	product.setIva_price(15.0);
        	product.setUnit_price(converToDouble);
        	product.setCurrent_price(((product.getIva_price()/10) + 1) * product.getUnit_price());
        	
        	Product.DAO.save(product);
        }*/
        
        Product product = new Product();
        product.setTitle("Producto 1");
        product.setDescription("La notebook HP 14-fq0033dx es una solución tanto para trabajar y estudiar como para entretenerte. Al ser portátil, el escritorio dejará de ser tu único espacio de uso para abrirte las puertas a otros ambientes ya sea en tu casa o en la oficina.");
    	product.setDate(fechaFormateada);
    	product.setIva_price(15.0);
    	product.setUnit_price(converToDouble);
    	product.setCurrent_price(((product.getIva_price()/100) + 1.) * product.getUnit_price());
    	
    	System.out.println("test: " + converToDouble);
    	System.out.println("test: " + ((15.0/100.0) + 1)*converToDouble);
    	System.out.println("test: " + ((15.0/100.0) + 1));
    	System.out.println(product.getUnit_price());
    	System.out.println(product.getCurrent_price());
	        
	        //product.setDate();
		
		//System.out.println(brand.getTitle());
		//System.out.println(sp.getName());
		//System.out.println(pm.getName());
		/*purchase.setUser(userDao.findById(1L));
		purchase.setProducts(prDAO.findAll());
		purchase.setAmountTotal(setPrices(purchase.getProducts()));
		
		System.out.println(purchase.getAmountTotal());*/
		
		//System.out.println(purchDAO.findById(1L));
		
		Role role = new Role();
		
		//System.out.println(User.DAO.findById(1L));
		
		
		//role.setName("TEST");
		//role.setPrivileges(privDAO.findAll());
		//roleDAO.save(role);
		
		
		
		
		
		
		
		//User user = new User();
		
		/*user.setUsername("usuarioTest");
		user.setEmail("usuario@mail.com");
		user.setPassword("123456");
		user.setDate(null);
		user.setRole(role);*/
		
		//userDao.save(user);
		
	//imprimir(Product.DAO.findAll());
		//imprimir1(userDao.findAll());
		
		//imprimirR(roleDAO.findAll());
		
		//imprimirP(privDAO.findAll());
	}
	
	public static Double setPrices(Collection<Product> products) {
		double total = 0;
		for (Product pr : products) {
			total += pr.getUnit_price();
		}
		
		return total;
	}
	
	public static void imprimir(Collection<Product> products) {
		
		for (Product pr : products) {
			System.out.println(pr);
			System.out.println(pr.getTitle());
			System.out.println(pr.getSubcategory().getTitle());
			
			for (Campaign cp : pr.getCampaigns()) {
				System.out.println(cp);
				
			}
		}
	}
	
public static void imprimirP(Collection<Privilege> privileges) {
		
		for (Privilege pr : privileges) {
			System.out.println(pr);			
		}
	}
	
public static void imprimirR(Collection<Role> roles) {
		
		for (Role pr : roles) {
			System.out.println(pr);			
		}
	}
	
	public static void imprimir1(Collection<User> users) {
		
		for (User pr : users) {
			System.out.println(pr);
			System.out.println(pr.getRole().getPrivileges());
			
		}
	}
	
}
