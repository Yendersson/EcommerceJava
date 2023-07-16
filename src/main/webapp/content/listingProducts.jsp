  <%@page import="ecommerce.shoper.dao.ProductDAO"%>
<%@page import="ecommerce.shoper.entities.Subcategory"%>
<%@page import="ecommerce.shoper.entities.Category"%>
<%@page import="ecommerce.shoper.entities.Product"%>
<%@page import="java.util.Collection"%>

<% 
	String cate = request.getParameter("cat");
	String search = request.getParameter("q");
	String subc = request.getParameter("sub");
	
	Subcategory subcategory = null;
	if (subc != null && !subc.contains("null")){
		subcategory = Subcategory.DAO.findById(subc);
	}
		
	Category category = null;
	if (cate != null && !cate.contains("null")) {
		category = Category.DAO.findById(cate);
	}
%>



	<% Collection<Product> products = (cate !=null && !cate.contains("null"))? Product.DAO.productForCategory(category): (subc !=null && !subc.contains("null"))? Product.DAO.productForSubCategory(subcategory): Product.DAO.findAll(); %>
        <!----------------MAIN DESKTOP---------------------------  -->
	<h2 class="busqueda-title-results-search">Resultados: <%=products.size()%> </h2>

        <section class="busqueda-contenido-desktop">
          <div>
          <div class="busqueda-filter-order-desktop">
            <h3>Ordenar</h3>
            <hr>
            <p class="busqueda-filter"><a href="">A-Z</a></p>
            <p class="busqueda-filter"><a href="">Z-A</a></p>
            <p class="busqueda-filter"><a href="">#numeral</a></p>
            <p class="busqueda-filter"><a href="">123</a></p> 
            
            <h3>Filtrar</h3>
            <hr>
            <p class="busqueda-filter" ><a href="">Precio</a></p>
            <p class="busqueda-filter"><a href="">Nuevo</a></p>
            <p class="busqueda-filter"><a href="">Usado</a></p>
            <p class="busqueda-filter"><a href="">Talla</a></p>
          </div>
        </div>

          
          <div class="busqueda-productos-desktop">

             
             
             <% for (Product pr : products) {%>
            <article class="busqueda-articulo-desktop" data-id="<%=pr.getId()%>" onclick="window.location.href = 'productDetail.jsp?id=<%=pr.getId()%>'">
              <div class="contenedor-img-api" >
               <img src="<%=pr.getPicture()%>" alt="">
              </div>
               <div class="busqueda-producto-description-desktop">
                 <h3><%=pr.getTitle() %></h3>
                <p><%=pr.getCurrent_price()%>$</p>
                <span>Vendido por:</span>
               </div>
            </article>
            <% } %>
        </div>
        </section>