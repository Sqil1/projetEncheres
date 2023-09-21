package org.encheres.bo;

public class Categorie {
	private Integer noCategorie;
	private String libelle;

	public Categorie() {
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		if (noCategorie == null) {
			throw new IllegalStateException("noCategorie ne peut pas être null");
		}
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		if (libelle == null) {
			throw new IllegalStateException("libelle ne peut pas être null");
		}
		this.libelle = libelle;
	}
}
