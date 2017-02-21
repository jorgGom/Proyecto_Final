<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<title>WallaTroll</title>
</head>
<body>
	<div class="navegacion">
		<h1>${company}WallaTroll</h1>
		<nav> <a class="amenu" href="InitSess">Inicio de Sesion</a> <a
			class="amenu" href="Registro">Registrarse</a> </nav>
	</div>
	<form class="busqueda" action="/" method="post">
		<input type="text" class="busqueda" placeholder="busqueda" />
		<button type="button" id="buscar">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		</button>
	</form>
	<div class="contenedor">
		<div class="descripcion">
			<h2>Qué hacemos</h2>
			<p>Aquí va la descripción</p>
		</div>
		<div class="imagenes">
			<table>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<h3>
			<a href="">Productos en venta</a>
		</h3>
	</div>
	<div class="pie">
		<a href="">Contacto</a>
	</div>
</body>
</html>