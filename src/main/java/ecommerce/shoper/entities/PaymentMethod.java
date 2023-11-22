package ecommerce.shoper.entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paymentmethod")
public class PaymentMethod extends PaymentMethodAbstract{
	
	public static String access_token = getDataPropertie("ACCESS_TOKEN");
	
	public static void main(String[] args) {
		String getData = getDataPropertie("ACCESS_TOKEN");
		System.out.println(getData);
	}
	
	public static String getDataPropertie(String property) {
		Properties prop = new Properties();
		InputStream input = null;
		String sendData = null;
		
		try {
			input = new FileInputStream("data.properties");
			
			prop.load(input);
			System.out.println("Buscando property");
			sendData = prop.getProperty(property);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("EJECUCION DE FUNCION");
		System.out.println(sendData);
		return sendData;
	}
}
