<%@page import="ecommerce.shoper.entities.Subcategory"%>
<%@page import="ecommerce.shoper.entities.Category"%>
<%@page import="ecommerce.shoper.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <header>

        <div class="header-top">
    		<div class="container">
      			<!-------------------- SOCIAL MEDIA -------------------->
      			<ul class="header-social-container">
        			<!-------------------- LOGO FACEBOOK -------------------->
        			<li>
			          <a href="https://www.facebook.com" target="_blank" class="social-link">
			            <ion-icon name="logo-facebook"></ion-icon>
			          </a>
			        </li>
			        <!-------------------- LOGO TWITTER -------------------->
			        <li>
			          <a href="https://twitter.com" target="_blank" class="social-link">
			            <ion-icon name="logo-twitter"></ion-icon>
			          </a>
			        </li>
			
			        <!-------------------- LOGO INSTAGRAM -------------------->
			              
			        <li>
			
			          <a href="https://www.instagram.com" target="_blank" class="social-link">
			            <ion-icon name="logo-instagram"></ion-icon>
			          </a>
			
			        </li>
			
			        <!-------------------- LOGO LINKEDIN -------------------->
			
			        <li>
			
			          <a href="https://www.linkedin.com" target="_blank" class="social-link">
			            <ion-icon name="logo-linkedin"></ion-icon>
			          </a>
			
			        </li>

      </ul>

    </div>

  </div>

  <!-------------------- HEADER-MAIN -------------------->
  <div class="header-main">
      <div class="container container-flex">

    <a href="/" class="header-logo select" data-id="home">
    <%--
          <img src="/images/img/protofinal (4).png" class="logo" alt="puma-logo" data-id="home">
    --%>
        </a> 

          <div class="header-search-container">

              <input type="search" name="search" class="search-field" id="search" placeholder="Buscar productos...">

              <button class="search-btn" id="search-btn">
                  <ion-icon name="search-outline"></ion-icon>
              </button>

          </div>

          <div class="header-user-actions">

              <button class="action-btn inicio">
                  <ion-icon name="person-outline"></ion-icon>
              </button>

              <button class="action-btn select carrito" data-id="Carrito">
                  <a href="#" style="color: black;"><ion-icon name="cart-outline"></ion-icon></a>
                  <span class="count">0</span>
              </button>

          </div>

      </div>
  </div>

  <!-------------------- DESKTOP MENU -------------------->
  <nav class="desktop-navigation-menu">
      <div class="container">

          <ul class="desktop-menu-category-list">

              <li class="menu-category">
                  <a href="<%=request.getContextPath()%>" class="menu-title select" data-id="home">Inicio</a>
              </li>

              <!-------------------- DASHBOARD/CATEGORIES -------------------->
              <li class="menu-category">
                  <a href="<%=request.getContextPath()%>" class="menu-title" >Categorias</a>
                  <div class="dropdown-panel">
      				<% for(Category ct : Category.DAO.findAll()){ %>
      					<ul class="dropdown-panel-list">
      						 <li class="menu-title">
                        		<a href="<%=request.getContextPath()%>/listing.jsp?cat=<%=ct.getId()%>" class="filtro" data-id="ropa-accesorios"><%=ct.getTitle()%></a>
                      		</li>
                      			<% for (Subcategory sct : Subcategory.DAO.findAll()) { %>
                      				<% if (!sct.getCategory().equals(ct)) continue;%>
                      				<li class="panel-list-item">
                        				<a href="<%=request.getContextPath()%>/listing.jsp?sub=<%=sct.getId() %>"><%=sct.getTitle()%></a>
                      				</li>
                      			<% } %>
      					</ul>
      				<% } %>
                  </div>
                </li>

                <!-------------------- MENU LISTED -------------------->
              <li class="menu-category">
                  <a href="#" class="menu-title select" data-id="ofertas">Ofertas</a>

                  <ul class="dropdown-list">

                      <li class="dropdown-item">
                          <a href="#">10% de descuento</a>
                      </li>

                      <li class="dropdown-item">
                          <a href="#">15% de descuento</a>
                      </li>

                      <li class="dropdown-item">
                          <a href="#">20% de descuento</a>
                      </li>

                      <li class="dropdown-item">
                          <a href="#">30% de descuento</a>
                      </li>

                  </ul>

              </li>

              <li class="menu-category">
                  <a href="<%=request.getContextPath()%>/listing.jsp" class="menu-title select" data-id="busqueda">Comprar</a>
              </li>

              <li class="menu-category">
                  <a href="<%=request.getContextPath()%>/vender.jsp" class="menu-title select" data-id="vender">Vender</a>
              </li>

              <li class="menu-category">
                  <a href="<%=request.getContextPath()%>/faq.jsp" class="menu-title select" data-id="faq">Ayuda</a>
              </li>

              <li class="menu-category">
                  <a href="<%=request.getContextPath()%>/aboutUs.jsp" class="menu-title select" data-id="acerca">Sobre nosotros</a>
              </li>

          </ul>
      </div>
  </nav>

  <!-------------------- MOBILE MENU -------------------->
  <div class="mobile-bottom-navigation">

      <!-------------------- BOTTOM NAVIGATION BAR -------------------->
      <button class="action-btn" data-mobile-menu-open-btn>
          <ion-icon name="menu-outline"></ion-icon>
      </button>

      <button class="action-btn carrito" data-id="Carrito">
          <ion-icon name="cart-outline" id="carrito"></ion-icon>
          <span class="count">0</span>
      </button>

      <button class="action-btn">
          <ion-icon name="home-outline"></ion-icon>
      </button>

      <button class="action-btn inicio">
          <ion-icon name="person-outline"></ion-icon>
      </button>

  </div>


  <!-------------------- DROP-DOWN MENU / HAMBURGER -------------------->
  <nav class="mobile-navigation-menu" data-mobile-menu>

      <div class="menu-top">

          <h2 class="menu-title">Menu</h2>

          <button class="menu-close-btn" data-mobile-menu-close-btn>
              <ion-icon name="close-outline"></ion-icon>
          </button>

      </div>

      <ul class="mobile-menu-category-list">

          <li class="menu-category">
              <a href="<%=request.getContextPath()%>" class="menu-title select" data-id="home">Inicio</a>
          </li>

          <!-------------------- MENU LISTED -------------------->
          <li class="menu-category">
              <button class="close-btn" data-mobile-menu-close-btn></button>

              <button class="accordion-menu" data-accordion-btn>

                  <p class="menu-title" >Categorías</p>

                  <div>
                      <ion-icon name="add-outline" class="add-icon"></ion-icon>
                      <ion-icon name="remove-outline" class="remove-icon"></ion-icon>
                  </div>

              </button>

              <ul class="submenu-category-list" data-accordion>

                  <li class="submenu-category">
                      <a href="/category/ropa_accesorios" class="submenu-title filtro" data-id="ropa-accesorios">Ropa y accesorios</a>
                  </li>

                  <li class="submenu-category">
                      <a href="/category/electrodomesticos" class="submenu-title filtro" data-id="electrodomestico-tecnologia" >Electrodomesticos y tecnologia</a>
                  </li>

                  <li class="submenu-category">
                      <a href="/category/hogar_muebles" class="submenu-title filtro" data-id="hogar-muebles-jardin">Hogar, muebles y jardin</a>
                  </li>

                  <li class="submenu-category">
                      <a href="/category/revista_arte" class="submenu-title filtro" arte-libros-revista>Arte, libros y revistas</a>
                  </li>

                  <li class="submenu-category">
                      <a href="#" class="submenu-title">Otros</a>
                  </li>

              </ul>

          </li>

          <li class="menu-category">

              <button class="accordion-menu" data-accordion-btn>

                  <p class="menu-title select" data-id="ofertas">Ofertas</p>

                  <div>
                      <ion-icon name="add-outline" class="add-icon"></ion-icon>
                      <ion-icon name="remove-outline" class="remove-icon"></ion-icon>
                  </div>

              </button>

              <ul class="submenu-category-list" data-accordion>

                  <li class="submenu-category">
                      <a href="#" class="submenu-title">10% de descuento</a>
                  </li>

                  <li class="submenu-category">
                      <a href="#" class="submenu-title">15% de descuento</a>
                  </li>

                  <li class="submenu-category">
                      <a href="#" class="submenu-title">20% de descuento</a>
                  </li>

                  <li class="submenu-category">
                      <a href="#" class="submenu-title">30% de descuento</a>
                  </li>

              </ul>

          </li>

          <li class="menu-category">
              <a href="<%=request.getContextPath()%>/listing.jsp" class="menu-title select" data-id="busqueda">Comprar</a>
          </li>

          <li class="menu-category">
              <a href="<%=request.getContextPath()%>/vender.jsp" class="menu-title select" data-id="vender">Vender</a>
          </li>

          <li class="menu-category">
              <a href="<%=request.getContextPath()%>/faq.jsp" class="menu-title select" data-id="faq">Ayuda</a>
          </li>

          <li class="menu-category">
              <a href="<%=request.getContextPath()%>/aboutUs.jsp" class="menu-title select" data-id="acerca">Sobre nosotros</a>
          </li>

      </ul>

      <!-------------------- SOCIAL MEDIA  -------------------->
      <div class="menu-bottom">

          <ul class="menu-social-container">
  
            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-facebook"></ion-icon>
              </a>
            </li>
  
            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-twitter"></ion-icon>
              </a>
            </li>
  
            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-instagram"></ion-icon>
              </a>
            </li>
  
            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-linkedin"></ion-icon>
              </a>
            </li>
  
          </ul>
  
        </div>

  </nav>
        
    </header>
    
    <%@ include file="../content/modal.jsp" %>