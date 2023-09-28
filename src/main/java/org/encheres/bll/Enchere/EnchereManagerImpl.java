package org.encheres.bll.Enchere;

import org.encheres.bll.ArticleVendu.ArticleVenduManager;
import org.encheres.bll.ArticleVendu.ArticleVenduManagerImpl;
import org.encheres.bo.Enchere;
import org.encheres.bo.Utilisateur;
import org.encheres.dal.DAOFactory;
import org.encheres.dal.UtilisateurDAO;
import org.encheres.dal.Enchere.EnchereDAO;
import org.encheres.errors.DatabaseException;

public class EnchereManagerImpl implements EnchereManager {
    private static EnchereManager enchereManager = null;

    public static EnchereManager getInstance() {
        if (enchereManager == null) {
            synchronized (EnchereManagerImpl.class) {
                if (enchereManager == null) {
                    enchereManager = new EnchereManagerImpl();
                }
            }
        }

        return enchereManager;
    }

    public EnchereManagerImpl() {
    }
    
    @Override
    public Enchere creerEnchere(int noUtilisateur, int noArticle, int montantEnchere) throws Exception {
        /***** Utilisateur factice avec un crédit suffisant pour les tests
         * 
         * Utilisateur utilisateurMeilleureOffre = new Utilisateur.Builder()
         * .setCredit(1000) // Crédit suffisant pour les tests
         * .build();
         * 
         * if (utilisateurMeilleureOffre.getCredit() != null && utilisateurMeilleureOffre.getCredit() >= montantEnchere) {
         ******************************************************************************************/
        Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().getUtilisateurParNoUtilisateur(noUtilisateur);
        if (utilisateur != null && utilisateur.getCredit() >= montantEnchere) {
            Enchere enchere = new Enchere();
            enchere.setNoUtilisateur(noUtilisateur);
            enchere.setNoArticle(noArticle);
            enchere.setMontantEnchere(montantEnchere);

            try {
                enchere = DAOFactory.getEnchereDAO().insert(enchere);


            } catch (DatabaseException e) {
                throw new Exception("Erreur lors de la gestion de l'enchère.", e);
            }

            return enchere;
        }
        return null;
    }

    @Override
    public boolean verifierEnchereValide(int noUtilisateur, int montantEnchere) {
        Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().getUtilisateurParNoUtilisateur(noUtilisateur);
        if (utilisateur.getCredit() >= montantEnchere) {
            return true;
        } else {
            return false;
        }
           
    }

    @Override
    public int getUtilisateurIdMeilleureOffre(int enchereId) throws DatabaseException {
        return DAOFactory.getEnchereDAO().getUtilisateurIdMeilleureOffre(enchereId);
    }
}
