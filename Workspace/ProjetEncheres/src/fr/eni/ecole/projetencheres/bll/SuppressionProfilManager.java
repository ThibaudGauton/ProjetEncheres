package fr.eni.ecole.projetencheres.bll;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;
import fr.eni.ecole.projetencheres.dal.DAOFactory;

public class SuppressionProfilManager {

	public void supprimerProfil(Utilisateur utilisateur) {
		DAOFactory.getUtilisateurDAO().supprimerUtilisateur(utilisateur);
	}

}
