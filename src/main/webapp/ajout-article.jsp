<!--
    - TODO lier session
    - TODO lier navigation
    - TODO list categories
-->

<%@
    page language = "java"
    contentType   = "text/html; charset=UTF-8"
    pageEncoding  = "UTF-8" 
    isELIgnored   = "false"
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajout d'article</title>

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

    <main>
        <article>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 mb-3 ${articleBootstrapClass}">
                        ${message}
                    </div>
                </div>
            </div>
        </article>
        <form method="POST" action="AjoutArticle">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <!-- nomArticle -->
                        <div class="mb-3">
                            <label for="nomArticle" class="form-label">
                                Nom de l'article
                                <div class="info-bubble" id="nomArticleInfo">
                                    Entrez le nom de l'article (sans caractère spéciaux). Taille max 30 caractères.
                                </div>
                            </label>
                            <input type="text" maxlength="30" class="form-control" id="nomArticle" name="nomArticle" aria-describedby="nomArticleInfo">
                        </div>

                        <!-- description -->
                        <div class="mb-3">
                            <label for="description" class="form-label">
                                Description
                                <div class="info-bubble" id="descriptionInfo">
                                    Entrez la description de l'article (sans caractère spéciaux). Taille max 300 caractères.
                                </div>
                            </label>
                            <textarea maxlength="300" class="form-control" id="description" name="description" aria-describedby="descriptionInfo"></textarea>
                        </div>

                        <!-- dateDebutEncheres -->
                        <div class="row mb-3 g-3">
                            <!-- date debut -->
                            <div class="col-md-6">
                                <label for="dateDebutEncheres_date" class="form-label">
                                    Date du début de l'enchère
                                    <div class="info-bubble" id="dateDebutEncheresInfo_date">
                                        Entrez la date de début de l'enchère. Delai maximum d'une semaine et pas plus tôt qu'aujourd'hui.
                                    </div>
                                </label>
                                <input type="date" value="${dateNow}" class="form-control" id="dateDebutEncheres_date" name="dateDebutEncheres_date" aria-describedby="dateDebutEncheresInfo_date">
                            </div>

                            <!-- time debut -->
                            <div class="col-md-4">
                                <label for="dateDebutEncheres_time" class="form-label">
                                    Heure
                                    <div class="info-bubble" id="dateDebutEncheresInfo_time">
                                        Entrez l'heure de début de l'enchère. Pas plus tôt que maintenant.
                                    </div>
                                </label>
                                <input type="time" value="${hoursNow}:${minutesNow}" class="form-control" id="dateDebutEncheres_time" name="dateDebutEncheres_time" aria-describedby="dateDebutEncheresInfo_time">
                            </div>
                        </div>

                        <!-- dateFinEncheres -->
                        <div class="row mb-3 g-3">
                            <!-- date fin -->
                            <div class="col-md-6">
                                <label for="dateFinEncheres_date" class="form-label">
                                    Date de fin de l'enchère
                                    <div class="info-bubble" id="dateFinEncheresInfo_date">
                                        Entrez la date de fin de l'enchère. Pas plus tôt qu'une heure après le début et moins d'un an après.
                                    </div>
                                </label>
                                <input type="date" value="${datePlusOneWeek}" class="form-control" id="dateFinEncheres_date" name="dateFinEncheres_date" aria-describedby="dateFinEncheresInfo_date">
                            </div>

                            <!-- hours fin -->
                            <div class="col-md-4">
                                <label for="dateFinEncheres_time" class="form-label">
                                    Heure
                                    <div class="info-bubble" id="dateFinEncheresInfo_time">
                                        Entrez l'heure de fin de l'enchère. Pas plus tôt qu'une heure après le début.
                                    </div>
                                </label>
                                <input type="time" maxlength="2" value="${hoursNow}:${minutesNow}" class="form-control" id="dateFinEncheres_time" name="dateFinEncheres_time" aria-describedby="dateFinEncheresInfo_time">
                            </div>
                        </div>

                        <!-- prix initial -->
                        <div class="col-md-4 mb-4">
                            <label for="prixInitial" class="form-label">
                                Prix initial en points.
                                <div class="info-bubble" id="prixInitialInfo">
                                    Entrez le prix initial entre 0 et 100.000.000 de points.
                                </div>
                            </label>
                            <input type="number" min="0" max="100000000" class="form-control" id="prixInitial" name="prixInitial" aria-describedby="prixInitialInfo">
                        </div>
                        
                        <button type="reset" class="btn btn-secondary">Annuler</button>
                        <button type="submit" class="btn btn-primary">Valider</button>

                        <div class="mt-4 form-check">
							<a class=" btn btn-warning" href="Index">Retour</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </main>
</body>
</html>
