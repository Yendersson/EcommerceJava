 
 <%--if (request.getSession().getAttribute("user") != null) { --%>
   <section class="modal">
        <div class="modal-container modal-show">
          <img src="/images/img/protofinal (4).png" alt="">
          <% if (request.getSession().getAttribute("user") == null) { %>
          <form action="" id="form">
            <div class="form-inicio">
              <label for="">Username:</label>
              <input type="text" name="username" id="username" placeholder="username">
              <label for="">Contraseņa:</label>
              <input type="password" name="password" id="password" placeholder="******">
  
              <button class="btn-login" id="btn-login">Iniciar Sesion</button>
              <span id="alerta" style="color: red; text-align:center"></span>
            </div>
          </form>
          <button class="btn-register" id="register">Registrate</button>
		<%-- 
          <form id="form-register">
            <div class="form-inicio">
              <label for="">Nombre:</label>
              <input type="text" name="name" id="name" placeholder="nombre de usuario">
              <label for="">Correo:</label>
              <input type="email" name="email" id="emailR" placeholder="Mail">
              <!-- <span id="alerta" style="color: red; text-align:center"></span> -->
              <label for="">Contraseņa:</label>
              <input type="password" name="password" id="passwordR" placeholder="******">
  
              <button class="btn-login" id="btn-register">Registarse</button>
              <!-- <span id="alerta" style="color: red; text-align:center"></span> -->
            </div>
          </form>
          <button class="btn-register" id="login">Ya tienes cuenta?</button>
          --%>
		<% } else { %>
           	<button class="btn-login" id="btn-perfil">Ver perfil</button>
            <button class="btn-register" id="cerrar-sesion"> <a href="<%=request.getContextPath() %>/logout">Cerrar sesion</a></button>
          
          <% } %>
         	<a href="#" id="close">Cerrar</a>
        </div>
      </section>
<%-- } else { --%>
<%--} --%>