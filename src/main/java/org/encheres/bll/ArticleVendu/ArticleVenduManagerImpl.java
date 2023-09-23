package org.encheres.bll.ArticleVendu;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.encheres.bo.ArticleVendu;
import org.encheres.bo.Categorie;
import org.encheres.bo.Utilisateur;
import org.encheres.dal.DAOFactory;
import org.encheres.errors.DatabaseException;

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
    public ArticleVendu createArticleVendu(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        ArticleVendu.EtatVente etatVente,
        Integer noUtilisateur,
        Integer noCategorie
    ) throws DatabaseException {
        // TODO HACK correct version quand UtilisateurManager.selectById() est implémenté:
        //Utilisateur utilisateur = utilisateurManager.selectById(noUtilisateur);
        Utilisateur utilisateur = new Utilisateur.Builder().build(); // temp mockup

        // TODO HACK correct version quand CategorieManager.selectById() est implémenté:
        // Categorie categorie = categorieManager.selectById(noCategorie);
        Categorie categorie = new Categorie(); // temp mockup

        final ArticleVendu articleVendu = new ArticleVendu.Builder(
            nomArticle,
            description,
            dateDebutEncheres,
            dateFinEncheres,
            prixInitial,
            prixVente,
            etatVente,
            utilisateur,
            categorie
        ).build();

        return DAOFactory.getArticleVenduDAO().insert(articleVendu);
    }

    @Override
    public boolean isValid(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial
    ) {
        boolean result =    
            isValidNomArticle(nomArticle) ||
            isValidDescription(description) ||
            isValidDateDebutEncheres(dateDebutEncheres) ||
            isValidDateFinEncheres(dateDebutEncheres, dateFinEncheres) ||
            isValidPrixInitial(prixInitial);

        return result;
    }

    public boolean isValidNomArticle(String nomArticle) {
        boolean result = true;
        Pattern pattern = Pattern.compile("^(?=.{5,30}$)(?!.*[<>%]).*([\\p{L}'\"/]{1}\\s*){5,}.*$");
        Matcher matcher = pattern.matcher(nomArticle);

        if (!matcher.matches()) {
            result = false;
            System.out.println("Erreur de format: nomArticle");
        }

        return result;
    }

    public boolean isValidDescription(String description) {
        boolean result = true;
        Pattern pattern = Pattern.compile("^(?=.{5,300}$)(?!.*[<>%]).*([\\p{L}'\"/]{1}\\s*){5,}.*$");
        Matcher matcher = pattern.matcher(description);

        if (!matcher.matches()) {
            result = false;
            System.out.println("Erreur de format: description");
        }

        return result;
    }

    public boolean isValidDateDebutEncheres(LocalDateTime dateDebutEncheres) {
        boolean result = true;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime twoMinutesBefore = now.minusMinutes(2);
        LocalDateTime oneWeekAfter = now.plusWeeks(1);

        if (dateDebutEncheres.isBefore(twoMinutesBefore) || dateDebutEncheres.isAfter(oneWeekAfter)) {
            result = false;
            System.out.println(
                "Erreur, dateDebutEncheres est avant ou après le temps alloué (2minutes < temps alloué < 1semaine)."
            );
        }

        return result;
    }

    public boolean isValidDateFinEncheres(LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres) {
        boolean result = true;
        LocalDateTime oneHourAfterStart = dateDebutEncheres.plusHours(1);
        LocalDateTime oneYearAfterStart = dateDebutEncheres.plusWeeks(52);

        if (dateFinEncheres.isBefore(oneHourAfterStart) ||dateDebutEncheres.isAfter(oneYearAfterStart)) {
            result = false;
            System.out.println(
                "Erreur, dateFinEncheres est avant ou après le temps alloué (date de début + 1heure < temps alloué < 1an après)."
            );
        }

        return result;
    }

    public boolean isValidPrixInitial(Integer prixInitial) {
        boolean result = true;

        if (prixInitial < 0 || prixInitial > 100_000_000) {
            result = false;
            System.out.println(
                "Erreur, prixInitial doit être entre 0 et 100 000 000 comprit."
            );
        }

        return result;
    }

    public boolean isValidPrixVente(Integer prixVente) {
        boolean result = true;

        if (prixVente < 1 || prixVente > 100_000_000) {
            result = false;
            System.out.println(
                "Erreur, prixInitial doit être entre 1 et 100 000 000 comprit."
            );
        }

        return result;
    }
}
