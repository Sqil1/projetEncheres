package org.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.encheres.bll.UtilisateurManager;
import org.encheres.bll.UtilisateurManagerImpl;
import org.encheres.bo.Utilisateur;

@WebServlet("/SupprimerProfil")
public class ServletSupprimerProfil extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérez l'objet Utilisateur à partir de la session
        HttpSession session = request.getSession();
        Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateurSession");
        //System.out.println("Utilisateur récupéré de la session : " + utilisateurSession);

        if (utilisateurSession != null) {
            Integer userId = utilisateurSession.getNoUtilisateur();
            boolean suppressionReussie = utilisateurManager.deleteUtilisateur(userId);

            if (suppressionReussie) {
            	 session.setAttribute("suppressionReussie", "Suppression réussie !");
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                
                //System.out.println("La suppression a échoué");
                
            }
        } else {
            // L'utilisateur n'est pas correctement authentifié, redirigez-le vers une page d'erreur ou de connexion
            response.sendRedirect(request.getContextPath() + "/connexion.jsp");
        }
    }
}


