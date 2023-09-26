package org.encheres.dal;

import org.encheres.dal.Enchere.EnchereDAO;
import org.encheres.dal.Enchere.EnchereDAOJdbcImpl;
import org.encheres.dal.articleVendu.ArticleVenduDAO;
import org.encheres.dal.articleVendu.ArticleVenduDAOJdbcImpl;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
    public static ArticleVenduDAO getArticleVenduDAO() {
        return new ArticleVenduDAOJdbcImpl();
    }
    
    public static EnchereDAO getEnchereDAO() {
    	return new EnchereDAOJdbcImpl();
    }

}
