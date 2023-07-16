<%@page import="ecommerce.shoper.entities.Product"%>
<% 
	Product p = Product.DAO.findById(request.getParameter("id"));
%>

<section id="mainProducto">
    <div class="containerMainProducto">
      
      <div class="containerProducto">
        <div class="divImagesProducto">
          <div class="divImgProducto">
            <img src="{{details.imgUrl.url1}}" alt="#" class="imgPrincipalProducto">
          </div>
          <div class="divGaleryProducto">
            <div class="imgMinProducto">
              <img src="{{details.imgUrl.url1}}" alt="#" class="imgSrc1">
            </div>
            <div class="imgMinProducto">
              <img src="{{details.imgUrl.url2}}" alt="#" class="imgSrc2">
            </div>
            <div class="imgMinProducto">
              <img src="{{details.imgUrl.url3}}" alt="#" class="imgSrc3">
            </div>
            <div class="imgMinProducto">
              <img src="{{details.imgUrl.url4}}" alt="#" class="imgSrc4">
            </div>
          </div>
        </div>
        <div class="containerCompraProducto">
          <div class="informacionCompraProducto">
            <div class="nombreProducto">
              <p><%=p.getTitle()%> </p>
            </div>
            <div class="valorProducto">
              <p>descipcion: <%=p.getDescription()%></p>
            </div>
            <div class="descriptionProducto">
              <p>precio: <%=p.getCurrent_price()%> $ </p>
            </div>
          </div>
          <div class="agregarEnCarritoProducto">
            <button class="agregaAlCarritoProducto" id="agregar">Agregar al carrito</button>
          </div>
        </div>
      </div>
      
    </div>
 </section>
