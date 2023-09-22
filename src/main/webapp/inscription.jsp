<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>inscription</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="asset/styles.css">


</head>
<body>
	<header>

		<nav class="navbar navbar-expand-lg bg-body-tertiary mb-4">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">ENI-Enchère</a>
			</div>
		</nav>

	</header>

	<form class="row g-3 justify-content-center" action="Inscription"
		method="post">
		<div class="col-11 col-md-8 col-lg-6">
			<div class="row">
				<div class="col-12 col-md-6">
					<label for="validationDefault01" class="form-label">Pseudo</label>
					<input type="text" name="pseudo" class="form-control"
						value="${param.pseudo}" id="validationDefault01" required>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-md-6">
					<label for="validationDefault01" class="form-label">Prenom</label>
					<input type="text" class="form-control" name="prenom"
						value="${param.prenom}" id="validationDefault01" required>
				</div>
				<div class="col-12 col-md-6">
					<label for="validationDefault02" class="form-label">Nom</label> <input
						type="text" class="form-control" name="nom" value="${param.nom}"
						id="validationDefault02" required>
				</div>
			</div>
			<div class="row ">
				<div class="col-12 col-md-6">
					<label for="validationDefault02" class="form-label">Email</label> <input
						type="email" class="form-control" name="email"
						value="${param.email}" id="validationDefault02" required>
				</div>

				<div class="col-12 col-md-6">
					<label for="validationDefault02" class="form-label">Téléphone</label>
					<input type="tel" class="form-control" name="telephone"
						value="${param.telephone}" id="validationDefault02" required>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-md-6">
					<label for="validationDefault03" class="form-label">Rue</label> <input
						type="text" class="form-control" name="rue" value="${param.rue}"
						id="validationDefault03" required>
				</div>
				<div class="col-12 col-md-6">
					<label for="validationDefault03" class="form-label">Ville</label> <input
						type="text" class="form-control" name="ville"
						value="${param.ville}" id="validationDefault03" required>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-md-6">
					<label for="validationDefault03" class="form-label">Code
						Postal</label> <input type="text" min="1000" max="99999" name="codePostal"
						class="form-control" name="codepostal" value="${param.codePostal}"
						id="validationDefault03" placeholder="Exemple : 13000" required>
				</div>
			</div>

			<div class="row">
				<div class="col-12 col-md-6">
					<label for="exampleInputPassword1" class="form-label">Mot
						de passe</label> <input type="password" class="form-control"
						name="motDePasse" id="exampleInputPassword1">
				</div>
				<div class="col-12 col-md-6">
					<label for="exampleInputPassword1" class="form-label">Confirmation</label>
					<input type="password" class="form-control" name="confirmation"
						id="exampleInputPassword1">${ erreurMdp }<br />
				</div>
			</div>

			<div class="btn-toolbar justify-content-between">
				<div class="button">
					<button class="btn btn-primary" name="creer" type="submit">Créer</button>
					<button class="btn btn-danger" name="annuler" type="reset">Annuler</button>
				</div>
				<div class="input-group">
					<a class=" btn btn-warning" href="index.jsp">Retour</a>
				</div>
			</div>
		</div>
	</form>

</body>
</html>