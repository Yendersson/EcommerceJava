<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String title = request.getParameter("title") != null? request.getParameter("title"): "New-Commerce";%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=title%></title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/productos.css">
    <link rel="stylesheet" href="./css/productos_detail.css">
    <link rel="stylesheet" href="./css/kart.css">
    <%---
    <link rel="stylesheet" href="/css/acercaNosotros.css">
    <link rel="stylesheet" href="/css/faq.css">
    <link rel="stylesheet" href="/css/carrito.css">
    <link rel="stylesheet" href="/css/perfil.css">
    --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
     <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</head>
