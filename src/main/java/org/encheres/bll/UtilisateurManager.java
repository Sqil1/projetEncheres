package org.encheres.bll;

import org.encheres.bo.Utilisateur;

public interface UtilisateurManager {

	boolean verifMotDePasse(String motDePasse, String confirmation);

	Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String ville, String codePostal, String motDePasse, Integer credit, boolean administrateur);

	Utilisateur verifierConnexion(String identifiant, String motDePasse);

	Utilisateur InformationsUtilisateurByNoUtilisateur(Integer noUtilisateur);
	
	void updateUtilisateur(Utilisateur utilisateur);

	boolean deleteUtilisateur(Integer noUtilisateur);

	Utilisateur getUtilisateurParNoUtilisateur(int utilisateurIdMeilleureOffre);

}
