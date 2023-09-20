<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inscription</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="asset/styles.css" >


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
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="inscription.jsp">S'inscrire</a></li>
						<li class="nav-item"><a class="nav-link" href="connexion.jsp">Se connecter</a></li>
					</ul>
				</div>
			</div>
		</nav>

	</header>

	<form class="row g-3">
	<div class="row g-3">
 			<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault01" class="form-label">Pseudo</label> 
			<input type="text" name="pseudo" class="form-control"	id="validationDefault01"required>
		</div>
		</div>
	<div class="row g-3">
		<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault01" class="form-label">Prenom</label> 
			<input type="text" class="form-control" name="prenom" id="validationDefault01"  required>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault02" class="form-label">Nom</label>
			<input type="text" class="form-control" name="nom" id="validationDefault02" required>
		</div>

		<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault02" class="form-label">Email</label>
			<input type="email" class="form-control" name="email" id="validationDefault02" required>
		</div>
		
		<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault02" class="form-label">Téléphone</label>
			<input type="tel" class="form-control" name="telephone" id="validationDefault02" required>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault03" class="form-label">Rue</label> 
			<input type="text" class="form-control" name="rue" id="validationDefault03" required>
		</div>
				<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault03" class="form-label">Ville</label> 
			<input type="text" class="form-control" name="ville" id="validationDefault03" required>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<label for="validationDefault03" class="form-label">Code Postal</label>
			 <input type="number"  min="1000" max ="99999" class="form-control" name="codepostal" id="validationDefault03" placeholder="Exemple : 13000" required>
		</div>
				</div>
		<div class="row g-3">
		  <div class="col-md-6 col-sm-6 col-xs-12">
    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" name="mdp" id="exampleInputPassword1">
  </div>
  		  <div class="col-md-6 col-sm-6 col-xs-12">
    <label for="exampleInputPassword1" class="form-label">Confirmation</label>
    <input type="password" class="form-control" name="confirmation" id="exampleInputPassword1">
  </div>
</div>

<div class="row g-3">
		<div class="col-12 text-center">
			<button class="btn btn-primary" name="creer" type="submit">Créer</button>
			<button class="btn btn-primary" name="annuler" type="reset">Annuler</button>

		</div>
		</div>

	</form>

</body>
</html>