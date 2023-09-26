package org.encheres.dal.Enchere;

import java.util.List;

import org.encheres.bo.Enchere;
import org.encheres.errors.DatabaseException;

public interface EnchereDAO {
	public Enchere insert(Enchere enchere) throws DatabaseException;
    public void update(Enchere enchere) throws DatabaseException;
    //public void deleteById(Integer );
    public List<Enchere> selectAll() throws DatabaseException;
	public int getUtilisateurIdMeilleureOffre(int enchereId) throws DatabaseException;
	
}
