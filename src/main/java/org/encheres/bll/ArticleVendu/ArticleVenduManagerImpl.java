package org.encheres.bll.ArticleVendu;




import java.time.LocalDateTime;

import org.encheres.bo.ArticleVendu;
import org.encheres.bo.Categorie;
import org.encheres.bo.Utilisateur;
import org.encheres.dal.DAOFactory;
import org.encheres.errors.DatabaseException;
public class ArticleVenduManagerImpl implements ArticleVenduManager {
    private static ArticleVenduManager articleVenduManager = null;

    public static ArticleVenduManager getInstance() {
        if (articleVenduManager == null) {
            synchronized (ArticleVenduManagerImpl.class) {
                if (articleVenduManager == null) {
                    articleVenduManager = new ArticleVenduManagerImpl();
                }
            }
        }

        return articleVenduManager;
    }

    @Override
    public ArticleVendu createArticleVendu(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        String etatVente,
        Integer noUtilisateur,
        Integer noCategorie
    ) throws DatabaseException {
        // Utilisateur utilisateur = utilisateurManager.selectById(noUtilisateur);
        // TODO HACK wait UtilisateurManager.selectById() implementation
        Utilisateur utilisateur = Utilisateur.builder().build(); // temp mockup

        // Categorie categorie = categorieManager.selectById(noCategorie);
        // TODO HACK wait CategorieManager.selectById() implementation
        Categorie categorie = new Categorie(); // temp mockup

        final ArticleVendu articleVendu = new ArticleVendu.Builder(
            nomArticle,
            description,
            dateDebutEncheres,
            dateFinEncheres,
            prixInitial,
            prixVente,
            etatVente,
            utilisateur,
            categorie
        ).build();

        return DAOFactory.getArticleVenduDAO().insert(articleVendu);
    }

    @Override
    public boolean isValid(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        String etatVente
    ) {
        boolean result =    
            isValidNomArticle(nomArticle) ||
            isValidDescription(description) ||
            isValidDateDebutEncheres(dateDebutEncheres) ||
            isValidDateFinEncheres(dateFinEncheres) ||
            isValidPrixInitial(prixInitial) ||
            isValidPrixVente(prixVente) ||
            isValidEtatVente(etatVente);

        return result;
    }

    public boolean isValidNomArticle(String nomArticle) {
        // TODO data validation
        boolean result = false;

        return result;
    }

    public boolean isValidDescription(String description) {
        // TODO data validation
        boolean result = false;

        return result;
    }

    public boolean isValidDateDebutEncheres(LocalDateTime dateDebutEncheres) {
        // TODO data validation
        boolean result = false;

        return result;
    }

    public boolean isValidDateFinEncheres(LocalDateTime dateFinEncheres) {
        // TODO data validation
        boolean result = false;

        return result;
    }

    public boolean isValidPrixInitial(Integer prixInitial) {
        // TODO data validation
        boolean result = false;

        return result;
    }

    public boolean isValidPrixVente(Integer prixVente) {
        // TODO data validation
        boolean result = false;

        return result;
    }

    public boolean isValidEtatVente(String etatVente) {
        // TODO data validation
        boolean result = false;

        return result;
    }
}
