<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet">
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
	<main>

		<form>
			<fieldset>
			    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-8 col-xl-10">

				<h5>Filtres : </h5>
				<div class="mb-3">
					<input type="text" id="disabledTextInput" class="form-control"
						placeholder="Le nom de l'article contient">
				</div>
				<div class="mb-3">
					<label for="disabledSelect" class="form-label">Catégorie :
					</label> <select id="disabledSelect" class="form-select">
						<option value="toutes">Toutes</option>
						<option value="1">1</option>
						<option value="2">>2</option>
						<option value="3">>3</option>
					</select>
				</div>
				<button type="submit" class="btn btn-primary">Rechercher</button>
				</div>
				</div>
				</div>
			</fieldset>
		</form>
		<!-- Affichage des messages -->
			<c:if test="${not empty sessionScope.inscriptionReussie}">
    			<div>${sessionScope.inscriptionReussie} </div>
   				<c:remove var="sessionScope.inscriptionReussie" scope="session" />
			</c:if>
		
    		<c:if test="${not empty sessionScope.suppressionReussie}">
        		<div>${sessionScope.suppressionReussie} </div>
        		<c:remove var="sessionScope.suppressionReussie" scope="session" />
   	 		</c:if>

			<c:if test="${not empty requestScope.erreurMdp}">
    			<div>${requestScope.erreurMdp}</div>
			</c:if>
	</main>
	<!-- Le reste de votre contenu HTML -->



<!-- Inclure votre fichier JavaScript à la fin du corps de la page -->
<script src="asset/script.js"></script>
</body>
</html>
	
</body>
</html>