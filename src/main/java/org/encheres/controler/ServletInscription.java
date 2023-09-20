package org.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class ServletRepas
 */
@WebServlet("/SuiviRepasInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");		
		String ville = request.getParameter("email");
		String codePostal = request.getParameter("codepostal");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");

	//	boolean verif = utilisateurManager.verifMotDePasse(motDePasse, confirmerMotDePasse);

//		if (verif) {
//			
//			Utilisateur utilisateur = utilisateurManager.creerUtilisateur(nom, prenom, motDePasse, dateNaissance, taille, poid, mail, LocalDate.now());
//			request.setAttribute("utilisateur", utilisateur);
//			this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
//				
//		} else {
//			request.setAttribute("erreurMdp", "Erreur sur le mot de passe et sa confirmation");
//			this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
//		}
		


	}
	
}
	


