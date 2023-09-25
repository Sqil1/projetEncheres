package org.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.encheres.bo.Utilisateur;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email = ? AND mot_de_passe = ?";
	private static final String SELECT_UTILISATEUR_BY_NO_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String UPDATE_UTILISATEUR = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
	private static final  String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	

	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getPrenom());
			pstmt.setString(3, utilisateur.getNom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getVille());
			pstmt.setString(8, utilisateur.getCodePostal());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.getAdministrateur());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				return Utilisateur.builder(utilisateur).setNoUtilisateur(rs.getInt(1)).build();
			}
			throw new RuntimeException("Erreur lors de la création de l'utilisateur");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Utilisateur verifierConnexion(String identifiant, String motDePasse) {
	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        
	    	String[] sqlQueries = { SELECT_BY_PSEUDO, SELECT_BY_EMAIL };
	    	  
	    	for (String sql : sqlQueries) {
	    		PreparedStatement pstmt = cnx.prepareStatement(sql);
	            pstmt.setString(1, identifiant);
	            pstmt.setString(2, motDePasse);
	            ResultSet resultSet = pstmt.executeQuery();
	    	
		     if (resultSet.next()) {
		            int noUtilisateur = resultSet.getInt("no_utilisateur");
		            String pseudo = resultSet.getString("pseudo");
		            String nom = resultSet.getString("nom");
		            String prenom = resultSet.getString("prenom");
		            String email = resultSet.getString("email");
		            String telephone = resultSet.getString("telephone");
		            String rue = resultSet.getString("rue");
		            String codePostal = resultSet.getString("code_postal");
		            String ville = resultSet.getString("ville");
		            String motDePasseBDD = resultSet.getString("mot_de_passe");
		            int credit = resultSet.getInt("credit");
		            boolean administrateur = resultSet.getBoolean("administrateur");

		            return new Utilisateur.Builder(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasseBDD, credit, administrateur)
		                    .setNoUtilisateur(noUtilisateur)
		                    .build();
		     }
		     
			}
			return null; 
	    } catch (SQLException e) {
	        throw new RuntimeException("Erreur lors de la recherche de l'utilisateur par identifiant.", e);
	    }

	}
	
	@Override
	public Utilisateur getUtilisateurParNoUtilisateur(Integer noUtilisateur) {
	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_NO_UTILISATEUR);
	        pstmt.setInt(1, noUtilisateur);
	        ResultSet resultSet = pstmt.executeQuery();

	        if (resultSet.next()) {
	            String pseudo = resultSet.getString("pseudo");
	            String nom = resultSet.getString("nom");
	            String prenom = resultSet.getString("prenom");
	            String email = resultSet.getString("email");
	            String telephone = resultSet.getString("telephone");
	            String rue = resultSet.getString("rue");
	            String codePostal = resultSet.getString("code_postal");
	            String ville = resultSet.getString("ville");
	          
	            return new Utilisateur.Builder(pseudo, nom, prenom, email, telephone, rue, codePostal, ville)
	                    .setNoUtilisateur(noUtilisateur)
	                    .build();
	        }

	        return null; // Aucun utilisateur trouvé avec l'ID spécifié
	    } catch (SQLException e) {
	        throw new RuntimeException("Erreur lors de la récupération des informations de l'utilisateur par ID.", e);
	    }
	}
	
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
	    try (Connection cnx = ConnectionProvider.getConnection()) {
	       
	        
	        try (PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR)) {
	            pstmt.setString(1, utilisateur.getPseudo());
	            pstmt.setString(2, utilisateur.getNom());
	            pstmt.setString(3, utilisateur.getPrenom());
	            pstmt.setString(4, utilisateur.getEmail());
	            pstmt.setString(5, utilisateur.getTelephone());
	            pstmt.setString(6, utilisateur.getRue());
	            pstmt.setString(7, utilisateur.getCodePostal());
	            pstmt.setString(8, utilisateur.getVille());
	            pstmt.setString(9, utilisateur.getMotDePasse());
	            pstmt.setInt(10, utilisateur.getNoUtilisateur()); 

	            pstmt.executeUpdate();
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erreur lors de la mise à jour de l'utilisateur.", e);
	    }
	}
	
	@Override
	public boolean deleteUtilisateur(Integer noUtilisateur) {
	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        try (PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR)) {
	            pstmt.setInt(1, noUtilisateur);
	            int rowCount = pstmt.executeUpdate();
	            if (rowCount > 0) {
	                return true;
	            }
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erreur lors de la suppression de l'utilisateur.", e);
	    }
	    return false;
	}


}
