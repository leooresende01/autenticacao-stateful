<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link href="/style/login/style.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Login</title>
</head>
<body>
	<main>
		<div class="card form-login">
			<div class="card-header text-center">Login</div>
			<div class="card-body">
				<form action="/login" method="post">
					<div class="mb-3">
						<label for="username" class="form-label">Username</label>
						<div class="input-group has-validation">
							<span class="input-group-text" id="inputGroupPrepend3">@</span> <input
								type="text" name="username"
								class="form-control ${usernameClass }" id="username"
								aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback"
								required value="${usernameValue }">
							<div id="validationServerUsernameFeedback"
								class="invalid-feedback">${usernameErrosMessage}</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="text" name="password"
							class="form-control ${passwordClass }" id="password"
							value="${passwordValue }" required>
						<div class="invalid-feedback">${passwordErrosMessage }</div>
					</div>
					<c:if test="${loginHasErrors}">
						<p class="mb-2 error-mensage text-danger">Usuario e/ou senha são invalidos</p>
					</c:if>
					<div class="mb-3">
						Não tem uma conta? <a href="/cadastro">criar conta</a>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>