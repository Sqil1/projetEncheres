<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères</title>
	<%@ include file="/includes/header.jspf" %>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="Index">ENI-Enchère</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<c:set var="utilisateurConnecte" value="false" />
					<c:if test="${sessionScope.utilisateurConnecte != null}">
						<c:set var="utilisateurConnecte"
							value="${sessionScope.utilisateurConnecte}" />
					</c:if>
					<c:choose>
						<c:when test="${utilisateurConnecte}">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="Index">Enchère</a></li>
								<li class="nav-item"><a class="nav-link"
									href="ajout-article.jsp">Vendre un article</a></li>
								<li class="nav-item"><a class="nav-link"
									href="profilUtilisateur.jsp">Mon profil</a></li>
								<li class="nav-item"><a class="nav-link" href="Deconnexion">Déconnexion</a>
								</li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="inscription.jsp">S'inscrire</a></li>
								<li class="nav-item"><a class="nav-link"
									href="connexion.jsp">Se connecter</a></li>
							</ul>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</nav>
	</header>
	<main>
		<div class="col-12 text-center">
			<h1>Liste des enchères</h1>
		</div>
		<form>
			<fieldset>
				<div class="row justify-content-center mb-4">
					<div class="col-11 col-md-6 col-lg-4">
						<c:choose>
							<c:when test="${utilisateurConnecte}">
								<div class="alert alert-success" role="alert">Bonjour
									${utilisateur.pseudo}</div>
							</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose>
						<h5>Filtres :</h5>
						<div class="mb-3">
							<input type="text" id="disabledTextInput" class="form-control"
								placeholder="Le nom de l'article contient">
						</div>
						<div class="mb-3">
							<label for="disabledSelect" class="form-label">Catégorie
								: </label> <select id="disabledSelect" class="form-select">
								<option value="toutes">Informatique</option>
								<option value="1">Ameublement</option>
								<option value="2">Vêtements</option>
								<option value="3">Sport&loisirs</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Rechercher</button>
					</div>
				</div>
			</fieldset>
		</form>
		<!-- Affichage des messages -->
		<c:if test="${not empty sessionScope.inscriptionReussie}">
			<div>${sessionScope.inscriptionReussie}</div>
			<c:remove var="sessionScope.inscriptionReussie" scope="session" />
		</c:if>

		<c:if test="${not empty sessionScope.suppressionReussie}">
			<div>${sessionScope.suppressionReussie}</div>
			<c:remove var="sessionScope.suppressionReussie" scope="session" />
		</c:if>

		<c:if test="${not empty requestScope.erreurMdp}">
			<div>${requestScope.erreurMdp}</div>
		</c:if>


		<div class="row justify-content-center">
			<c:forEach var="article" items="${articles}">
				<div class="col-sm-8 col-md-5 col-lg-4">
					<div class="card mb-4" style="width: 18rem;">
						<div class="card-body d-flex flex-column">
							<h5 class="card-title">${article.nomArticle}</h5>
							<p class="card-text">Prix : ${article.prixVente}</p>
							<p class="card-text">Fin de l'enchère :
								${article.dateFinEncheres}</p>
							<p class="card-text"></p>
							<a href="#" class="card-link">Détails</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>