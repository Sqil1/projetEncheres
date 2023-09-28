package org.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.RequestContext;
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


		if (utilisateur != null && utilisateur.getNoUtilisateur() != null && utilisateur.getNoUtilisateur() > 0) {
		    // L'utilisateur est connecté, ses informations sont stockées dans une session
		
			 HttpSession session = request.getSession();
			 session.setAttribute("utilisateurSession", utilisateur);
			 session.setAttribute("connexionReussie", "Connexion réussie en tant que " + utilisateur.getPseudo());
			     
			Integer noUtilisateur = utilisateur.getNoUtilisateur();
		    request.getSession().setAttribute("utilisateurConnecte", true);
		    request.getSession().setAttribute("utilisateur", utilisateur);
		    request.getSession().setAttribute("motDePasse", motDePasse);
		    request.getSession().setAttribute("noUtilisateur", noUtilisateur);
		    
		   	response.sendRedirect(request.getContextPath()+"/Index");
		    
		} else {
		    // Les informations d'identification sont incorrectes avec un message d'erreur
		    request.setAttribute("erreur", "mot de passe ou email incorrect");
		    this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		}
	}


}
