<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détail vente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="asset/styles.css">
</head>
<body>
    <c:set var="enchereId" value="${empty articleVendu.noArticle ? '123' : articleVendu.noArticle}" scope="session" />
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
    <main>
        <h1>Détails de la vente</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <img src="${empty articleVendu.photo ? 'URL_PAR_DEFAUT_SI_VIDE' : articleVendu.photo}" alt="${empty articleVendu.nomArticle ? 'Nom par défaut' : articleVendu.nomArticle}">
                </div>
                <div class="col-md-6">
                    <h2>${empty articleVendu.nomArticle ? 'Table' : articleVendu.nomArticle}</h2>
                    <h2>Description :</h2>
                    <p>${empty articleVendu.description ? 'Table de sejour' : articleVendu.description}</p>
                    <h2>Catégorie : ${empty articleVendu.categorie ? 'Meubles' : articleVendu.categorie}</h2>
                    <p>Meilleure offre : ${empty enchere ? '150' : enchere.montantEnchere} pts par ${empty utilisateurMeilleureOffre ? 'BOBBY' : utilisateurMeilleureOffre.pseudo}</p>
                    <p>Mise à prix : ${empty articleVendu.prixInitial ? '100' : articleVendu.prixInitial} points</p>
                    <p>Fin de l'enchère : ${empty articleVendu.dateFinEnchere ? '26/09/2023' : articleVendu.dateFinEnchere}</p>
                    <p>Retrait : ${empty articleVendu.retrait ? 'Retrait par défaut' : articleVendu.retrait}</p>
                    <p>Vendeur : ${empty articleVendu.utilisateur ? 'bobdylan' : articleVendu.utilisateur}</p>
                    <form action="Encherir" method="POST">
                        <input type="hidden" name="articleId" value="${empty articleVendu.noArticle ? '150' : articleVendu.noArticle}">
                        <label for="montantEnchere">Ma proposition :</label>
                        <input type="number" name="montantEnchere" id="montantEnchere" 
                            min="${enchere.montantEnchere + 10}" 
                            value="${enchere.montantEnchere + 10}">
                        <button type="submit">Enchérir</button>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
