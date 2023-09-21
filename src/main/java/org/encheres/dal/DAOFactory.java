package org.encheres.dal;

import org.encheres.dal.articleVendu.ArticleVenduDAO;
import org.encheres.dal.articleVendu.ArticleVenduDAOJdbcImpl;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
    public static ArticleVenduDAO getArticleVendu() {
            return new ArticleVenduDAOJdbcImpl();
    }
}
