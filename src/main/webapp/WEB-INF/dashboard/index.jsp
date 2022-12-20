<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>Logado com sucesso</title>
</head>
<body>
	<h1 class="ms-3">Bem vindo, ${usuarioAutenticado.nomeCompleto }</h1>
	<div class="card ms-3" style="width: 25rem;">
		<div class="card-body">
			<h5 class="card-title text-center">${usuarioAutenticado.nomeCompleto }</h5>
			<h6 class="card-subtitle mb-2 text-muted text-center">${usuarioAutenticado.username }</h6>
			<a href="/loggout" class="card-link text-center">Fazer loggout</a>
		</div>
	</div>
</body>
</html>