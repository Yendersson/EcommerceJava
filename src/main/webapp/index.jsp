<%@page import="ecommerce.shoper.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% User user = User.DAO.findById(1L); %>
<!DOCTYPE html>
<html>
	<jsp:include page="head/head.jsp"></jsp:include>
<body>

	<jsp:include page="header/header.jsp"></jsp:include>
	
	<jsp:include page="content/index.jsp"></jsp:include>
	
	<jsp:include page="footer/footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="scripts/index.js"></script>
	<script type="text/javascript" src="scripts/functions.js"></script>
	
</body>
</html>