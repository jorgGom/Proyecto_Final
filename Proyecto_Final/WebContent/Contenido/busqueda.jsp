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
		<c:if test="${userName eq null }">
	<div class="navegacion">
		<h1><a href="home" class="company">${attCompanyName}</a></h1>
		<nav id="navPrincipal">
			<a class="amenu" href="login?accion=login">Inicio de Sesion</a>
			<a class="amenu" href="login?accion=registro">Registrarse</a> 
		</nav>
	</div>
	<div class="form-busqueda">
		<form class="busqueda" action="busqueda" method="get">
			<input type="text" class="busqueda" name="buscar"
				placeholder="�Qu� est�s buscando?" maxlength="150" />
			<button type="submit" id="buscar">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	</c:if>
	<c:if test="${userName != null }">
		<div class="navegacion">
		<h1><a href="home" class="company">${attCompanyName}</a></h1>
		<nav id="navPrincipal"> 
			<a class="amenu" href="InitSess"></a>
		 	<a class="amenu" href="login?accion=salir">Cerrar sesi�n</a>
		</nav>

	</div>
	<div class="form-busqueda">
		<form class="busqueda" action="busqueda" method="get">
			<input type="text" class="busqueda" name="buscar"
				placeholder="�Qu� est�s buscando?" maxlength="150" />
			<button type="submit" id="buscar">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	</c:if>
	</header>


	<div class="container">
	<div class="item">
		<h2>Bienvenido ${userName }</h2><div class="menu">
		<ul class="nav nav-pills nav-stacked">
			<c:if test="${usuario.nombre!=null}">
			<li><a class="aperfil" href="inicio"><span class="glyphicon glyphicon-user"></span> Perfil ${userName }</a></li>
		
			<c:if test="${usuario.nombre!='admin'  }">
			<li><a class="aperfil" href="inicio?page=productosVenta"><span class="glyphicon glyphicon-shopping-cart"></span> Productos en venta</a></li>
			<li><a class="aperfil" href="inicio?page=productosComprados"><span class="glyphicon glyphicon-piggy-bank"></span> Productos comprados</a></li>
			</c:if>
			</c:if>
			<c:if test="${ usuario.nombre eq 'admin' }">
				<li><a class="aperfil" href="inicio?page=listaUsuarios"><span class="glyphicon glyphicon-book"></span> Lista de usuarios</a></li>
			</c:if>
			<li class="active"><a class="aperfil" href="busqueda?buscar="><span class="glyphicon glyphicon-piggy-bank"></span> Lista de productos</a></li>
		</ul>

		<c:if test="${usuario.nombre!='admin' and usuario.nombre!=null}">
		
		<p class="botones"><a class="comVen" href="RegistroProducto?page=compra">
		Comprar
		</a></p>
		<br>
		<p class="botones"><a class="comVend" href="RegistroProducto?page=venta">
		Vender
		</a></p>
		</c:if>
		</div>
	</div>
	<div class="item2">
	<div class="tablas">
	<c:forEach var="i" items="${ lista }">
				<table class="tablePro">
					<tr class="trProducto">
						<th class="thProd" colspan="3">${i.nombre}</th>
					</tr>

					<tr>
						<td rowspan="2" class="tdProdImg"><img class="imgProd"
							alt="imgPrd" src="resources/img/prod.jpg"></td>
						<td colspan="2" class="tdProd"><span>Precio: </span>${i.precio} &#8364</td>
					<tr>
						<td colspan="2" class="tdProd"><span>Vendedor: </span>${i.vendedor}</td>
					</tr>
					<tr>
					<td colspan="2"><hr></td>
					</tr>
					<tr>
						<td colspan="2" class="tdDesc">${i.descripcion}</td>
					</tr>
					<c:if test="${i.vendido==0 }">
					<tr>
						<td colspan="3" class="tdButton">
							<a class="btnComp" href="RegistroProducto?page=comprar&idPro=
							<c:out value="${i.idproductos}"></c:out>">Comprar</a>
							</td>
					</tr>
					</c:if>
					<c:if test="${i.vendido==1 }">
					<tr class="trProducto">
						<td class="tdVendido" colspan="3">VENDIDO</td>
					</tr>
					</c:if>
				</table>
			</c:forEach>
	</div>

</div>
</body>
</html>