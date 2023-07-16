<%@page import="ecommerce.shoper.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% String cat = request.getParameter("cat"); %>
   <% String sub = request.getParameter("sub"); %>
<!DOCTYPE html>
<html>
	<jsp:include page="head/head.jsp"></jsp:include>
<body>

	<jsp:include page="header/header.jsp"></jsp:include>

	<jsp:include page="content/listingProducts.jsp">
		<jsp:param value="<%=cat%>" name="cat"/>
		<jsp:param value="<%=sub%>" name="sub"/>
	</jsp:include>
	
	<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>