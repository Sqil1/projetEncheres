package org.encheres.bll.Enchere;

import org.encheres.bo.Enchere;
import org.encheres.errors.DatabaseException;

public interface EnchereManager {
	public Enchere creerEnchere(int noUtilisateur, int noArticle, int montantEnchere) throws Exception;

	public boolean verifierEnchereValide(int utilisateurIdMeilleureOffre, int montantEnchere);

	public int getUtilisateurIdMeilleureOffre(int enchereId) throws DatabaseException;

}
