<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="proyecto_final.clases.Usuario"%>

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
<title>Lista de usuarios</title>
</head>
<body>
	<header class="navbar navbar-default navbar-fixed-top">
	<div class="navegacion">
		<h1>
			<a href="index.jsp" class="company">${attCompanyName}</a>
		</h1>
		<nav id="navPrincipal"> <a class="amenu" href="InitSess"></a> <a
			class="amenu" href="login?accion=salir">Cerrar sesi�n</a> </nav>

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
	</header>


	<div class="container">
		<div class="item">
			<h2>Bienvenido ${userName }</h2>
			<div class="menu">
				<ul class="nav nav-pills nav-stacked">
					<li><a class="aperfil" href="inicio"><span
							class="glyphicon glyphicon-user"></span> Perfil</a></li>
					<c:if test="${usuario.nombre!='admin' }">
						<li><a class="aperfil" href="inicio?page=productosVenta"><span
								class="glyphicon glyphicon-shopping-cart"></span> Productos en
								venta</a></li>
						<li><a class="aperfil" href="inicio?page=productosComprados"><span
								class="glyphicon glyphicon-piggy-bank"></span> Productos
								comprados</a></li>
					</c:if>
					<c:if test="${ usuario.nombre eq 'admin' }">
						<li class="active"><a class="aperfil"
							href="inicio?page=listaUsuarios"><span
								class="glyphicon glyphicon-book"></span> Lista de usuarios</a></li>
					</c:if>
				</ul>
				<c:if test="${usuario.nombre!='admin' }">

					<p class="botones">
						<a class="comVen" href="RegistroProducto?page=compra"> Comprar
						</a>
					</p>
					<br>
					<p class="botones">
						<a class="comVend" href="RegistroProducto?page=venta"> Vender
						</a>
					</p>
				</c:if>
			</div>
		</div>
		<div class="item2">
			<table class="tableUsu">
				<tr class="trUser">
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Contrase�a</th>
					<c:if test="${usuario.nombre eq 'admin' }">
					<th>Modificar</th>
					<th>Eliminar</th>
					</c:if>
				</tr>
				<c:forEach var="i" items="${ listaUsuarios }">
					<tr>
						<td class="tdUser">${i.idusuario}</td>
						<td class="tdUser">${i.nombre}</td>
						<td class="tdUser">${i.apellido}</td>
						<td class="tdUser">${i.email}</td>
						<td class="tdUser">${i.password}</td>
						<c:if test="${usuario.nombre eq 'admin' }">
						<td class="tdUser"><a class="btn"
							href="Admin?accion=modificar&id=
						<c:out value="${i.idusuario}"></c:out>">Modificar</a></td> 
						<td class="tdUser"><a class="btn"
							href="Admin?accion=eliminar&id=
							<c:out value="${i.idusuario}"></c:out>">Eliminar</a></td>
							</c:if>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${formulario eq 'form' }">

			<form action="Admin" method="POST" class="formMod">
				<span class="cerr"><a href="Admin?accion=cerrarVentana" class="glyphicon glyphicon-remove"></a></span>
				<h2>Modificar el usuario</h2>
				<table class="tableUsu">
				<tr class="trUser">
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Contrase�a</th>
					<th>Modificar</th>
				</tr>
					<tr>
						<td class="tdUser">${idMod}</td>
						<td class="tdUser"><input type="text" placeholder="Nuevo nombre" name="nom"/></td>
						<td class="tdUser"><input type="text" placeholder="Nuevo apellido" name="ape"/></td>
						<td class="tdUser"><input type="text" placeholder="Nuevo email" name="mail"/></td>
						<td class="tdUser"><input type="text" placeholder="Nueva contrase�a" name="pass"/></td>
						<td class="tdUser"><input type="submit" value="modificar" name="modificar"></td>
					</tr>
			</table>
			
			</form>
			
			</c:if>

		</div>
	</div>
</body>
</html>