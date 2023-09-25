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
import org.encheres.bo.Categorie;
import org.encheres.bo.Utilisateur;
import org.encheres.bo.dto.ArticleVenduUserInputDTO;
import org.encheres.errors.DatabaseException;
import org.encheres.errors.ParsingException;

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

        String dayPlusOneWeek = String.format("%02d", localDatePlusOneWeek.getDayOfMonth());
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
        String message = new String();
        // TODO HACK waiting on the session feature -> fetch the session/user
        Utilisateur utilisateur = Utilisateur.builder().setNoUtilisateur(1).build();
        // TODO HACK waiting on categorie feature -> fetch Categories DB put in a from <select>
        Categorie categorie = new Categorie();
        categorie.setNoCategorie(1);

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
        ArticleVendu newArticle = ArticleVendu.builder().setDefault().build();
        try {
            newArticle = articleVenduManager.parse(articleVenduUserInputDTO);
        } catch (ParsingException e) {
            e.printStackTrace();
            message += "<p>Erreur du format des données envoyées</p>";
            request.setAttribute("articleBootstrapClass", "bg-danger");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        boolean isValid = articleVenduManager.isValid(newArticle);

        if (isValid) {
            try {
                newArticle = articleVenduManager.insertArticleVendu(
                    newArticle.getNomArticle(),
                    newArticle.getDescription(),
                    newArticle.getDateDebutEncheres(),
                    newArticle.getDateFinEncheres(),
                    newArticle.getPrixInitial(),
                    newArticle.getEtatVente(),
                    utilisateur,
                    categorie
                );

            message += "<p>L'article a correctement été ajouté.</p>" + newArticle.toString();
            request.setAttribute("articleBootstrapClass", "bg-success");

            } catch (DatabaseException e) {
                e.printStackTrace();
                message += "<p>Erreur de validité des données envoyées</p>";
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                request.setAttribute("articleBootstrapClass", "bg-danger");
            }
        }

        request.setAttribute("message", message);
        doGet(request, response);
    }
}
