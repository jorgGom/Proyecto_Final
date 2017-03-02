<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:if test="${userName eq null }">
	<div class="navegacion">
		<h1>${attCompanyName}</h1>
		<nav id="navPrincipal">
			<a class="amenu" href="Contenido/login.jsp">Inicio de Sesion</a>
			<a class="amenu" href="Contenido/registro.jsp">Registrarse</a> 
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
	<c:if test="${userName eq 'jorge' }">
		<div class="navegacion">
		<h1><a href="index.jsp" class="company">${attCompanyName} de ${userName}</a></h1>
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
	</c:if>
	</header>
	<main>
	<div class="contenedor">
		<div class="descripcion">
			<h2>Qu� hacemos</h2>
			<p>
			Somos una web en la que facilitamos la venta y compra de productos ya sean de segunda mano o nuevos, sin intermediarios 
			, el precio lo fija el vendedor y el comprador puede negociar para llegar a un acuerdo<br>
			Est� permitido vender todo tipo de productos, excepto seres humanos, drogas y armas. Ante malos comportamientos o cuentas sospechosas nuestro 
			todopoderoso ADMINISTRADOR actuar� con mano firme.<br>
			OS DESEAMOS UNA BUENA COMPRA/VENTA.<br>
			Pinchando en el siguiente enlace puedes acceder a los productos que est�n en este momento a la venta--><a href="busqueda">Productos en venta</a>
			</p>

		</div>
		<div class="imagenes">
			<table>
				<tr>
					<td class="tdimg" ROWSPAN="2">ESTOS SON ALGUNOS DE LOS PRODUCTOS QUE PODR�S ENCONTRAR EN VENTA. TODOS LOS QUE SE VEN EN LAS IM�GENES SON 
					FOTOS REALES DE PRODUCTOS VENDIDOS Y COMPRADOS EN ESTA WEB.<br>
					SI QUIERES PODER ACCEDER A LA WEB NO SE TE OLVIDE REGISTRARTE, EN UNOS SENCILLOS PASOS Y MUY R�PIDOS ESTAR�S LISTO PARA COMPRAR O VENDER LO QUE QUIERAS.<br>
					NO NOS HACEMOS RESPONSABLES DE LAS IMAGENES NI LA DESCRIPCI�N DE CADA PRODUCTO.
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