package org.encheres.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.encheres.bll.UtilisateurManager;
import org.encheres.bll.UtilisateurManagerImpl;
import org.encheres.bo.Utilisateur;

@WebServlet("/Inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int creditDefaut = 100;
		Boolean administrationDefaut = false;

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");

		boolean verif = utilisateurManager.verifMotDePasse(motDePasse, confirmation);

		if (verif) {

			Utilisateur utilisateur = utilisateurManager.creerUtilisateur(pseudo, nom, prenom, email, telephone, rue,
					ville, codePostal, motDePasse, creditDefaut, administrationDefaut);
			request.setAttribute("utilisateur", utilisateur);
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			

		} else {
			request.setAttribute("erreurMdp", "Erreur sur le mot de passe et sa confirmation");
			this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);

		}

	}

}
