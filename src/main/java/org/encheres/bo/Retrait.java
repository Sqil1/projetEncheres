package org.encheres.bo;

public class Retrait {
    private String rue;
    private String codePostal;
    private String ville;
    
    public Retrait() {}

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        if (rue == null) {
            throw new IllegalStateException("rue ne peut pas être null");
        }
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        if (codePostal == null) {
            throw new IllegalStateException("codePostal ne peut pas être null");
        }
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        if (ville == null) {
            throw new IllegalStateException("ville ne peut pas être null");
        }
        this.ville = ville;
    }
}
