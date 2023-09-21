package org.encheres.bo;

import com.microsoft.sqlserver.jdbc.StringUtils;
/**
 * <p>POJO represente un Utilisateur.</p>
 * <p>Utilise le Builder Pattern.</p>
 * 
<<<<<<< HEAD
 * Instanciation/constructeur :
 * <pre>Utilisateur utilisateur = Utilisateur.builder(args).build.()</pre>
 * <p>Setters :</p>
 * <pre> Utilisateur.builder(args).setterName(args).build();</pre>
=======
 * Instanciation/constructeur ex :
 * <pre>Utilisateur utilisateur = Utilisateur.builder(args).build.()</pre>
 * <p>Setters ex :</p>
 * <pre>Utilisateur utilisateur =
        Utilisateur.builder()
        .setPseudo(pseudo)
        .setNom(nom)
        .build();</pre>
>>>>>>> 5e8379e787825f2bf4f7bf1930b34064e9a57ca2
 * @see Utilisateur#builder()
 * @see Utilisateur#builder(Utilisateur)
 * @see Utilisateur#builder(String, String, String, String, String, String, String, String)
 * @see Utilisateur#builder(String, String, String, String, String, String, String, String, String, Integer, boolean)
 */
public class Utilisateur {
	private final Integer noUtilisateur;
	private final String pseudo;
	private final String nom;
	private final String prenom;
	private final String email;
	private final String telephone;
	private final String rue;
	private final String codePostal;
	private final String ville;
	private final String motDePasse;
	private final Integer credit;
	private final boolean administrateur;

	private Utilisateur(Builder builder) {
		this.noUtilisateur = builder.noUtilisateur;
		this.pseudo = builder.pseudo;
		this.nom = builder.nom;
		this.prenom = builder.prenom;
		this.email = builder.email;
		this.telephone = builder.telephone;
		this.rue = builder.rue;
		this.codePostal = builder.codePostal;
		this.ville = builder.ville;
		this.motDePasse = builder.motDePasse;
		this.credit = builder.credit;
		this.administrateur = builder.administrateur;
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
	public static Builder builder(Utilisateur utilisateur) {
		return new Builder(utilisateur);
	}

	/**
	 * Constructor. Exemple instanciation:
	 * <pre>Utilisateur utilisateur = Utilisateur.builder(
			String pseudo,
			String nom,
			String prenom,
			String email,
			String telephone,
			String rue,
			String codePostal,
			String ville
		).build();</pre>
	*/
	public static Builder builder(
		String pseudo,
		String nom,
		String prenom,
		String email,
		String telephone,
		String rue,
		String codePostal,
		String ville
	) {
		return new Builder(
			pseudo,
			nom,
			prenom,
			email,
			telephone,
			rue,
			codePostal,
			ville
		);
	}

	/**
	 * Constructor. Exemple instanciation:
	 * <pre>Utilisateur utilisateur = Utilisateur.builder(
			String pseudo,
			String nom,
			String prenom,
			String email,
			String telephone,
			String rue,
			String codePostal,
			String ville,
			String motDePasse,
			Integer credit,
			boolean administrateur
		).build();</pre>
	*/
	public static Builder builder(
			String pseudo,
			String nom,
			String prenom,
			String email,
			String telephone,
			String rue,
			String codePostal,
			String ville,
			String motDePasse,
			Integer credit,
			boolean administrateur
		) {
		return new Builder(
			pseudo,
			nom,
			prenom,
			email,
			telephone,
			rue,
			codePostal,
			ville,
			motDePasse,
			credit,
			administrateur
		);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [noUtilisateur=");
		builder.append(noUtilisateur);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateur=");
		builder.append(administrateur);
		builder.append("]");
		return builder.toString();
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getRue() {
		return rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public String getVille() {
		return ville;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public boolean getAdministrateur() {
		return administrateur;
	}
	public Integer getCredit() {
		return credit;
	}

	public static class Builder {
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

		public Builder() {}

		public Builder(Utilisateur utilisateur) {
			this.noUtilisateur = utilisateur.noUtilisateur;
			this.pseudo = utilisateur.pseudo;
			this.nom = utilisateur.nom;
			this.prenom = utilisateur.prenom;
			this.email = utilisateur.email;
			this.telephone = utilisateur.telephone;
			this.rue = utilisateur.rue;
			this.codePostal = utilisateur.codePostal;
			this.ville = utilisateur.ville;
			this.motDePasse = utilisateur.motDePasse;
			this.credit = utilisateur.credit;
			this.administrateur = utilisateur.administrateur;
		}

		public Builder(
			String pseudo,
			String nom,
			String prenom,
			String email,
			String telephone,
			String rue,
			String codePostal,
			String ville,
			String motDePasse,
			Integer credit,
			boolean administrateur
		) {
			this.pseudo = pseudo;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.telephone = telephone;
			this.rue = rue;
			this.codePostal = codePostal;
			this.ville = ville;
			this.motDePasse = motDePasse;
			this.credit = credit;
			this.administrateur = administrateur;
		}

		public Builder(
			String pseudo,
			String nom,
			String prenom,
			String email,
			String telephone,
			String rue,
			String codePostal,
			String ville
		) {
			this.pseudo = pseudo;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.telephone = telephone;
			this.rue = rue;
			this.codePostal = codePostal;
			this.ville = ville;
		}

		public Builder setNoUtilisateur(Integer noUtilisateur) {
			this.noUtilisateur = noUtilisateur;
			return this;
		}

		public Builder setPseudo(String pseudo) {
			if (StringUtils.isEmpty(pseudo)) {
				throw new IllegalStateException("pseudo ne peut pas être null");
			}
			this.pseudo = pseudo;
			return this;
		}

		public Builder setNom(String nom) {
			this.nom = nom;
			return this;
		}

		public Builder setPrenom(String prenom) {
			this.prenom = prenom;
			return this;
		}

		public Builder setEmail(String email) {
			if (StringUtils.isEmpty(email)) {
				throw new IllegalStateException("email ne peut pas être null");
			}
			this.email = email;
			return this;
		}

		public Builder setTelephone(String telephone) {
			this.telephone = telephone;
			return this;
		}

		public Builder setRue(String rue) {
			if (StringUtils.isEmpty(rue)) {
				throw new IllegalStateException("rue ne peut pas être null");
			}
			this.rue = rue;
			return this;
		}

		public Builder setCodePostal(String codePostal) {
			this.codePostal = codePostal;
			return this;
		}

		public Builder setVille(String ville) {
			if (StringUtils.isEmpty(ville)) {
				throw new IllegalStateException("ville ne peut pas être null");
			}
			this.ville = ville;
			return this;
		}

		public Builder setMotDePasse(String motDePasse) {
			if (StringUtils.isEmpty(motDePasse)) {
				throw new IllegalStateException("motDePasse ne peut pas être null");
			}
			this.motDePasse = motDePasse;
			return this;
		}

		public Builder setCredit(Integer credit) {
			if (credit == null) {
				throw new IllegalStateException("credit ne peut pas être null");
			}
			this.credit = credit;
			return this;
		}

		public Builder setAdministrateur(boolean administrateur) {
			this.administrateur = administrateur;
			return this;
		}

		public Utilisateur build() {
			return new Utilisateur(this);
		}
	}
}
