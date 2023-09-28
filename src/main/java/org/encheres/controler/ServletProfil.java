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


@WebServlet("/Profil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String noUtilisateurStr = request.getParameter("noUtilisateur");
		  
		  Integer noUtilisateur = Integer.parseInt(noUtilisateurStr);

          // Utilisez le noUtilisateur pour récupérer les informations de l'utilisateur depuis la source de données
          Utilisateur utilisateur = utilisateurManager.InformationsUtilisateurByNoUtilisateur(noUtilisateur);
		
		 if (utilisateur != null) {
             // Placez l'objet utilisateur dans la requête pour le rendre disponible dans la JSP
             request.setAttribute("utilisateur", utilisateur);
             request.getRequestDispatcher("/profilUtilisateur.jsp").forward(request, response);
         } else {

             response.getWriter().println("Utilisateur non trouvé");
         }
		 request.setAttribute("utilisateur", utilisateur);

	        // Redirigez vers la page JSP qui affichera le profil de l'utilisateur
	       	request.getRequestDispatcher("/profilUtilisateur.jsp").forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
