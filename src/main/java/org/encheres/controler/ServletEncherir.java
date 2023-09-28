package org.encheres.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.encheres.bll.UtilisateurManager;
import org.encheres.bll.UtilisateurManagerImpl;
import org.encheres.bll.ArticleVendu.ArticleVenduManager;
import org.encheres.bll.ArticleVendu.ArticleVenduManagerImpl;
import org.encheres.bll.Enchere.EnchereManager;
import org.encheres.bll.Enchere.EnchereManagerImpl;
import org.encheres.bo.Enchere;
import org.encheres.bo.Utilisateur;
import org.encheres.dal.Enchere.EnchereDAO;
import org.encheres.errors.DatabaseException;
import org.encheres.dal.DAOFactory;
import org.encheres.dal.UtilisateurDAO;

@WebServlet("/Encherir")
public class ServletEncherir extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnchereManager enchereManager = EnchereManagerImpl.getInstance();
    private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

    private EnchereDAO enchereDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int enchereId = Integer.parseInt(request.getParameter("articleId"));
            int montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));
            int utilisateurIdMeilleureOffre = enchereManager.getUtilisateurIdMeilleureOffre(enchereId);
            Utilisateur utilisateurMeilleureOffre = utilisateurManager.getUtilisateurParNoUtilisateur(utilisateurIdMeilleureOffre);
            try {
                boolean enchereValide = enchereManager.verifierEnchereValide(utilisateurIdMeilleureOffre,
                        montantEnchere);

                if (enchereValide) {
                   
                    Enchere enchere = new Enchere();
                    enchere.setNoUtilisateur(utilisateurIdMeilleureOffre); 
                    enchere.setNoArticle(enchereId);
                    enchere.setMontantEnchere(montantEnchere);

                    try {
                        enchereManager.creerEnchere(enchere);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enchère créée avec succès.");
                    response.sendRedirect("detailVente.jsp?id=" + enchereId);
                } else {
                    request.setAttribute("erreurEnchere",
                            "L'enchère n'est pas valide. Vérifiez votre crédit.");
                    System.out.println("Enchère n'est pas créée.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException | DatabaseException e) {
            e.printStackTrace();
        }
    }
}