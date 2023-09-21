package org.encheres.bo;

import java.time.LocalDateTime;

import com.microsoft.sqlserver.jdbc.StringUtils;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private Integer prixInitial;
	private Integer prixVente;
	private String etatVente;

	public ArticleVendu(Builder builder) {
		this.noArticle = builder.noArticle;
		this.nomArticle = builder.nomArticle;
		this.description = builder.description;
		this.dateDebutEncheres = builder.dateDebutEncheres;
		this.dateFinEncheres = builder.dateFinEncheres;
		this.prixInitial = builder.prixInitial;
		this.prixVente = builder.prixVente;
		this.etatVente = builder.etatVente;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static Builder builder(ArticleVendu articleVendu) {
		return new Builder(articleVendu);
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

	public static class Builder {
		private Integer noArticle;
		private String nomArticle;
		private String description;
		private LocalDateTime dateDebutEncheres;
		private LocalDateTime dateFinEncheres;
		private Integer prixInitial;
		private Integer prixVente;
		private String etatVente;

		public Builder() {
		}

		public Builder(ArticleVendu articleVendu) {
			this.noArticle = articleVendu.noArticle;
			this.nomArticle = articleVendu.nomArticle;
			this.description = articleVendu.description;
			this.dateDebutEncheres = articleVendu.dateDebutEncheres;
			this.dateFinEncheres = articleVendu.dateFinEncheres;
			this.prixInitial = articleVendu.prixInitial;
			this.prixVente = articleVendu.prixVente;
			this.etatVente = articleVendu.etatVente;
		}

		public Builder(Integer noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
				LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, String etatVente) {
			this.noArticle = noArticle;
			this.nomArticle = nomArticle;
			this.description = description;
			this.dateDebutEncheres = dateDebutEncheres;
			this.dateFinEncheres = dateFinEncheres;
			this.prixInitial = prixInitial;
			this.prixVente = prixVente;
			this.etatVente = etatVente;
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

		public ArticleVendu build() {
			return new ArticleVendu(this);
		}
	}
}
