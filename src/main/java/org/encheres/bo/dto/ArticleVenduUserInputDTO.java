package org.encheres.bo.dto;

public class ArticleVenduUserInputDTO {
    private String nomArticle;
    private String description;
    private String dateDebutEncheresLocalDate;
    private String dateDebutEncheresLocalTime;
    private String dateFinEncheresLocalDate;
    private String dateFinEncheresLocalTime;
    private String prixInitial;

    public ArticleVenduUserInputDTO(
        String nomArticle,
        String description,
        String dateDebutEncheresLocalDate,
        String dateDebutEncheresLocalTime,
        String dateFinEncheresLocalDate,
        String dateFinEncheresLocalTime,
        String prixInitial
    ) {
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheresLocalDate = dateDebutEncheresLocalDate;
        this.dateDebutEncheresLocalTime = dateDebutEncheresLocalTime;
        this.dateFinEncheresLocalDate = dateFinEncheresLocalDate;
        this.dateFinEncheresLocalTime = dateFinEncheresLocalTime;
        this.prixInitial = prixInitial;
    }

    public String getNomArticle() {
        return nomArticle;
    }
    public String getDescription() {
        return description;
    }
    public String getDateDebutEncheresLocalDate() {
        return dateDebutEncheresLocalDate;
    }
    public String getDateDebutEncheresLocalTime() {
        return dateDebutEncheresLocalTime;
    }
    public String getDateFinEncheresLocalDate() {
        return dateFinEncheresLocalDate;
    }
    public String getDateFinEncheresLocalTime() {
        return dateFinEncheresLocalTime;
    }
    public String getPrixInitial() {
        return prixInitial;
    }
}
