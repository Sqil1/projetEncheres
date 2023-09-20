# Branch en cours - à ne pas merge

## Nouveau/Modif
### /java/org/encheres/controler/ServletAjoutArticle.java
Servlet qui renvoit sur la page jsp en GET.

Et qui execute les opérations BLL avec les Attribut du formulaire en POST.

TODO:
- récup des données du form
- execution BLL
### /java/org/encheres/dal/Factory.java (peux être en conflit avec les futur push)
Générateur d'instance d'implémentation DAO
### /java/org/encheres/bll/ArticleVenduManager.java
Manager de la BLL pour faire des opération DAL

TODO:
- Ajout de toutes les opération DAL
### /java/org/encheres/dal/articleVendu/ArticleVenduDAO.java
Interface de l'implementation DAO
### /java/org/encheres/dal/articleVendu/ArticleVenduDAOJdbcImpl.java
CRUD et autre requête SQL pour la BLL

TODO:
- insert
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
