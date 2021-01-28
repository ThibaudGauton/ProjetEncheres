package fr.eni.ecole.projetencheres.bll.bo;

import javax.websocket.Decoder.Binary;

public class Utilisateur {
	private String pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse;
	
	private int noUtilisateur;
	private int credit;
	private boolean administrateur;

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codepostal, String ville, String motdepasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codepostal;
		this.ville = ville;
		this.motDePasse = motdepasse;
		this.credit = 0;
		this.administrateur = false;
	}

	public Utilisateur() {
	}

	
	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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
		this.rue = rue;
	}

	public String getCodepostal() {
		return codePostal;
	}

	public void setCodepostal(String codepostal) {
		this.codePostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotdepasse() {
		return motDePasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motDePasse = motdepasse;
	}
	
	

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", telephone=" + telephone + ", rue=" + rue + ", codepostal=" + codePostal + ", ville=" + ville
				+ ", motdepasse=" + motDePasse + "]";
	}


}
