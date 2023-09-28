<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Profil Utilisateur</title>
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

	<div class="container">
		<h1>Mon Profil</h1>

		<form action="ModifierProfil" method="POST" class="row g-3">
			<div class="col-md-6">
				<div class="mb-3">
					<label for="pseudo" class="form-label">Pseudo :</label> <input
						type="text" class="form-control" id="pseudo" name="pseudo"
						value="${utilisateur.pseudo}">
				</div>
				<div class="mb-3">
					<label for="prenom" class="form-label">Prénom :</label> <input
						type="text" class="form-control" id="prenom" name="prenom"
						value="${utilisateur.prenom}">
				</div>
				<div class="mb-3">
					<label for="telephone" class="form-label">Téléphone :</label> <input
						type="tel" class="form-control" id="telephone" name="telephone"
						value="${utilisateur.telephone}">
				</div>
				<div class="mb-3">
					<label for="codePostal" class="form-label">Code Postal :</label> <input
						type="text" class="form-control" id="codePostal" name="codePostal"
						value="${utilisateur.codePostal}">
				</div>
				<div class="mb-3">
					<label for="motDePasseActuel" class="form-label">Mot de
						passe actuel :</label> <input type="password" class="form-control"
						id="motDePasseActuel" name="motDePasseActuel"required="required">
				</div>
				<div class="mb-3">
					<label for="nouveauMotDePasse" class="form-label">Nouveau
						mot de passe :</label> <input type="password" class="form-control"
						id="nouveauMotDePasse" name="nouveauMotDePasse"required="required">
				</div>
			</div>

			<div class="col-md-6">
				<div class="mb-3">
					<label for="nom" class="form-label">Nom :</label> <input
						type="text" class="form-control" id="nom" name="nom"
						value="${utilisateur.nom}">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email :</label> <input
						type="email" class="form-control" id="email" name="email"
						value="${utilisateur.email}">
				</div>
				<div class="mb-3">
					<label for="rue" class="form-label">Rue :</label> <input
						type="text" class="form-control" id="rue" name="rue"
						value="${utilisateur.rue}">
				</div>
				<div class="mb-3">
					<label for="ville" class="form-label">Ville :</label> <input
						type="text" class="form-control" id="ville" name="ville"
						value="${utilisateur.ville}">
				</div>
				<div class="mb-3">
					<label> <input class="form-control border-0"></label>

				</div>
				<div class="mb-3">
					<label for="confirmationMotDePasse" class="form-label">Confirmez
						le nouveau mot de passe :</label> <input type="password"
						class="form-control" id="confirmationMotDePasse"
						name="confirmationMotDePasse" required="required">
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-6">
					<button type="submit" class="btn btn-primary">Enregistrer
						les Modifications</button>
				</div>
			</div>
		</form>
		<a class=" btn btn-warning" href="profilUtilisateur.jsp">Retour</a>
		<form action="SupprimerProfil" method="POST">
			<button type="submit" class="btn btn-danger">Supprimer le
				Profil</button>
		</form>
	</div>
</body>
</html>
