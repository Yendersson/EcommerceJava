<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ecommerce.shoper.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<% 
	Cookie[] cookies = request.getCookies();
	Cookie product = null;
	for (Cookie ck : cookies){
		if (ck.getName().equals("products")){
			product = ck;
		}
	}
	
	String[] products = {};
	if (product != null && product.getValue().contains("!")){
		products = product.getValue().split("!");
	}
	
	List<Product> p = new ArrayList<>();
	
	for (String id : products){
		p.add(Product.DAO.findById(id));
	}
	
	Double total = 0.0;
	
	DecimalFormat df = new DecimalFormat("######");
%>



<div class="headerCarrito">
      <h1 id="cart-title"> Bienvenido a tu carrito </h1>
      <h2>{{message}}</h2>
    </div>
    <div class="containerCarrito">
      <div class="cart-column">
          <img src="/images/icons/carrito.png" class="imgCarrito">
          <h3 id="productos">producto</h3>
          <h3 id="cantidades">cantidad</h3>
          <h3 id="precios">precio</h3>
          
              <!-- 
                  <button type="button"> <img src="/icons/basura.png" width="40" height="40">
                  </button>
               -->
          
      </div>


      <% if (p.size() > 0) { %>
      <% for (Product pr : p) {%>
      <div id="prueba-producto">
          <img src="/images/icons/compra.png" class="imgCarrito">
          <h3 id="producto1"><%=pr.getTitle()%></h3>
          <h3 id="cantidad1">1</h3>
          <h3 id="precio1">$<%=pr.getCurrent_price()%></h3>
      </div>
      <% total+=pr.getCurrent_price(); } %>
      <% } %>
      <!-- <div id="segunda-columna">
          <img src="icons/compra.png" class="imgCarrito">
          <h3 id="producto2">.....</h3>
          <h3 id="cantidad2">......</h3>
          <h3 id="precio2">........</h3>
      </div> -->
      <div id="final">
          <button class="boton1 btnCarrito">seguir comprando</button>
          <h2 id="precio-total">total: $<%=df.format(total)%></h2>
          <button class="boton2 btnCarrito" id="compra">continuar</button>
          <button type="button" > <img src="images/icons/basura.png" class="eliminar"  >
          </button>
      </div>
  </div>

  <div class="Pago-carrito-carrito">
    <div class="popop-carrito">
          <!-- <a id="cerrar-carrito" href="#popop">&times;</a> -->
      <h1>
        Metodo de pago
      </h1>
     <form action="<%=request.getContextPath()%>/payments" method="post">
     	<div class="payment">
	     	<label>MercadoPago</label>
	     	<input type="radio" name="method" value="1">     	
     	</div>
		<div class="payment">
	     	<label>Payway</label>
	     	<input type="radio" name="method" value="2">     	
     	</div>
		<div class="payment">
	     	<label>Efectivo</label>
	     	<input type="radio" name="method" value="3">     	
     	</div>
     	<input type="text" name="amount" value="<%=df.format(total)%>">
     	<button class="btn-comprar-carrito" id="comprado">
        <span>Finalizar Compra</span>
      </button>
     </form>
    <p class="Parrafo-Donacion-carrito">
    Con tu compra se donará un 10% a la ONG que selecciones
    <select name="" id="">
        <option value="">1</option>
    <option value="">2</option>
    </select>
    
    </p>
    
    <div>
      <a href="#" id="cerrar">cerrar</a>
    </div>
    
  </div>
</div>

<script src="/script/carrito.js"></script>