package org.encheres.bll.tokenPassword;

import org.encheres.bo.TokenPassword;
import org.encheres.bo.Utilisateur;
import org.encheres.dal.DAOFactory;
import org.encheres.module.EmailSender;
import org.encheres.utils.PBKDF2Hasher;

import java.time.LocalDateTime;

public class TokenPasswordManagerImpl implements TokenPasswordManager {

    private static TokenPasswordManager utilisateurManager = null;

    public static TokenPasswordManager getInstance() {
        if (utilisateurManager == null) {
            synchronized (TokenPasswordManager.class) {
                if (utilisateurManager == null) {
                    utilisateurManager = new TokenPasswordManagerImpl();
                }
            }
        }
        return utilisateurManager;
    }

    @Override
    public TokenPassword creerTokenPassword(Integer noUtilisateur, String token, LocalDateTime dateCreation, LocalDateTime dateExpiration) {
        TokenPassword tokenPassword = DAOFactory.getTokenPasswordDAO().insert(TokenPassword.builder()
                .setNoUtilisateur(noUtilisateur)
                .setToken(token)
                .setDateCreation(dateCreation)
                .setDateExpiration(dateExpiration)
                .build());

        String email = DAOFactory.getUtilisateurDAO().getUtilisateurParNoUtilisateur(noUtilisateur)
                .getEmail();

        EmailSender.getInstance()
                .sendEmail(email, "Mots de passe oublier", "http://localhost:8080/changeMotsDePasse?token=" + token);
        return tokenPassword;
    }

    @Override
    public TokenPassword getToken(String token) {
        return DAOFactory.getTokenPasswordDAO().getByToken(token);
    }

    @Override
    public void setUsedToken(String token) {
        DAOFactory.getTokenPasswordDAO().setUsedToken(token);
    }
}
