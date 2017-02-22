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
<title>Iniciar Sesi�n</title>
</head>
<body style="background-color: #F1F1F1">
	<header class="navbar navbar-default navbar-fixed-top">
	<div class="navegacion">
		<h1>${CompanyName}WallaTroll</h1>
		<nav id="navPrincipal">
			<a class="amenu" href="../index.jsp">Home</a> 
			<a class="amenu" href="Registro">Registrarse</a> 
		</nav>
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
	<div class="mainLogin">
	<div id="login">
		<h2>Iniciar Sesi�n</h2>
		<form action="/" method="POST">
			<fieldset>
				<p>
					<label for="email">E-mail</label>
				</p>
				<p>
					<input type="email" id="email" placeholder="e-mail">
				</p>
				<p>
					<label for="password">Contrase�a</label>
				</p>
				<p>
					<input type="password" id="password" placeholder="Contrase�a">
				</p>
				<p>
					<input type="submit" value="Iniciar Sesi�n">
				</p>
			</fieldset>
		</form>
	</div>
	</form>
</div>
</body>
</html>