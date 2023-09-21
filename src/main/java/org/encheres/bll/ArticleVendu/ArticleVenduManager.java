package org.encheres.bll.ArticleVendu;

import java.time.LocalDateTime;

import org.encheres.bo.ArticleVendu;
import org.encheres.errors.DatabaseException;

public interface ArticleVenduManager {
    boolean isValid(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        String etatVente
    );

    ArticleVendu createArticleVendu(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        String etatVente,
        Integer noUtilisateur,
        Integer noCategorie
    ) throws DatabaseException;
}
