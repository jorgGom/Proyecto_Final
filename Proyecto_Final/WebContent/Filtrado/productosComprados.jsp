<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Bienvenido</title>
</head>
<body>
	<header class="navbar navbar-default navbar-fixed-top">
	<div class="navegacion">
		<h1><a href="index.jsp" class="company">${attCompanyName}</a></h1>
		<nav id="navPrincipal"> 
			<a class="amenu" href="InitSess"></a>
		 	<a class="amenu" href="login?accion=salir">Cerrar sesión</a>
		</nav>
		<nav id="navPrincipal"> <a class="amenu" href="InitSess">${nombreUsuario }</a>
		<a class="amenu" href="InitSess"><p class="glyphicon glyphicon-off"></p></a> </nav>

	</div>
	<div class="form-busqueda">
		<form class="busqueda" action="/" method="post">
			<input type="text" class="busqueda"
				placeholder="¿Qué estás buscando?" maxlength="150" />
			<button type="button" id="buscar">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	</header>


	<div class="container">
	<div class="item">
		<h2>Bienvenido ${userName }</h2>
		
		<div class="menu">
		<ul class="nav nav-pills nav-stacked">
			<li><a class="aperfil" href="inicio"><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
			<li><a class="aperfil" href="inicio?page=productosVenta"><span class="glyphicon glyphicon-shopping-cart"></span> Productos en venta</a></li>
			<li class="active"><a class="aperfil" href="inicio?page=productosComprados"><span class="glyphicon glyphicon-piggy-bank"></span> Productos comprados</a></li>
			<c:if test="${ usuario.nombre eq 'admin' }">
				<li><a class="aperfil" href="inicio?page=listaUsuarios"><span class="glyphicon glyphicon-book"></span> Lista de usuarios</a></li>
			</c:if>
		</ul>
		<c:if test="${usuario.nombre!='admin' }">
		<form method="get" action="/Proyecto_Final/RegistroProducto">
			<input type="button" id="comprar" value="Comprar">
		</form>
		<form method="POST" action="/Proyecto_Final/RegistroProducto?page=venta">
			<input type="submit" value="Vender" id="vender">
		</form>
		</c:if>
		</div>
	</div>
	<div class="item2">
		<p>Productos Comprados</p>
	</div>

</div>
</body>
</html>