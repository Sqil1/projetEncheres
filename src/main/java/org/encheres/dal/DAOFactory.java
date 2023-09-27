package org.encheres.dal;

import org.encheres.dal.articleVendu.ArticleVenduDAO;
import org.encheres.dal.articleVendu.ArticleVenduDAOJdbcImpl;
import org.encheres.dal.tokenPassword.TokenPasswordDAO;
import org.encheres.dal.tokenPassword.TokenPasswordDAOJdbcImpl;

public class DAOFactory {

    public static UtilisateurDAO getUtilisateurDAO() {
        return new UtilisateurDAOJdbcImpl();
    }

    public static ArticleVenduDAO getArticleVenduDAO() {
        return new ArticleVenduDAOJdbcImpl();
    }


    public static TokenPasswordDAO getTokenPasswordDAO() {
        return new TokenPasswordDAOJdbcImpl();
    }

}
