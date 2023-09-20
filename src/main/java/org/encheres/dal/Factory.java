package org.encheres.dal;

import org.encheres.dal.articleVendu.ArticleVenduDAO;
import org.encheres.dal.articleVendu.ArticleVenduDAOJdbcImpl;

public abstract class Factory {
    public static ArticleVenduDAO getArticleVendu() {
        return new ArticleVenduDAOJdbcImpl();
    }
}
