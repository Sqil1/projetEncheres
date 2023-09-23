package org.encheres.bll.ArticleVendu;

import java.time.LocalDateTime;

import org.encheres.bo.ArticleVendu;
import org.encheres.bo.dto.ArticleVenduUserInputDTO;
import org.encheres.errors.DatabaseException;
import org.encheres.errors.ParsingException;

public interface ArticleVenduManager {
    boolean isValid(ArticleVendu articleVendu);

    ArticleVendu createArticleVendu(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        ArticleVendu.EtatVente etatVente,
        Integer noUtilisateur,
        Integer noCategorie
    ) throws DatabaseException;

    ArticleVendu parse(ArticleVenduUserInputDTO articleVenduUserInputDTO)
        throws ParsingException;
}
