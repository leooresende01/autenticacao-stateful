<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link href="/style/login/style.css" rel="stylesheet">
</head>
<body>
	<main>
		<div class="card form-login">
			<div class="card-header text-center">Cadastro</div>
			<div class="card-body">
				<form action="/cadastro" method="post">
					<div class="mb-3">
						<label for="username" class="form-label">Username</label>
						<div class="input-group has-validation">
							<span class="input-group-text" id="inputGroupPrepend3">@</span> <input
								type="text" name="username"
								class="form-control ${usernameClass }"
								id="username"
								aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback"
								required value="${usernameValue }">
							<div id="validationServerUsernameFeedback"
								class="invalid-feedback">${usernameErrosMessage}</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label>
						<input type="text" name="password" class="form-control ${passwordClass }"
							id="password" value="${passwordValue }" required>
						<div class="invalid-feedback">${passwordErrosMessage }</div>
					</div>
					<div class="mb-3">
						<label for="nomeCompleto" class="form-label">Nome Completo</label>
						<input type="text" name="nomeCompleto" class="form-control ${nomeCompletoClass }"
							id="nomeCompleto" value="${nomeCompletoValue }" required>
						<div class="invalid-feedback">${nomeCompletoErrosMessage }</div>
					</div>
					<c:if test="${usernameJaUtilizado }">
						<div class="mb-2 error-mensage text-danger">Esse username já está sendo utilizado</div>
					</c:if>
					<div class="mb-3">
						Já tem conta? <a href="/login">fazer login</a>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>