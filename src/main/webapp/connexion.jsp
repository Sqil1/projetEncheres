<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connexion</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/styles.css">


</head>
<body>
	<header>

		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="Index">ENI-Enchère</a>
			</div>
		</nav>

	</header>
	<form action="Connexion" method="post">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Identifiant</label>
						<input type="text" name="identifiant" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							required="required">

					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Mot
							de Passe</label> <input type="password" name="motDePasse"
							class="form-control" id="motdepasse" required="required">
					</div>
					<c:if test="${not empty requestScope.erreur}">
						<div class="message-erreur">${requestScope.erreur}</div>
						<c:remove var="sessionScope.erreur" scope="session" />
					</c:if>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Se
							souvenir de moi</label>
					</div>
					<div class="mb-3 form-check">
						<a href="#">Mot de passe oublié</a>
					</div>
					<div class="btn-toolbar justify-content-between">
						<div class="button">
							<button class="btn btn-primary" name="connexion" type="submit">Connexion</button>
						</div>
						<div class="input-group">
							<a class=" btn btn-warning" href="index.jsp">Retour</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>