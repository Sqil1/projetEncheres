package org.encheres.dal.Enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.encheres.bo.Enchere;
import org.encheres.dal.ConnectionProvider;
import org.encheres.errors.DatabaseException;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String INSERT = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE ENCHERES SET montant_enchere = ? WHERE no_utilisateur = ? AND no_article = ?";
	private static final String SELECT_ALL = "SELECT * FROM ENCHERES";
	private static final String SELECT_BY_NO_UTILISATEUR = "SELECT no_utilisateur FROM ENCHERES WHERE no_article = ? AND montant_enchere = (SELECT MAX(montant_enchere) FROM ENCHERES WHERE no_article = ?)";

	@Override
	public Enchere insert(Enchere enchere) throws DatabaseException {
	    try (Connection connection = ConnectionProvider.getConnection()) {
	        PreparedStatement preparedStatement = connection.prepareStatement(INSERT,
	                PreparedStatement.RETURN_GENERATED_KEYS);

	        preparedStatement.setInt(1, enchere.getNoUtilisateur());
	        preparedStatement.setInt(2, enchere.getNoArticle());
	        preparedStatement.setObject(3, LocalDateTime.now());
	        preparedStatement.setInt(4, enchere.getMontantEnchere());

	        preparedStatement.executeUpdate();

	        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            enchere.setEnchereId(generatedKeys.getInt(1));
	        }
	    } catch (SQLException e) {
	        throw new DatabaseException("Erreur lors de l'insertion de l'enchère dans la base de données.");
	    }
	    return enchere;
	}
	
	@Override
	public void update(Enchere enchere) throws DatabaseException {
	    try (Connection connection = ConnectionProvider.getConnection()) {
	        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

	        preparedStatement.setInt(1, enchere.getMontantEnchere());
	        preparedStatement.setInt(2, enchere.getNoUtilisateur());
	        preparedStatement.setInt(3, enchere.getNoArticle());

	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        throw new DatabaseException("Erreur lors de la mise à jour de l'enchère dans la base de données.");
	    }
	}

	@Override
	public List<Enchere> selectAll() throws DatabaseException {
	    List<Enchere> encheres = new ArrayList<>();

	    try (Connection connection = ConnectionProvider.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {

	        while (resultSet.next()) {
	            Enchere enchere = new Enchere();
	            enchere.setNoUtilisateur(resultSet.getInt("no_utilisateur"));
	            enchere.setNoArticle(resultSet.getInt("no_article"));
	            enchere.setDateEnchere(resultSet.getTimestamp("date_enchere").toLocalDateTime());
	            enchere.setMontantEnchere(resultSet.getInt("montant_enchere"));

	            encheres.add(enchere);
	        }
	    } catch (SQLException e) {
	        throw new DatabaseException("Erreur lors de la récupération des enchères depuis la base de données.");
	    }

	    return encheres;
	}
	
	@Override
	public int getUtilisateurIdMeilleureOffre(int enchereId) throws DatabaseException {
	    
	    try (Connection connection = ConnectionProvider.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NO_UTILISATEUR)) {

	        preparedStatement.setInt(1, enchereId);
	        preparedStatement.setInt(2, enchereId);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                return resultSet.getInt("no_utilisateur");
	            }
	        }
	    } catch (SQLException e) {
	        throw new DatabaseException("Erreur lors de la récupération de l'utilisateur ayant fait la meilleure offre.");
	    }

	    return -1; // Valeur par défaut en cas d'erreur ou si aucune meilleure offre n'a été trouvée.
	}

}
