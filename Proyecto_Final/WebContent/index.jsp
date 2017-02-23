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
			Somos una web en la que facilitamos la venta y compra de productos ya sean de segunda mano o nuevos, sin intermediarios 
			, el precio lo fija el vendedor y el comprador puede negociar para llegar a un acuerdo<br>
			Está permitido vender todo tipo de productos, excepto seres humanos, drogas y armas. Ante malos comportamientos o cuentas sospechosas nuestro 
			todopoderoso ADMINISTRADOR actuará con mano firme.<br>
			OS DESEAMOS UNA BUENA COMPRA/VENTA.<br>
			Pinchando en el siguiente enlace puedes acceder a los productos que están en este momento a la venta--><a href="">Productos en venta</a>
			</p>

		</div>
		<div class="imagenes">
			<table>
				<tr>
					<td class="tdimg" ROWSPAN="2">ESTOS SON ALGUNOS DE LOS PRODUCTOS QUE PODRÁS ENCONTRAR EN VENTA. TODOS LOS QUE SE VEN EN LAS IMÁGENES SON 
					FOTOS REALES DE PRODUCTOS VENDIDOS Y COMPRADOS EN ESTA WEB.<br>
					SI QUIERES PODER ACCEDER A LA WEB NO SE TE OLVIDE REGISTRARTE, EN UNOS SENCILLOS PASOS Y MUY RÁPIDOS ESTARÁS LISTO PARA COMPRAR O VENDER LO QUE QUIERAS.<br>
					NO NOS HACEMOS RESPONSABLES DE LAS IMAGENES NI LA DESCRIPCIÓN DE CADA PRODUCTO.
					</td>
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