package org.encheres.bll.ArticleVendu;

import java.time.LocalDateTime;
import java.util.List;

import org.encheres.bo.ArticleVendu;
import org.encheres.bo.Categorie;
import org.encheres.bo.Utilisateur;
import org.encheres.bo.dto.ArticleVenduUserInputDTO;
import org.encheres.errors.DatabaseException;
import org.encheres.errors.ParsingException;

public interface ArticleVenduManager {
    boolean isValid(ArticleVendu articleVendu);

    ArticleVendu insertArticleVendu(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        ArticleVendu.EtatVente etatVente,
        Utilisateur utilisateur,
        Categorie categorie
    ) throws DatabaseException;

    ArticleVendu parse(ArticleVenduUserInputDTO articleVenduUserInputDTO)
        throws ParsingException;

	List<ArticleVendu> selectAll() throws DatabaseException;
}
