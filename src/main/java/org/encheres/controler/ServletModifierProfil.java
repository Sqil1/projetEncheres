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
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/ModifierProfil")
public class ServletModifierProfil extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        this.getServletContext().getRequestDispatcher("/modificationUtilisateur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utilisateur utilisateurSession = (Utilisateur) request.getSession().getAttribute("utilisateur");
       
        Utilisateur.Builder utilisateurBuilder = Utilisateur.builder();

        // Récupérez les données du formulaire de modification
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String motDePasseActuel = (String) request.getSession().getAttribute("motDePasse");
        String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
        String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");
        

        if (motDePasseActuel.equals(utilisateurSession.getMotDePasse())) {
          
            
            Integer noUtilisateur = utilisateurSession.getNoUtilisateur();

            utilisateurBuilder.setNoUtilisateur(noUtilisateur);
            utilisateurBuilder.setPseudo(pseudo);
            utilisateurBuilder.setNom(nom);
            utilisateurBuilder.setPrenom(prenom);
            utilisateurBuilder.setEmail(email);
            utilisateurBuilder.setTelephone(telephone);
            utilisateurBuilder.setRue(rue);
            utilisateurBuilder.setCodePostal(codePostal);
            utilisateurBuilder.setVille(ville);
            utilisateurBuilder.setMotDePasse(nouveauMotDePasse);
            
            Utilisateur utilisateur = utilisateurBuilder.build();

           
            utilisateurManager.updateUtilisateur(utilisateur);

            this.getServletContext().getRequestDispatcher("/profilUtilisateur.jsp").forward(request, response);
        } else {
           
            request.setAttribute("erreur", "Mot de passe actuel incorrect");
            this.getServletContext().getRequestDispatcher("/modificationUtilisateur.jsp").forward(request, response);
        }
    

    }
}
