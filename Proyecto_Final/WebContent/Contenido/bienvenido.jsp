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
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<title>Bienvenido</title>
</head>
<body>
	<header class="navbar navbar-default navbar-fixed-top">
	<div class="navegacion">
		<h1>${CompanyName}WallaTroll</h1>
<<<<<<< HEAD
		<nav id="navPrincipal"> 
			<a class="amenu" href="InitSess"></a>
		 	<a class="amenu" href="InitSess">Cerrar sesi�n</a>
		</nav>
=======
		<nav id="navPrincipal"> <a class="amenu" href="InitSess">${nombreUsuario }</a>
		<a class="amenu" href="InitSess"><p class="glyphicon glyphicon-off"></p></a> </nav>
>>>>>>> branch 'master' of https://github.com/jorgGom/Proyecto_Final.git
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
		<h2>Bienvenido ${nombreUsuario }</h2>
		<ul class="nav nav-pills nav-stacked">
			<li><a class="glyphicon glyphicon-user" href="#"> Perfil</a></li>
			<li><a href="#">Productos en venta</a></li>
			<li><a href="#">Productos comprados</a></li>
		</ul>

		<form>
			<button type="button" id="comprar">Comprar</button>
			<button type="button" id="vender">Vender</button>
		</form>
	</div>
	<div class="item2">
		<p>Lorem Ipsum es simplemente el texto de relleno de las imprentas
			y archivos de texto. Lorem Ipsum ha sido el texto de relleno est�ndar
			de las industrias desde el a�o 1500, cuando un impresor (N. del T.
			persona que se dedica a la imprenta) desconocido us� una galer�a de
			textos y los mezcl� de tal manera que logr� hacer un libro de textos
			especimen. No s�lo sobrevivi� 500 a�os, sino que tambien ingres� como
			texto de relleno en documentos electr�nicos, quedando esencialmente
			igual al original. Fue popularizado en los 60s con la creaci�n de las
			hojas "Letraset", las cuales contenian pasajes de Lorem Ipsum, y m�s
			recientemente con software de autoedici�n, como por ejemplo Aldus
			PageMaker, el cual incluye versiones de Lorem Ipsum</p>
	</div>

</div>
	<footer>
	<div class="pie">
		<p class="Copyright">@Copyright</p>
		<nav class="contactpie"> <a class="apie" href="">Contacto</a> </nav>
	</div>
	</footer>
</body>
</html>