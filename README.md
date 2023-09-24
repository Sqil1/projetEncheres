# Branch en cours - à ne pas merge

## Nouveau/Modif
### DAO/BLL/Servlet
OOP Layer pattern

Tous les fichiers ajoutés/modifiés :
```tree
📦src
 ┗ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂org
 ┃ ┃ ┃ ┗ 📂encheres
 ┃ ┃ ┃ ┃ ┣ 📂bll
 ┃ ┃ ┃ ┃ ┃ ┗📂ArticleVendu
 ┃ ┃ ┃ ┃ ┃    ┣ 📜ArticleVenduManager.java
 ┃ ┃ ┃ ┃ ┃    ┗ 📜ArticleVenduManagerImpl.java
 ┃ ┃ ┃ ┃ ┣ 📂bo
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ArticleVenduUserInputDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ 📜ArticleVendu.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜DefaultValue.java
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
 ┃   ┣ 📂css
 ┃   ┃  ┗ ajout-article.css
 ┃   ┗ 📜ajout-article.jsp
```
### ArticleVendu
Passé en Builder pattern pour le POJO.
### /bo/dto/ArticleVenduUserInputDTO.java
Sert de lien entre user input / DAL pour le parsing.
### /bo/DefaultValue.java
Pour stocker toutes nos constantes/default qu'on est pas à chercher partout si on en change. (Au moins pour la partie Java).

Utilise des attribut public pour les appeler facilement ex: DefaultValue.PRIX_INITIAL_MIN
### /controler/ServletAjoutArticle.java
Servlet qui renvoit sur la page jsp en GET.

Et qui execute les opérations BLL avec les Attribut du formulaire en POST.

Je triche pour la session utilisateur et la Categorie pour l'instant, à implémenter plus tard quand c'est créé.

TODO :
- récupérer la session/cookie
- transformer la session en user_id
- fetch a Utilisateur object avec un selectById(user_id)
- même chose pour Categorie dans doPost()
- fetch toutes les id des categorie dans doGet()
### /dal/articleVendu/ArticleVenduDAOJdbcImpl.java
CRUD et autre requête SQL pour la BLL

TODO dans une autre feature branch:
- update
- deleteById
- SelectAll
- etc.
### /webapp/ajout-article.jsp
Page accessible à un utilisateur connecté.

Ajout d'article en vente.

TODO:
- session
- navigation à compléter
- afficher la liste des catégories dans un menu déroulant
## En attentente d'autre implémentations
### Session
A récupérer sur ServletAjoutArticle.java
### Categorie.selectById & Utilisateur.selectById
A récupérer sur ArticleVenduManagerImpl.java
## Questionnement
DB table ArticleVendu column prix_initial accept le NULL. Je pense que ça devrait être NOT NULL