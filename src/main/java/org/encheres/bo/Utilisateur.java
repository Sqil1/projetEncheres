package org.encheres.bo;

public class Utilisateur {
    private Integer noUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String rue;
    private String codePostal;
    private String ville;
    private String motDePasse;
    private Integer credit;
    private boolean administrateur;

    public Utilisateur() {}

    public Integer getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(Integer noUtilisateur) {
        if (noUtilisateur == null) {
            throw new IllegalStateException("noUtilisateur ne peut pas �tre null");
        }
        this.noUtilisateur = noUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        if (pseudo == null) {
            throw new IllegalStateException("pseudo ne peut pas �tre null");
        }
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null) {
            throw new IllegalStateException("nom ne peut pas �tre null");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom == null) {
            throw new IllegalStateException("prenom ne peut pas �tre null");
        }
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalStateException("email ne peut pas �tre null");
        }
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        if (rue == null) {
            throw new IllegalStateException("rue ne peut pas �tre null");
        }
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        if (codePostal == null) {
            throw new IllegalStateException("codePostal ne peut pas �tre null");
        }
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        if (ville == null) {
            throw new IllegalStateException("ville ne peut pas �tre null");
        }
        this.ville = ville;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        if (motDePasse == null) {
            throw new IllegalStateException("motDePasse ne peut pas �tre null");
        }
        this.motDePasse = motDePasse;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        if (credit == null) {
            throw new IllegalStateException("credit ne peut pas �tre null");
        }
        this.credit = credit;
    }

    public boolean getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }
}
