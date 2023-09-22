<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="asset/styles.css">


</head>
<body>
	<header>

		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">ENI-Enchère</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

			</div>
		</nav>

	</header>

	<form  action="Connexion" method="post">
	<div class="container">
	 	<div class="row justify-content-center">
	 	 <div class="col-md-6">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Identifiant</label>
			<input type="email" name="identifiant" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp">

		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Mot de
				Passe</label> <input type="password" name="motDePasse" class="form-control"
				id="motdepasse">
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox"  class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Se
				souvenir de moi</label>
		</div>
		<div class="mb-3 form-check">
			<a href="#">Mot de passe oublié</a>
		</div>
		<button type="submit" value="Connexion" class="btn btn-primary">Connexion</button>
		</div>
		</div>
		</div>
	</form>


</body>
</html>