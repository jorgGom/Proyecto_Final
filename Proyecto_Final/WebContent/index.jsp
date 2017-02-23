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
<link href="https://fonts.googleapis.com/css?family=Dosis|Pacifico"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<title>WallaTroll</title>
</head>
<body>
	<header class="navbar navbar-default navbar-fixed-top">
	<div class="navegacion">
		<h1>${CompanyName}WallaTroll</h1>
		<nav id="navPrincipal">
			<a class="amenu" href="Contenido/login.jsp">Inicio de Sesion</a>
			<a class="amenu" href="Contenido/registro.jsp">Registrarse</a> 
		</nav>
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
	<main>
	<div class="contenedor">
		<div class="descripcion">
			<h2>Qué hacemos</h2>
			<p>
				Lorem Ipsum es simplemente el texto de relleno de las imprentas y
				archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar
				de las industrias desde el año 1500, cuando un impresor (N. del T.
				persona que se dedica a la imprenta) desconocido usó una galería de
				textos y los mezcló de tal manera que logró hacer un libro de textos
				especimen. No sólo sobrevivió 500 años, sino que tambien ingresó
				como texto de relleno en documentos electrónicos, quedando
				esencialmente igual al original. Fue popularizado en los 60s con la
				creación de las hojas "Letraset", las cuales contenian pasajes de
				Lorem Ipsum, y más recientemente con software de autoedición, como
				por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem
				Ipsum.<a href="">Productos en venta</a>
			</p>
			<p>
				Lorem Ipsum es simplemente el texto de relleno de las imprentas y
				archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar
				de las industrias desde el año 1500, cuando un impresor (N. del T.
				persona que se dedica a la imprenta) desconocido usó una galería de
				textos y los mezcló de tal manera que logró hacer un libro de textos
				especimen. No sólo sobrevivió 500 años, sino que tambien ingresó
				como texto de relleno en documentos electrónicos, quedando
				esencialmente igual al original. Fue popularizado en los 60s con la
				creación de las hojas "Letraset", las cuales contenian pasajes de
				Lorem Ipsum, y más recientemente con software de autoedición, como
				por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem
				Ipsum.<a href="">Productos en venta</a>
			</p>
			<p>
				Lorem Ipsum es simplemente el texto de relleno de las imprentas y
				archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar
				de las industrias desde el año 1500, cuando un impresor (N. del T.
				persona que se dedica a la imprenta) desconocido usó una galería de
				textos y los mezcló de tal manera que logró hacer un libro de textos
				especimen. No sólo sobrevivió 500 años, sino que tambien ingresó
				como texto de relleno en documentos electrónicos, quedando
				esencialmente igual al original. Fue popularizado en los 60s con la
				creación de las hojas "Letraset", las cuales contenian pasajes de
				Lorem Ipsum, y más recientemente con software de autoedición, como
				por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem
				Ipsum.<a href="">Productos en venta</a>
			</p>

		</div>
		<div class="imagenes">
			<table>
				<tr>
					<td class="tdimg" ROWSPAN="2">Lorem Ipsum es simplemente el
						texto de relleno de las imprentas y archivos de texto. Lorem Ipsum
						ha sido el texto de relleno estándar de las industrias desde el
						año 1500, cuando un impresor (N. del T. persona que se dedica a la
						imprenta)</td>
					<td><img class="imgportada" src="resources\img\LG.jpg" /></td>
					<td><img class="imgportada" src="resources\img\calcetines.jpg" /></td>
					<td><img class="imgportada" src="resources\img\smartphone.jpg" /></td>
				</tr>
				<tr>
					<td><img class="imgportada" src="resources\img\ford.jpg" /></td>
					<td><img class="imgportada" src="resources\img\consolas.jpg" /></td>
					<td><img class="imgportada" src="resources\img\trump.jpg" /></td>
				</tr>
			</table>
	</main>
</body>
</html>