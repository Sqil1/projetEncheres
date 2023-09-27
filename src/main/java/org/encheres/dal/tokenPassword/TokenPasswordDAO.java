package org.encheres.dal.tokenPassword;

import org.encheres.bo.TokenPassword;

public interface TokenPasswordDAO {
    TokenPassword insert(TokenPassword tokenPassword);
    TokenPassword getByToken(String token);
   void setUsedToken(String token);

}
