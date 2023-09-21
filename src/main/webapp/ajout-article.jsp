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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet">
    <script
	    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
    </script>
    <title>Ajout d'article</title>
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
						<li class="nav-item"><a class="nav-link" href="connexion.jsp">Se
								connecter</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

    <main>
        <form>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">String val 1</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        
                        </div>

                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">String val 2</label>
                            <input type="password" class="form-control" id="exampleInputPassword1">
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">checkbox val</label>
                        </div>

                        <div class="mb-3 form-check">
                            <a href="#">link</a>
                        </div>

                        <button type="submit" class="btn btn-primary">Submit form</button>
                    </div>
                </div>
            </div>
        </form>
    </main>
</body>
</html>
