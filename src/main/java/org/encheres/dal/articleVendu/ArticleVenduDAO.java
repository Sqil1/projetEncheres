package org.encheres.dal.articleVendu;

import java.util.List;

import org.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
    public void insert(ArticleVendu articleVendu);
    public void update(ArticleVendu articleVendu);
    public void deleteById(int noUtilisateur);
    public List<ArticleVendu> selectAll();
}
