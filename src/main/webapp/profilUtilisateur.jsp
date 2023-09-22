<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil Utilisateur</title>
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
		<h1 class="text-center mb-4">Mon Profil</h1>
		<div class="container">
					<div class="row justify-content-center">
			<div class="col-11 col-md-8 col-lg-6">

					<div class="mb-3">
						<table class="table table-bordered table-striped">
							<tr>
								<th class="table-info">Pseudo:</th>
								<td>${utilisateur.pseudo}</td>
							</tr>
							<tr>
								<th class="table-info">Nom:</th>
								<td>${utilisateur.nom}</td>
							</tr>
							<tr>
								<th class="table-info">Prénom:</th>
								<td>${utilisateur.prenom}</td>
							</tr>
							<tr>
								<th class="table-info">Email:</th>
								<td>${utilisateur.email}</td>
							</tr>
							<tr>
								<th class="table-info">Téléphone:</th>
								<td>${utilisateur.telephone}</td>
							</tr>

							<tr>
								<th class="table-info">Rue:</th>
								<td>${utilisateur.rue}</td>
							</tr>
							<tr>
								<th class="table-info">Code Postal:</th>
								<td>${utilisateur.codePostal}</td>
							</tr>
							<tr>
								<th class="table-info">Ville:</th>
								<td>${utilisateur.ville}</td>
							</tr>
						</table>
						<div class="btn-toolbar justify-content-center">
							<div class="input-group">
								<a class=" btn btn-warning" href="index.jsp">Retour</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

</body>
</html>