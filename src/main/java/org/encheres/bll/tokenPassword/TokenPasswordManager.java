package org.encheres.bll.tokenPassword;

import org.encheres.bo.TokenPassword;

import java.time.LocalDateTime;

public interface TokenPasswordManager {


	TokenPassword creerTokenPassword(Integer noUtilisateur, String token, LocalDateTime dateCreation, LocalDateTime dateExpiration);

	TokenPassword getToken(String token);


	void setUsedToken(String token);
}
