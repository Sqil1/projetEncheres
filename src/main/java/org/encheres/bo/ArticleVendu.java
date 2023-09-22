package org.encheres.bo;

import java.time.LocalDateTime;
import java.util.Locale.Category;

import com.microsoft.sqlserver.jdbc.StringUtils;
/**
 * POJO that represents an article for sale, with various properties.
 * I uses the Builder Pattern.
 * 
 * Setters, exemple of use:
 * <pre> ArticleVendu.builder(ArticleVendu).setNoArticle(Integer).build(); </pre>
 * Constructors:
 * @see ArticleVendu#builder()
 * @see ArticleVendu#builder(ArticleVendu)
 * @see ArticleVendu#builder(String, String, LocalDateTime, LocalDateTime, Integer, Integer, String, Utilisateur, Category)
 */

public class ArticleVendu {
    private Integer noArticle;
    private String nomArticle;
    private String description;
    private LocalDateTime dateDebutEncheres;
    private LocalDateTime dateFinEncheres;
    private Integer prixInitial;
    private Integer prixVente;
    private String etatVente;
    private Utilisateur utilisateur;
    private Categorie categorie;

    private ArticleVendu(Builder builder) {
        this.noArticle = builder.noArticle;
        this.nomArticle = builder.nomArticle;
        this.description = builder.description;
        this.dateDebutEncheres = builder.dateDebutEncheres;
        this.dateFinEncheres = builder.dateFinEncheres;
        this.prixInitial = builder.prixInitial;
        this.prixVente = builder.prixVente;
        this.etatVente = builder.etatVente;
        this.utilisateur = builder.utilisateur;
        this.categorie = builder.categorie;
    }

    /**
     * Constructor. Exemple instanciation:
     * <pre>ArticleVendu articleVendu = ArticleVendu.builder().build();</pre>
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Constructor. Exemple instanciation:
     * <pre>ArticleVendu articleVendu = ArticleVendu.builder(ArticleVendu).build();</pre>
     */
    public static Builder builder(ArticleVendu articleVendu) {
        return new Builder(articleVendu);
    }

    /**
     * Constructor. Exemple instanciation:
     * <pre>ArticleVendu articleVendu = ArticleVendu.builder(
            String nomArticle,
            String description,
            LocalDateTime dateDebutEncheres,
            LocalDateTime dateFinEncheres,
            Integer prixInitial,
            Integer prixVente,
            String etatVente,
            Utilisateur utilisateur,
            Categorie categorie
        ).build();</pre>
     */
    public static Builder builder(
        String nomArticle,
        String description,
        LocalDateTime dateDebutEncheres,
        LocalDateTime dateFinEncheres,
        Integer prixInitial,
        Integer prixVente,
        String etatVente,
        Utilisateur utilisateur,
        Categorie categorie
    ) {
        return new Builder(
            nomArticle,
            description,
            dateDebutEncheres,
            dateFinEncheres,
            prixInitial,
            prixVente,
            etatVente,
            utilisateur,
            categorie
        );
    }
    
    public Integer getNoArticle() {
        return noArticle;
    }
    public String getNomArticle() {
        return nomArticle;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getDateDebutEncheres() {
        return dateDebutEncheres;
    }
    public LocalDateTime getDateFinEncheres() {
        return dateFinEncheres;
    }
    public Integer getPrixInitial() {
        return prixInitial;
    }
    public Integer getPrixVente() {
        return prixVente;
    }
    public String getEtatVente() {
        return etatVente;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public Categorie getCategorie() {
        return categorie;
    }

    public static class Builder {
        private Integer noArticle;
        private String nomArticle;
        private String description;
        private LocalDateTime dateDebutEncheres;
        private LocalDateTime dateFinEncheres;
        private Integer prixInitial;
        private Integer prixVente;
        private String etatVente;
        private Utilisateur utilisateur;
        private Categorie categorie;

        public Builder() {}

        public Builder(ArticleVendu articleVendu) {
            this.noArticle = articleVendu.noArticle;
            this.nomArticle = articleVendu.nomArticle;
            this.description = articleVendu.description;
            this.dateDebutEncheres = articleVendu.dateDebutEncheres;
            this.dateFinEncheres = articleVendu.dateFinEncheres;
            this.prixInitial = articleVendu.prixInitial;
            this.prixVente = articleVendu.prixVente;
            this.etatVente = articleVendu.etatVente;
            this.utilisateur = articleVendu.utilisateur;
            this.categorie = articleVendu.categorie;
        }

        public Builder (
            String nomArticle,
            String description,
            LocalDateTime dateDebutEncheres,
            LocalDateTime dateFinEncheres,
            Integer prixInitial,
            Integer prixVente,
            String etatVente,
            Utilisateur utilisateur,
            Categorie categorie
        ) {
            this.nomArticle = nomArticle;
            this.description = description;
            this.dateDebutEncheres = dateDebutEncheres;
            this.dateFinEncheres = dateFinEncheres;
            this.prixInitial = prixInitial;
            this.prixVente = prixVente;
            this.etatVente = etatVente;
            this.utilisateur = utilisateur;
            this.categorie = categorie;
        }

        public Builder setNoArticle(Integer noArticle) {
            if (noArticle == null) {
                throw new IllegalStateException("noArticle ne peut pas être null");
            }
            this.noArticle = noArticle;

            return this;
        }

        public Builder setNomArticle(String nomArticle) {
            if (!StringUtils.isEmpty(nomArticle)) {
                throw new IllegalStateException("nomArticle ne peut pas être null");
            }
            this.nomArticle = nomArticle;

            return this;
        }

        public Builder setDescription(String description) {
            if (!StringUtils.isEmpty(description)) {
                throw new IllegalStateException("description ne peut pas être null");
            }
            this.description = description;

            return this;
        }

        public Builder setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
            this.dateDebutEncheres = dateDebutEncheres;

            return this;
        }

        public Builder setDateFinEncheres(LocalDateTime dateFinEncheres) {
            this.dateFinEncheres = dateFinEncheres;

            return this;
        }

        public Builder setPrixInitial(Integer prixInitial) {
            this.prixInitial = prixInitial;

            return this;
        }

        public Builder setPrixVente(Integer prixVente) {
            this.prixVente = prixVente;

            return this;
        }

        public Builder setEtatVente(String etatVente) {
            if (!StringUtils.isEmpty(etatVente)) {
                throw new IllegalStateException("etatVente ne peut pas être null");
            }
            this.etatVente = etatVente;

            return this;
        }

        public Builder setUtilisateur(Utilisateur utilisateur) {
            if (utilisateur == null) {
                throw new IllegalStateException("utilisateur ne peut pas être null");
            }
            this.utilisateur = utilisateur;

            return this;
        }

        public Builder setCategorie(Categorie categorie) {
            if (categorie == null) {
                throw new IllegalStateException("categorie ne peut pas être null");
            }
            this.categorie = categorie;

            return this;
        }

        public ArticleVendu build() {
            return new ArticleVendu(this);
        }
    }
}
