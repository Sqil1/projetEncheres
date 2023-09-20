package org.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Affichage la page d'inscription 
        this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // R�cup�ration des param�tres 
        String pseudo = request.getParameter("pseudo");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String ville = request.getParameter("ville");
        String codePostal = request.getParameter("codePostal");
        String motDePasse = request.getParameter("motDePasse");
        String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");
        
        // Logique de traitement de l'inscription
        UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
        
        // il faudrait peut etre deplacer tous ces test or de la servlet pour bien s�parer les metiers
        // Test si  le pseudo ou l'email existe d�j�, 
        boolean pseudoExiste = utilisateurManager.estPseudoExistant(pseudo);
        boolean emailExiste = utilisateurManager.estEmailExistant(email);
        if (pseudoExiste || emailExiste) {
            // Le pseudo ou l'email existe d�j�,  message d'erreur
            String messageErreur = "";
            if (pseudoExiste) {
                messageErreur += "Le pseudo existe d�j�. ";
            }
            if (emailExiste) {
                messageErreur += "L'email existe d�j�.";
            }
            request.setAttribute("erreurInscription", messageErreur);
        }else {
        	 // Test de la validit� du mdp
        	boolean verif = utilisateurManager.verifMotDePasse(motDePasse, confirmerMotDePasse);

        	if (verif) {
        		//Test si l'utilisateur est d�j� inscrit en dans la base de donn�es 
        		boolean utilisateurExistant = utilisateurManager.estUtilisateurExistant(email);
        		if (utilisateurExistant) {
                // L'utilisateur est d�j� inscrit, message d'erreur
                request.setAttribute("erreurInscription",
                        "Cet utilisateur existe d�j�. Veuillez vous connecter.");
            } else {
            	 // Cr�ation d'un nouvel utilisateur avec les donn�es fournies
            	 Utilisateur utilisateur = new Utilisateur(pseudo, prenom, nom, email, telephone, rue, ville, codePostal, motDePasse, 0);
                 utilisateur = utilisateurManager.creerUtilisateur(utilisateur);
                 request.setAttribute("utilisateur", utilisateur);
                 request.setAttribute("messageConfirmation", "Inscription r�ussie. Vous �tes maintenant connect�.");
               this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request,response);
            }
            	// L'inscription a �chou�
        } else {
            request.setAttribute("erreurMdp", "L'inscription a �chou�");
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
        }
    }

}
}
