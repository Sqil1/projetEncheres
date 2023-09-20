package org.encheres.bll;

import org.encheres.bo.Utilisateur;
import org.encheres.dal.DAOFactory;

public class UtilisateurManagerImpl implements UtilisateurManager {

	private static UtilisateurManager utilisateurManager = null;

	public static UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManagerImpl();
		}
		return utilisateurManager;
	}



	public boolean verifMotDePasse(String motDePasse, String confirmation) {
		if (motDePasse.equals(confirmation)) {
			return true;
		}
		return false;
	}

	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String ville, String codePostal, String motDePasse, Integer credit, boolean administrateur) {
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, ville, codePostal,
				motDePasse, credit, administrateur);
		DAOFactory.getUtilisateurDAO().creerUtilisateur(utilisateur);
		return utilisateur;
	}

}