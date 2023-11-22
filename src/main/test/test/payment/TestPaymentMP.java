package test.payment;

import java.io.IOException;

import ecommerce.shoper.payment.PaymentMP;

public class TestPaymentMP {
	public static void main(String[] args) throws IOException {
		
		String json = "{\"description\": \"DescripciÃ³n del producto\",\n"
				+ "					  \"issuer_id\":\"1\",\n"
				+ "					  \"installments\": 1,\n"
				+ "					  \"payer\": {\n"
				+ "					    \"email\":\"yendersoncolmenares67@gmail.com\",\n"
				+ "					    \"identification\": {\"type\":\"DNI\",\n"
				+ "					    \"number\":\"95790078\"}\n"
				+ "					  },\n"
				+ "					  \"payment_method_id\": \"debvisa\",\n"
				+ "					  \"token\": \"49d962ed74331e582cdc9adb86358955\",\n"
				+ "					  \"transaction_amount\": 246354.150\n"
				+ "					}";
			  
		String purchase = PaymentMP.postDataUrl("https://api.mercadopago.com/v1/payments", json);
		
		System.out.println(purchase);
		
		
		
	}
}
