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
<title>Registrarse</title>
</head>
<body style="background-color: #F1F1F1">
	<header class="navbar navbar-default navbar-fixed-top">
	<div class="navegacion">
		<h1><a href="/Proyecto_Final/home" class="company">${attCompanyName}</a></h1>
		<nav id="navPrincipal"> 
			<a class="amenu" href="login?accion=login">Inicio de Sesion</a>
		</nav>
	</div>
	<div class="form-busqueda">
		<form class="busqueda" action="../busqueda" method="get">
			<input type="text" class="busqueda" name="buscar"
				placeholder="�Qu� est�s buscando?" maxlength="150" />
			<button type="submit" id="buscar">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	</header>
	<div class="mainLogin">
	<div id="registro">
		<h2>Registrarse</h2>
		<form action="/Proyecto_Final/registro" method="POST">
			<fieldset>
				<div class="izq">
				<p>
					<label for="nombre">Nombre</label>
				</p>
				<p>
					<input type="text" name="nombre" id="nombre" placeholder="Nombre" required>
				</p>
				</div>
				<div class="dcha">
				<p>
					<label for="apellido">Apellido</label>
				</p>
				<p>
					<input  type="text" name="apellido" id="apellido" placeholder="Apellido" required>
				</p>
				</div>
				<div class="izq">
				<p>
					<label for="password">Contrase�a</label>
				</p>
				<p>
					<input name="password" type="password" id="password" placeholder="Contrase�a" required>
				</p>
				</div>
				<div class="dcha">
				<p>
					<label for="email">E-mail</label>
				</p>
				<p>
					<input name="email" type="email" id="email" placeholder="E-mail" required>
				</p>
				</div>
				<div class="centro">
				<p class="button">
					<input type="submit" value="Registrarse">
				</p>
				</div>
			</fieldset>
		</form>
	</div>
	</form>
</div>
</body>
</html>