package org.encheres.controler;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.encheres.bll.ArticleVendu.ArticleVenduManager;
import org.encheres.bll.ArticleVendu.ArticleVenduManagerImpl;
import org.encheres.bo.ArticleVendu;
import org.encheres.errors.DatabaseException;

@WebServlet("/AjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/ajout-article.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO fetch the session/user
        Integer noUtilisateur = 1;
        // TODO fetch Categories DB et proposé dans le form
        Integer noCategorie = 1;

        ArticleVenduManager articleVenduManager = ArticleVenduManagerImpl.getInstance();

        String nomArticle = request.getParameter("nomArticle");
        String description = request.getParameter("description");
        LocalDateTime dateDebutEncheres = LocalDateTime.parse(request.getParameter("dateDebutEncheres"));
        LocalDateTime dateFinEncheres = LocalDateTime.parse(request.getParameter("dateFinEncheres"));
        Integer prixInitial = Integer.valueOf(request.getParameter("prixInitial"));
        Integer prixVente = Integer.valueOf(request.getParameter("prixVente"));
        String etatVente = request.getParameter("etatVente");

        // TODO Fine grained data validation to extract what's wrong
        boolean isValid = articleVenduManager.isValid(
            nomArticle,
            description,
            dateDebutEncheres,
            dateFinEncheres,
            prixInitial,
            prixVente,
            etatVente
        );

        if (isValid) {
            try {
                ArticleVendu articleVendu = articleVenduManager.createArticleVendu(
                    nomArticle,
                    description,
                    dateDebutEncheres,
                    dateFinEncheres,
                    prixInitial,
                    prixVente,
                    etatVente,
                    noUtilisateur,
                    noCategorie
                );

                request.setAttribute("articleVendu", articleVendu);

            } catch (DatabaseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            request.setAttribute("erreurValidation", "Erreur de validité des données");
        }

        doGet(request, response);
    }
}
