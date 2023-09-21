package org.encheres.dal.articleVendu;

import java.util.List;

import org.encheres.bo.ArticleVendu;
import org.encheres.errors.DatabaseException;

public interface ArticleVenduDAO {
    public ArticleVendu insert(ArticleVendu articleVendu) throws DatabaseException;
    public void update(ArticleVendu articleVendu);
    public void deleteById(int noUtilisateur);
    public List<ArticleVendu> selectAll();
}
