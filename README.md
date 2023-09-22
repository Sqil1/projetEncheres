# Branch en cours - à ne pas merge

## Nouveau/Modif
### DAO/BLL/Servlet
OOP Layer pattern :
```tree
📦src
 ┗ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂org
 ┃ ┃ ┃ ┗ 📂encheres
 ┃ ┃ ┃ ┃ ┣ 📂bll
 ┃ ┃ ┃ ┃ ┃ ┣ 📂ArticleVendu
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleVenduManager.java
 ┃ ┃ ┃ ┃ ┃ ┗ ┗ 📜ArticleVenduManagerImpl.java
 ┃ ┃ ┃ ┃ ┣ 📂bo
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ArticleVendu.java
 ┃ ┃ ┃ ┃ ┣ 📂controler
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ServletAjoutArticle.java
 ┃ ┃ ┃ ┃ ┣ 📂dal
 ┃ ┃ ┃ ┃ ┃ ┣ 📂articleVendu
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleVenduDAO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ArticleVenduDAOJdbcImpl.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜DAOFactory.java
 ┃ ┃ ┃ ┃ ┗ 📂errors
 ┃ ┃ ┃ ┃   ┗ 📜DatabaseException.java
 ┃ ┗ 📂webapp
 ┃   ┗ 📜ajout-article.jsp
```
### ArticleVendu
Passé en Builder pattern.
### /java/org/encheres/controler/ServletAjoutArticle.java
Servlet qui renvoit sur la page jsp en GET.

Et qui execute les opérations BLL avec les Attribut du formulaire en POST.

Je triche pour la session utilisateur et la Categorie pour l'instant, à implémenter plus tard quand c'est créé.
### /java/org/encheres/dal/articleVendu/ArticleVenduDAOJdbcImpl.java
CRUD et autre requête SQL pour la BLL

TODO:
- update
- deleteById
- SelectAll
- etc.
### /webapp/ajout-article.jsp
Page accessible à un utilisateur connecté.

Ajour d'article en vente.

TODO:
- form
- session
- navigation
- message en cas de mauvaise données
## En attentente d'autre implémentations
### Session
A récupérer sur ServletAjoutArticle.java
### Categorie.selectById & Utilisateur.selectById
A récupérer sur ArticleVenduManagerImpl.java
