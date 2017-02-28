<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="java.util.List" %>
<%@ page import="proyecto_final.clases.Usuario" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Dosis|Pacifico"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<title>Lista de productos</title>
</head>
<body>
	<header class="navbar navbar-default navbar-fixed-top">
	<div class="navegacion">
		<h1><a href="index.jsp" class="company">${attCompanyName}</a></h1>
		<nav id="navPrincipal"> 
			<a class="amenu" href="InitSess"></a>
		 	<a class="amenu" href="login?accion=salir">Cerrar sesi�n</a>
		</nav>
		<nav id="navPrincipal"> <a class="amenu" href="InitSess">${nombreUsuario }</a>
		<a class="amenu" href="InitSess"><p class="glyphicon glyphicon-off"></p></a> </nav>

	</div>
	<div class="form-busqueda">
		<form class="busqueda" action="/" method="post">
			<input type="text" class="busqueda"
				placeholder="�Qu� est�s buscando?" maxlength="150" />
			<button type="button" id="buscar">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	</header>


	<div class="container">
	<div class="item">
		<h2>Bienvenido ${userName }</h2>
		<ul class="nav nav-pills nav-stacked">
			<li><a class="glyphicon glyphicon-user" href="inicio"> Perfil</a></li>
			<li><a href="inicio?page=productosVenta">Productos en venta</a></li>
			<li><a href="inicio?page=productosComprados">Productos comprados</a></li>
			<li class="active"><a href="inicio?page=listaUsuarios">Lista de usuarios</a></li>
		</ul>

		<form>
			<button type="button" id="comprar">Comprar</button>
			<button type="button" id="vender">Vender</button>
		</form>
	</div>
	<div class="item2">
	<table class="tableUsu">
    <tr><th>ID</th><th>Nombre</th><th>Descripci�n</th><th>Precio</th><th>Vendedor</th><th>Comprar</th></tr>
      <c:forEach var="i" items="${ listaProductos }">
        <tr>
        <td>${i.idproductos}</td>
        <td>${i.nombre}</td>
        <td>${i.descripcion}</td>
        <td>${i.vendedor}</td>
        <td><button>Comprar</button></td>
        </tr>  
      </c:forEach>
  </table>
	</div>

</div>
</body>
</html>