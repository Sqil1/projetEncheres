package org.encheres.bo;

import java.time.LocalDateTime;

public class Enchere {

	private int noUtilisateur; 
	private int noArticle;
	private LocalDateTime dateEnchere;
	private Integer montantEnchere;
	private int enchereId;

	public Enchere() {
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		if (montantEnchere == null) {
			throw new IllegalStateException("montantEnchere ne peut pas être null");
		}
		this.montantEnchere = montantEnchere;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getEnchereId() {
		return enchereId;
	}

	public void setEnchereId(int enchereId) {
		this.enchereId = enchereId;
	}

}
