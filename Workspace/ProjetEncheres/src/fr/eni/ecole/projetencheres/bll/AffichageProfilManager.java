package fr.eni.ecole.projetencheres.bll;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;
import fr.eni.ecole.projetencheres.dal.DAOFactory;

public class AffichageProfilManager {

	public Utilisateur getInfosUtilisateur(String pseudoUtilisateur) {
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().getUtilisateur(pseudoUtilisateur);
		
		return utilisateur;
	}

}
