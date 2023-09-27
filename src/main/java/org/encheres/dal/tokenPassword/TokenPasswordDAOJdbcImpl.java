package org.encheres.dal.tokenPassword;

import org.encheres.bo.TokenPassword;
import org.encheres.dal.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TokenPasswordDAOJdbcImpl implements TokenPasswordDAO {
    private static final String INSERT =
        "INSERT INTO TOKEN_PASSWORD" +
        "(no_utilisateur, token, date_creation, date_expiration)" +
        "VALUES(?, ?, ?, ?)";

	private static final String UPDATE_TOKEN_USED = "UPDATE TOKEN_PASSWORD SET token_used=? WHERE token=?";
	private static final String SELECT_BY_TOKEN ="SELECT * FROM TOKEN_PASSWORD WHERE token = ?";
	@Override
	public TokenPassword insert(TokenPassword tokenPassword) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, tokenPassword.getNoUtilisateur());
            preparedStatement.setString(2, tokenPassword.getToken());
            preparedStatement.setObject(3, tokenPassword.getDateCreation());
            preparedStatement.setObject(4, tokenPassword.getDateExpiration());

			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				return TokenPassword.builder(tokenPassword).setNoToken(resultSet.getInt(1)).build();
			}
            throw new RuntimeException("Erreur de serialisation de l'article.");

		} catch (SQLException e) {
			throw new RuntimeException("Echec d'insert de l'article : " + e.getMessage());
		}
	}

	@Override
	public TokenPassword getByToken(String token) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_TOKEN);
				pstmt.setString(1, token);
				ResultSet resultSet = pstmt.executeQuery();

				if (resultSet.next()) {
					int noUtilisateur = resultSet.getInt("no_utilisateur");
					int noToken = resultSet.getInt("no_token");
					LocalDateTime dateCreation = resultSet.getObject("date_creation", LocalDateTime.class);
					LocalDateTime dateExpiration = resultSet.getObject("date_expiration", LocalDateTime.class);
					return new TokenPassword.Builder()
							.setNoToken(noToken)
							.setNoUtilisateur(noUtilisateur)
							.setDateCreation(dateCreation)
							.setDateExpiration(dateExpiration)
							.setToken(token)
							.build();
				}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException("Erreur lors de la recherche du tokenPassword par token.", e);
		}

	}

	@Override
	public void setUsedToken(String token) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try (PreparedStatement pstmt = cnx.prepareStatement(UPDATE_TOKEN_USED)) {
				pstmt.setBoolean(1, true);
				pstmt.setString(2, token);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erreur lors de la mise à jour de l'utilisateur.", e);
		}
	}
}
