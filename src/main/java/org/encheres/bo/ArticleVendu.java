package org.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
    private Integer noArticle;
    private String nomArticle;
    private String description;
    private LocalDate dateDebutEncheres;
    private LocalDate dateFinEncheres;
    private Integer prixInitial;
    private Integer prixVente;
    private String etatVente;

    public ArticleVendu() {}

    public Integer getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(Integer noArticle) {
        if (noArticle == null) {
            throw new IllegalStateException("noArticle ne peut pas être null");
        }
        this.noArticle = noArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        if (nomArticle == null) {
            throw new IllegalStateException("nomArticle ne peut pas être null");
        }
        this.nomArticle = nomArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalStateException("description ne peut pas être null");
        }
        this.description = description;
    }

    public LocalDate getDateDebutEncheres() {
        return dateDebutEncheres;
    }

    public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
        this.dateDebutEncheres = dateDebutEncheres;
    }

    public LocalDate getDateFinEncheres() {
        return dateFinEncheres;
    }

    public void setDateFinEncheres(LocalDate dateFinEncheres) {
        this.dateFinEncheres = dateFinEncheres;
    }

    public Integer getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(Integer prixInitial) {
        this.prixInitial = prixInitial;
    }

    public Integer getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Integer prixVente) {
        this.prixVente = prixVente;
    }

    public String getEtatVente() {
        return etatVente;
    }

    public void setEtatVente(String etatVente) {
        if (etatVente == null) {
            throw new IllegalStateException("etatVente ne peut pas être null");
        }
        this.etatVente = etatVente;
    }
}
