package org.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.encheres.bo.Utilisateur;


public class UtilisateurDAOJdbcImpl implements utilisateurDAO {
	
	private static final String INSERT_UTILISATEUR="INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) VALUES(?,?,?,?,?,?,?,?,?)";

	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {
		

		try(Connection cnx = ConnectionProvider.getConnection()){

			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			
	
		    
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getPrenom());
 			pstmt.setString(4, utilisateur.getNom());
			pstmt.setString(5, utilisateur.getEmail());
			pstmt.setString(6, utilisateur.getTelephone());
			pstmt.setString(7, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(7, utilisateur.getVille());
			pstmt.setString(7, utilisateur.getMotDePasse());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();

			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
