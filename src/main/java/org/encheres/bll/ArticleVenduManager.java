package org.encheres.bll;

import java.time.LocalDate;

import org.encheres.dal.Factory;
import org.encheres.dal.articleVendu.ArticleVenduDAO;

public class ArticleVenduManager {
    private ArticleVenduDAO articleVendu;

    public ArticleVenduManager() {
        articleVendu = Factory.getArticleVendu();
    }

    public void Ajout(
        Integer noArticle,
        String nomArticle,
        String description,
        LocalDate dateDebutEncheres,
        LocalDate dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        String etatVente
    ) {}

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
