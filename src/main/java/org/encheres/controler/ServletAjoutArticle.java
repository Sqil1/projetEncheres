package org.encheres.controler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.encheres.bll.ArticleVendu.ArticleVenduManager;
import org.encheres.bll.ArticleVendu.ArticleVenduManagerImpl;
import org.encheres.bo.ArticleVendu;
import org.encheres.bo.dto.ArticleVenduUserInputDTO;
import org.encheres.errors.DatabaseException;

@WebServlet("/AjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDate localDatePlusOneWeek = localDate.plusDays(7);

        int dayNow = localDate.getDayOfMonth();
        String monthNow = String.format("%02d", localDate.getMonthValue());
        int yearNow = localDate.getYear();
        String hoursNow = String.format("%02d", localTime.getHour());
        String minutesNow = String.format("%02d", localTime.getMinute());

        int dayPlusOneWeek = localDatePlusOneWeek.getDayOfMonth();
        String monthPlusOneWeek = String.format("%02d", localDatePlusOneWeek.getMonthValue());
        int yearPlusOneWeek = localDatePlusOneWeek.getYear();

        request.setAttribute("dateNow", yearNow + "-" + monthNow + "-" + dayNow);
        request.setAttribute("datePlusOneWeek", yearPlusOneWeek + "-" + monthPlusOneWeek + "-" + dayPlusOneWeek);
        request.setAttribute("hoursNow", hoursNow);
        request.setAttribute("minutesNow", minutesNow);

        this.getServletContext().getRequestDispatcher("/ajout-article.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO HACK waiting on the session feature -> fetch the session/user
        Integer noUtilisateur = 1;
        // TODO HACK waiting on categorie feature -> fetch Categories DB put in a from <select>
        Integer noCategorie = 1;

        ArticleVenduManager articleVenduManager = ArticleVenduManagerImpl.getInstance();

        // User inputs
        ArticleVenduUserInputDTO articleVenduUserInputDTO = new ArticleVenduUserInputDTO(
            request.getParameter("nomArticle"),
            request.getParameter("description"),
            request.getParameter("dateDebutEncheres_date"),
            request.getParameter("dateDebutEncheres_time"),
            request.getParameter("dateFinEncheres_date"),
            request.getParameter("dateFinEncheres_time"),
            request.getParameter("prixInitial")
        );

        
        // TODO Fine grained data validation to extract what's wrong
        boolean isValid = articleVenduManager.isValid(
            nomArticle,
            description,
            dateDebutEncheres,
            dateFinEncheres,
            prixInitial
            );
            
            if (isValid) {
                try {
                    // TODO Default values
                    Integer prixVente = -1;
                    ArticleVendu.EtatVente etatVente = ArticleVendu.EtatVente.EN_COURS;
                    ArticleVendu createdArticle = articleVenduManager.createArticleVendu(
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

                request.setAttribute("message", "<p>L'article a correctement été ajouté.<p>" + createdArticle.toString());
                request.setAttribute("articleBootstrapClass", "bg-success");

            } catch (DatabaseException e) {
                // TODO Err handling from servlet for data validation
                e.printStackTrace();
            }
        } else {
            request.setAttribute("message", "Erreur de validité des données");
            request.setAttribute("articleBootstrapClass", "bg-danger");
        }

        doGet(request, response);
    }
}
