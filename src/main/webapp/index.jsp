<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>ENI-Enchères</title>
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
					data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
					<%
					boolean isConnected = false; // TO DO SESSION
					if (isConnected) {
					%>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							href="index.jsp">Enchère</a></li>
						<li class="nav-item"><a class="nav-link"
							href="nouvelle-vente.jsp">Vendre un article</a></li>
						<li class="nav-item"><a class="nav-link" href="profil.jsp">Mon
								profil</a></li>
						<li class="nav-item"><a class="nav-link" href="connexion.jsp">Déconnexion</a></li>
					</ul>
					<%
					} else {
					%>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="inscription.jsp">S'inscrire</a></li>
						<li class="nav-item"><a class="nav-link" href="connexion.jsp">Se
								connecter</a></li>
					</ul>
					<%
					}
					%>
				</div>
			</div>
		</nav>

	</header>
	<main>

		<form class="">
			<fieldset>
				<div class="row justify-content-center">
						<div class="col-11 col-md-6 col-lg-4">

							<h5>Filtres :</h5>
							<div class="mb-3">
								<input type="text" id="disabledTextInput" class="form-control"
									placeholder="Le nom de l'article contient">
							</div>
							<div class="mb-3">
								<label for="disabledSelect" class="form-label">Catégorie
									: </label> <select id="disabledSelect" class="form-select">
									<option value="toutes">Toutes</option>
									<option value="1">1</option>
									<option value="2">>2</option>
									<option value="3">>3</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Rechercher</button>
						</div>
					</div>
			</fieldset>
		</form>
	</main>
	<!-- Le reste de votre contenu HTML -->



	<!-- Inclure votre fichier JavaScript à la fin du corps de la page -->
	<script src="asset/script.js"></script>
</body>
</html>

</body>
</html>