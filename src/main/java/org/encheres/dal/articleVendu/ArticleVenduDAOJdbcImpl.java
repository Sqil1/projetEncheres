package org.encheres.dal.articleVendu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.encheres.bo.ArticleVendu;
import org.encheres.dal.ConnectionProvider;
import org.encheres.errors.DatabaseException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
    private static final String INSERT =
        "INSERT INTO ARTICLES_VENDUS" +
        "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie, etat_vente)" +
        "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SELECTALL = "SELECT * FROM ARTICLES_VENDUS";

	@Override
	public ArticleVendu insert(ArticleVendu articleVendu) throws DatabaseException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, articleVendu.getNomArticle());
            preparedStatement.setString(2, articleVendu.getDescription());
            preparedStatement.setObject(3, articleVendu.getDateDebutEncheres());
            preparedStatement.setObject(4, articleVendu.getDateFinEncheres());
            preparedStatement.setInt(5, articleVendu.getPrixInitial());
            preparedStatement.setInt(6, articleVendu.getUtilisateur().getNoUtilisateur());
            preparedStatement.setInt(7, articleVendu.getCategorie().getNoCategorie());
            preparedStatement.setString(8, articleVendu.getEtatVente().toString());

			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				return ArticleVendu.builder(articleVendu).setNoArticle(resultSet.getInt(1)).build();
			}

            throw new DatabaseException("Erreur de serialisation de l'article.");

		} catch (SQLException e) {
			throw new DatabaseException("Echec d'insert de l'article : " + e.getMessage());
		}
	}

    @Override
    public void deleteById(Integer noUtilisateur) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ArticleVendu> selectAll() throws DatabaseException {

    	List<ArticleVendu> articles = new ArrayList<>();

    	try (Connection connection = ConnectionProvider.getConnection();
    			Statement statement = connection.createStatement();
    			ResultSet resultSet = statement.executeQuery(SELECTALL)) {

    		while (resultSet.next()) {
    			
        		Integer noArticle = resultSet.getInt("no_article");
        		String nomArticle = resultSet.getString("nom_article");
        		String description = resultSet.getString("description");
        		LocalDateTime dateDebutEncheres = resultSet.getTimestamp("date_debut_encheres").toLocalDateTime();
        		LocalDateTime dateFinEncheres = resultSet.getTimestamp("date_fin_encheres").toLocalDateTime();
        		Integer prixInitial = resultSet.getInt("prix_initial");
        		Integer prixVente = resultSet.getInt("prix_vente");
        		String etatVenteStr = resultSet.getString("etat_vente");
        		ArticleVendu.EtatVente etatVente = ArticleVendu.EtatVente.valueOf(etatVenteStr);
    			
    			ArticleVendu article = new ArticleVendu.Builder()
    					.setNoArticle(noArticle)
    					.setNomArticle(nomArticle)
    					.setDescription(description)
    					.setDateDebutEncheres(dateDebutEncheres)
    					.setDateFinEncheres(dateFinEncheres)
    					.setPrixInitial(prixInitial)
    					.setPrixVente(prixVente)
    					.setEtatVente(etatVente)
    					.build();
    			articles.add(article);
    		}
    	} catch (SQLException e) {
    		System.out.println(e);
    		throw new DatabaseException("Erreur lors de la récupération des articles depuis la base de données.");
    	}
    	return articles;
    }

	@Override
	public void update(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub

	}
}
