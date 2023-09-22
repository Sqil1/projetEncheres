package org.encheres.bo;

import java.time.LocalDate;

public class Enchere {
	private LocalDate dateEnchere;
	private Integer montantEnchere;

	public Enchere() {
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
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
}
