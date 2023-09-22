package org.encheres.bll;

import org.encheres.bo.Utilisateur;
import org.encheres.dal.DAOFactory;

public class UtilisateurManagerImpl implements UtilisateurManager {

	private static UtilisateurManager utilisateurManager = null;

	public static UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			synchronized (UtilisateurManagerImpl.class) {
				if (utilisateurManager == null) {
					utilisateurManager = new UtilisateurManagerImpl();
				}
			}
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
		final Utilisateur utilisateur = new Utilisateur.Builder(pseudo, nom, prenom, email, telephone, rue, ville,
				codePostal, motDePasse, credit, administrateur).build();
		return DAOFactory.getUtilisateurDAO().creerUtilisateur(utilisateur);
	}

	public Utilisateur verifierConnexion(String identifiant, String motDePasse) {
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().verifierConnexion(identifiant, motDePasse);

		if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
			// Les identifiants et le mot de passe correspondent, la connexion ok
			return utilisateur;
		} else {
			// Les identifiants ou le mot de passe ne correspondent pas,
			return null;
		}
	}
	
	public Utilisateur InformationsUtilisateurByNoUtilisateur(Integer noUtilisateur) {
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().getUtilisateurParNoUtilisateur(noUtilisateur);
		return utilisateur;
		
	}

}