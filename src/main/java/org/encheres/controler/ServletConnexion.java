package org.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// R�cup�ration des param�tres du formulaire
        String identifiant = request.getParameter("identifiant");
        String motDePasse = request.getParameter("motDePasse");
        
        // Logique de traitement de la connexion
        Utilisateur utilisateur = utilisateurManager.verifierConnexion(identifiant, motDePasse);
		
 		if(utilisateur.getId() > 0) {
 		// L'utilisateur est connect�, stockez ses informations dans une session
 			request.getSession().setAttribute("utilisateurConnecte", true); 
 			request.setAttribute("utilisateur", utilisateur);
 			request.setAttribute("confirmation", "Connexion r�ussie. Bienvenue !");
    
 		// Redirection vers la page d'accueil
 			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
 		} else {
 		// Les informations d'identification sont incorrectes, redirigez l'utilisateur avec un message d'erreur
 			request.setAttribute("erreur", "mot de passe ou email incorrect");
 			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
 		}
        
	}

}
