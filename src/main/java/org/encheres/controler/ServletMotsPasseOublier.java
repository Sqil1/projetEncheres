package org.encheres.controler;

import org.encheres.bll.UtilisateurManager;
import org.encheres.bll.UtilisateurManagerImpl;
import org.encheres.bll.tokenPassword.TokenPasswordManager;
import org.encheres.bll.tokenPassword.TokenPasswordManagerImpl;
import org.encheres.bo.TokenPassword;
import org.encheres.bo.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/motsPasseOublier")
public class ServletMotsPasseOublier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();
	private TokenPasswordManager tokenPasswordManager = TokenPasswordManagerImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/mots-passe-oublier.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		String identifiant = request.getParameter("identifiant");
		Utilisateur utilisateur = utilisateurManager.InformationsUtilisateurByIdentifiant(identifiant);
		TokenPassword tokenPassword = tokenPasswordManager.creerTokenPassword(utilisateur.getNoUtilisateur(), UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now().plusHours(1));
		System.out.println("TOKEN URL :  http://localhost:8080/changeMotsDePasse?token="+tokenPassword);
		this.getServletContext().getRequestDispatcher("/mots-passe-oublier-send.jsp").forward(request, response);
	}


}
