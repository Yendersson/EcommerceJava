<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ecommerce-Payment-MP</title>
<style>
  #form-checkout { display: flex;flex-direction: column;max-width: 600px;}
  .container {height: 18px;display: inline-block;border: 1px solid rgb(118, 118, 118);border-radius: 2px;padding: 1px 2px;}
</style>
</head>
<body>
<%=request.getParameter("amount")%>
	<form id="form-checkout">
	  <div id="form-checkout__cardNumber" class="container"></div>
	  <div id="form-checkout__expirationDate" class="container"></div>
	  <div id="form-checkout__securityCode" class="container"></div>
	  <input type="text" id="form-checkout__cardholderName" />
	  <select id="form-checkout__issuer"></select>
	  <select id="form-checkout__installments"></select>
	  <select id="form-checkout__identificationType"></select>
	  <input type="text" id="form-checkout__identificationNumber" />
	  <input type="email" id="form-checkout__cardholderEmail" />
	  <input type="text" id="amount" name="amount" hidden="hidden" value="<%=request.getParameter("amount")%>" />
	
	  <button type="submit" id="form-checkout__submit">Pagar</button>
	  <progress value="0" class="progress-bar">Cargando...</progress>
	</form>



	<script type="text/javascript" src="https://sdk.mercadopago.com/js/v2"></script>
	<script type="text/javascript" src="/EcommerceShoper/scripts/mp/mp_api.js"></script>
</body>
</html>