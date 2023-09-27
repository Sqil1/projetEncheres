package org.encheres.bo;

import java.time.LocalDateTime;

/**
 * <p>POJO represente un Utilisateur.</p>
 * <p>Utilise le Builder Pattern.</p>
 * <p>
 * Instanciation/constructeur ex :
 * <pre>Utilisateur utilisateur = Utilisateur.builder(args).build.()</pre>
 * <p>Setters ex :</p>
 * <pre>Utilisateur utilisateur =
 * Utilisateur.builder()
 * .setPseudo(pseudo)
 * .setNom(nom)
 * .build();</pre>
 *
 * @see TokenPassword#builder()
 * @see TokenPassword#builder(TokenPassword)
 */
public class TokenPassword {
    private final Integer noToken;
    private final Integer noUtilisateur;
    private final String token;
    private final boolean tokenUsed;
    private final LocalDateTime dateCreation;
    private final LocalDateTime dateExpiration;

    private TokenPassword(Builder builder) {
        this.noUtilisateur = builder.noUtilisateur;
        this.noToken = builder.noToken;
        this.tokenUsed = builder.tokenUsed;
        this.token = builder.token;
        this.dateCreation = builder.dateCreation;
        this.dateExpiration = builder.dateExpiration;
    }

    /**
     * Constructor. Exemple instanciation:
     * <pre>Utilisateur utilisateur = Utilisateur.builder().build();</pre>
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Constructor. Exemple instanciation:
     * <pre>Utilisateur utilisateur = Utilisateur.builder(Utilisateur).build();</pre>
     */
    public static Builder builder(TokenPassword utilisateur) {
        return new Builder(utilisateur);
    }

    /**
     * Constructor. Exemple instanciation:
     * <pre>Utilisateur utilisateur = Utilisateur.builder(
     * String pseudo,
     * String nom,
     * String prenom,
     * String email,
     * String telephone,
     * String rue,
     * String codePostal,
     * String ville
     * ).build();</pre>
     */
    public static Builder builder(
            Integer noToken,
            Integer noUtilisateur,
            String token,
            boolean tokenUsed,
            LocalDateTime dateCreation,
            LocalDateTime dateExpiration
    ) {
        return new Builder(
                noToken,
                noUtilisateur,
                token,
                tokenUsed,
                dateCreation,
                dateExpiration
        );
    }


    public Integer getNoUtilisateur() {
        return noUtilisateur;
    }

    public Integer getNoToken() {
        return noToken;
    }

    public boolean isTokenUsed() {
        return tokenUsed;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }

    public String getToken() {
        return token;
    }


    public static class Builder {
        private Integer noToken;
        private Integer noUtilisateur;
        private String token;
        private boolean tokenUsed;
        private LocalDateTime dateCreation;
        private LocalDateTime dateExpiration;

        public Builder() {

        }

        public Builder(TokenPassword utilisateur) {
            this.noUtilisateur = utilisateur.noUtilisateur;
            this.noToken = utilisateur.noToken;
            this.token = utilisateur.token;
            this.dateCreation = utilisateur.dateCreation;
            this.dateExpiration = utilisateur.dateExpiration;
        }

        public Builder(
                Integer noUtilisateur,
                Integer noToken,
                String token,
                boolean tokenUsed,
                LocalDateTime dateCreation,
                LocalDateTime dateExpiration
        ) {
            this.noUtilisateur = noUtilisateur;
            this.noToken = noToken;
            this.token = token;
            this.dateCreation = dateCreation;
            this.tokenUsed = tokenUsed;
            this.dateExpiration = dateExpiration;
        }

        public Builder setNoUtilisateur(Integer noUtilisateur) {
            this.noUtilisateur = noUtilisateur;
            return this;
        }

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public Builder setTokenUsed(boolean tokenUsed) {
            this.tokenUsed = tokenUsed;
            return this;
        }

        public Builder setNoToken(Integer noToken) {
            this.noToken = noToken;
            return this;
        }

        public Builder setDateCreation(LocalDateTime dateCreation) {
            this.dateCreation = dateCreation;
            return this;
        }

        public Builder setDateExpiration(LocalDateTime dateExpiration) {
            this.dateExpiration = dateExpiration;
            return this;
        }

        public TokenPassword build() {
            return new TokenPassword(this);
        }

    }
}
