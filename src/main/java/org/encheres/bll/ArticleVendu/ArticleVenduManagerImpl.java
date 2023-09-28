package org.encheres.bll.ArticleVendu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Pattern;

import org.encheres.bo.ArticleVendu;
import org.encheres.bo.Categorie;
import org.encheres.bo.DefaultValue;
import org.encheres.bo.Utilisateur;
import org.encheres.bo.dto.ArticleVenduUserInputDTO;
import org.encheres.dal.DAOFactory;
import org.encheres.errors.DatabaseException;
import org.encheres.errors.ParsingException;

public class ArticleVenduManagerImpl implements ArticleVenduManager {
    private static ArticleVenduManager articleVenduManager = null;

    public static ArticleVenduManager getInstance() {
        if (articleVenduManager == null) {
            synchronized (ArticleVenduManagerImpl.class) {
                if (articleVenduManager == null) {
                    articleVenduManager = new ArticleVenduManagerImpl();
                }
            }
        }

        return articleVenduManager;
    }

    @Override
    public ArticleVendu insertArticleVendu(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        ArticleVendu.EtatVente etatVente,
        Utilisateur utilisateur,
        Categorie categorie
    ) throws DatabaseException {
        final ArticleVendu articleVendu = ArticleVendu.builder(
            nomArticle,
            description,
            dateDebutEncheres,
            dateFinEncheres,
            prixInitial,
            etatVente,
            utilisateur,
            categorie
        ).build();

        return DAOFactory.getArticleVenduDAO().insert(articleVendu);
    }

    @Override
    public ArticleVendu parse(ArticleVenduUserInputDTO articleVenduUserInputDTO)
        throws ParsingException
    {
        String nomArticle;
        String description;
        Integer prixInitial;
        LocalDate dateDebutEncheresLocalDate;
        LocalTime dateDebutEncheresLocalTime;
        LocalDateTime dateDebutEncheres;
        LocalDate dateFinEncheresLocalDate;
        LocalTime dateFinEncheresLocalTime;
        LocalDateTime dateFinEncheres;

        try {
            nomArticle = articleVenduUserInputDTO.getNomArticle();
            description = articleVenduUserInputDTO.getDescription();
            prixInitial = Integer.valueOf(articleVenduUserInputDTO.getPrixInitial());

            dateDebutEncheresLocalDate = LocalDate.parse(articleVenduUserInputDTO.getDateDebutEncheresLocalDate());
            dateDebutEncheresLocalTime = LocalTime.parse(articleVenduUserInputDTO.getDateDebutEncheresLocalTime());
            dateDebutEncheres = LocalDateTime.of(dateDebutEncheresLocalDate, dateDebutEncheresLocalTime);
    
            dateFinEncheresLocalDate = LocalDate.parse(articleVenduUserInputDTO.getDateFinEncheresLocalDate());
            dateFinEncheresLocalTime = LocalTime.parse(articleVenduUserInputDTO.getDateFinEncheresLocalTime());
            dateFinEncheres = LocalDateTime.of(dateFinEncheresLocalDate, dateFinEncheresLocalTime);
        } catch (Exception e) {
            throw new ParsingException("Erreur de format des données insérées.");
        }

        ArticleVendu result =
            ArticleVendu.builder()
            .setNomArticle(nomArticle)
            .setDescription(description)
            .setDateDebutEncheres(dateDebutEncheres)
            .setDateFinEncheres(dateFinEncheres)
            .setPrixInitial(prixInitial)
            .setDefault()
            .build();

        return result;
    }

    @Override
    public boolean isValid(ArticleVendu articleVendu) {
        if (
            !isValidNomArticle(articleVendu.getNomArticle()) ||
            !isValidDescription(articleVendu.getDescription()) ||
            !isValidDateDebutEncheres(articleVendu.getDateDebutEncheres()) ||
            !isValidDateFinEncheres(articleVendu.getDateDebutEncheres(), articleVendu.getDateFinEncheres()) ||
            !isValidPrixInitial(articleVendu.getPrixInitial())
        ) {
            return false;
        }

        return true;
    }

    public boolean isValidNomArticle(String nomArticle) {
        // Regex text permissif block html injection.
        Pattern pattern = Pattern.compile(
            "^(?=.{" +
            DefaultValue.NOM_ARTICLE_MIN_CHAR +
            "," +
            DefaultValue.NOM_ARTICLE_MAX_CHAR +
            "}$)(?!.*[<>%]).*([\\p{L}'\"/]{1}\\s*){" +
            DefaultValue.NOM_ARTICLE_MIN_CHAR +
            ",}.*$"
        );

        if (nomArticle == null || nomArticle.isEmpty() || !pattern.matcher(nomArticle).matches()) {
            return false;
        }

        return true;
    }

    public boolean isValidDescription(String description) {
        // Regex text permissif block html injection.
        Pattern pattern = Pattern.compile(
            "^(?=.{" +
            DefaultValue.DESCRIPTION_ARTICLE_MIN_CHAR +
            "," +
            DefaultValue.DESCRIPTION_ARTICLE_MAX_CHAR +
            "}$)(?!.*[<>%]).*([\\p{L}'\"/]{1}\\s*){" +
            DefaultValue.DESCRIPTION_ARTICLE_MIN_CHAR +
            ",}.*$"
        );

        if (description == null || description.isEmpty() || !pattern.matcher(description).matches()) {
            return false;
        }

        return true;
    }

    public boolean isValidDateDebutEncheres(LocalDateTime dateDebutEncheres) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limitBeforeMinutes = now.minusMinutes(DefaultValue.DATE_DEBUT_ENCHERES_MIN_BEFORE_MINUTES);
        LocalDateTime limitAfterWeeks = now.plusWeeks(DefaultValue.DATE_DEBUT_ENCHERES_MAX_AFTER_WEEKS);

        if (
            dateDebutEncheres == null ||
            dateDebutEncheres.isBefore(limitBeforeMinutes) ||
            dateDebutEncheres.isAfter(limitAfterWeeks)
        ) {
            return false;
        }

        return true;
    }

    public boolean isValidDateFinEncheres(LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres) {
        LocalDateTime limitBeforeHours = dateDebutEncheres.plusHours(DefaultValue.DATE_FIN_ENCHERES_MIN_BEFORE_HOURS);
        LocalDateTime limitAfterWeeks = dateDebutEncheres.plusWeeks(DefaultValue.DATE_FIN_ENCHERES_MAX_AFTER_WEEKS);

        if (
            dateFinEncheres == null ||
            dateFinEncheres.isBefore(limitBeforeHours) ||
            dateDebutEncheres.isAfter(limitAfterWeeks)
        ) {
            return false;
        }

        return true;
    }

    public boolean isValidPrixInitial(Integer prixInitial) {
        boolean result = true;

        if (prixInitial < DefaultValue.PRIX_INITIAL_MIN || prixInitial > DefaultValue.PRIX_INITIAL_MAX) {
            result = false;
        }

        return result;
    }
    @Override
    public List<ArticleVendu> selectAll() throws DatabaseException {
        return DAOFactory.getArticleVenduDAO().selectAll();
    }
    
}
