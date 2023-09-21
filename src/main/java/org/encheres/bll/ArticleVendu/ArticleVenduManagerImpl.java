package org.encheres.bll.ArticleVendu;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.encheres.bo.ArticleVendu;
import org.encheres.dal.DAOFactory;
import org.encheres.errors.DatabaseException;
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

    public ArticleVendu add(
        Integer noArticle,
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        String etatVente
    ) throws DatabaseException {
        final ArticleVendu articleVendu = new ArticleVendu.Builder(
            noArticle,
            nomArticle,
            description,
            dateDebutEncheres,
            dateFinEncheres,
            prixInitial,
            prixVente,
            etatVente
        ).build();

        return DAOFactory.getArticleVenduDAO().insert(articleVendu);
    }

    public boolean isValidNoArticle(Integer noArticle) {
        // TODO check if id doesn't already exist
        boolean result = false;
            if (noArticle > 0) { result = true; }
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
    public boolean isValidDateDebutEncheres(LocalDate dateDebutEncheres) {
        // TODO data validation
        boolean result = false;

        return result;
    }
    public boolean isValidDateFinEncheres(LocalDate dateFinEncheres) {
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
