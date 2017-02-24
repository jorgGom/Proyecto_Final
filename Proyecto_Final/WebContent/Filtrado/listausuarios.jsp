<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Listado de usuarios</title>
</head>
<body>
<!-- <header class="navbar navbar-default navbar-fixed-top"> -->
<!-- 	<div class="navegacion"> -->
<%-- 		<h1>${CompanyName}WallaTroll</h1> --%>
<!-- 		<nav id="navPrincipal"> -->
<!-- 			<a class="amenu" href="Contenido/login.jsp">Inicio de Sesion</a> -->
<!-- 			<a class="amenu" href="Contenido/registro.jsp">Registrarse</a>  -->
<!-- 		</nav> -->
<!-- 	</div> -->
<!-- 	<div class="form-busqueda"> -->
<!-- 		<form class="busqueda" action="/" method="post"> -->
<!-- 			<input type="text" class="busqueda" -->
<!-- 				placeholder="�Qu� est�s buscando?" maxlength="150" /> -->
<!-- 			<button type="button" id="buscar"> -->
<!-- 				<span class="glyphicon glyphicon-search" aria-hidden="true"></span> -->
<!-- 			</button> -->
<!-- 		</form> -->
<!-- 	</div> -->
<!-- 	</header> -->
	<table class="tableUsu">
		<tr><th>ID</th><th>Nombre</th><th>Apellido</th><th>Email</th><th>Modificar</th><th>Eliminar</th></tr>
			<c:forEach var="i" begin="1" end="5">
				<tr><td><c:out value="${i}"></c:out></td><td>jorge</td><td>gomez</td><td>jorge@gmail.com</td><td><button>Modificar</button></td><td><button>Eliminar</button></td></tr>	
			</c:forEach>

	</table>
	
</body>
</html>