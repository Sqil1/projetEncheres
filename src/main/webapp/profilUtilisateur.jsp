<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil Utilisateur</title>
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
			</div>
		</nav>
	</header>
	
	<div class="container">
		<c:if test="${not empty sessionScope.connexionReussie}">
			<div >${sessionScope.connexionReussie}</div>
    		<c:remove var="sessionScope.connexionReussie" scope="session" />
		</c:if>
        <h1>Mon Profil</h1>
        <table class="table">
            <tr>
                <th>Pseudo:</th>
                <td>${utilisateur.pseudo}</td>
            </tr>
            <tr>
                <th>Nom:</th>
                <td>${utilisateur.nom}</td>
            </tr>
            <tr>
                <th>Prénom:</th>
                <td>${utilisateur.prenom}</td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>${utilisateur.email}</td>
            </tr>
            <tr>
                <th>Téléphone:</th>
                <td>${utilisateur.telephone}</td>
            </tr>
            <tr>
                <th>Rue:</th>
                <td>${utilisateur.rue}</td>
            </tr>
            <tr>
                <th>Code Postal:</th>
                <td>${utilisateur.codePostal}</td>
            </tr>
            <tr>
                <th>Ville:</th>
                <td>${utilisateur.ville}</td>
            </tr>
        </table>
         <a href="modificationUtilisateur.jsp" class="btn btn-primary">Modifier Profil</a>
        
    </div>

</body>
</html>