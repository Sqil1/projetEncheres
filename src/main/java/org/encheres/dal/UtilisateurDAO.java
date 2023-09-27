package org.encheres.dal;

import org.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur creerUtilisateur(Utilisateur utilisateur);

	Utilisateur getUtilisateurParNoUtilisateur(Integer noUtilisateur);

	Utilisateur verifierConnexion(String identifiant);
	
	void updateUtilisateur(Utilisateur utilisateur);

	boolean deleteUtilisateur(Integer noUtilisateur);


	

}
