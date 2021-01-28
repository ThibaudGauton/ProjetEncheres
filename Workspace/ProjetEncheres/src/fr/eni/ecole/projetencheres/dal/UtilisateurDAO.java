package fr.eni.ecole.projetencheres.dal;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

public interface UtilisateurDAO {

	public void enregistrerUtilisateur(Utilisateur Utilisateur);

	public Utilisateur getConnexion(String identifiant, String motDePasse);
	
}
