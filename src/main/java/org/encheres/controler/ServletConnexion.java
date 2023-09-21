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

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		
		System.out.println("Identifiant : " + identifiant);
		System.out.println("Mot de passe : " + motDePasse);

		// Logique de traitement de la connexion
		Utilisateur utilisateur = utilisateurManager.verifierConnexion(identifiant, motDePasse);


	    if (utilisateur != null && utilisateur.getNoUtilisateur() > 0) {
	        // L'utilisateur est connecté, ses informations sont stockées dans une session
	        request.getSession().setAttribute("utilisateurConnecte", true);
	        request.setAttribute("utilisateur", utilisateur);
	        request.setAttribute("confirmation", "Connexion réussie. Bienvenue !");

	        this.getServletContext().getRequestDispatcher("/profilUtilisateur.jsp").forward(request, response);
	       
	    } else {
	    	System.out.println(utilisateur);
	        // Les informations d'identification sont incorrectes avec un message d'erreur
	        request.setAttribute("erreur", "mot de passe ou email incorrect");
	        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
	    }
	}


}
