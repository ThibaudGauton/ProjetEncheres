package fr.eni.ecole.projetencheres.dal;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

public interface UtilisateurDAO {

	public void enregistrerUtilisateur(Utilisateur Utilisateur);

	public Utilisateur getConnexion(String identifiant, String motDePasse);

	public Utilisateur getUtilisateur(String pseudoUtilisateur);

	public void modifierUtilisateur(Utilisateur utilisateurCourant, Utilisateur utilisateurModifie);

	public void supprimerUtilisateur(Utilisateur utilisateur);
	
}
