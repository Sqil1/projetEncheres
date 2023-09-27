<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>connexion</title>
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
<form action="motsPasseOublier" method="post">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="mb-3">
                    <label class="form-label">Token</label>
                    <input type="text" name="token" class="form-control"
                           id="token" aria-describedby="emailHelp" value="${token}" readonly
                           required="required">

                </div>
                <div class="mb-3">
                    <label class="form-label">Mot
                        de Passe</label> <input type="password" name="motDePasse"
                                                class="form-control" id="motdepasse" required="required">
                </div>
                <div class="btn-toolbar justify-content-between">
                    <div class="button">
                        <button class="btn btn-primary" name="connexion" type="submit">Modifier le mots de passe</button>
                    </div>
                    <div class="input-group">
                        <a class=" btn btn-warning" href="index.jsp">Retour</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>