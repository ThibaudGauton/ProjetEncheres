package fr.eni.ecole.projetencheres.bll;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;
import fr.eni.ecole.projetencheres.dal.DAOFactory;

public class ConnexionManager {
	public Utilisateur connexionUtilisateur(String identifiant, String motDePasse) {
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().getConnexion(identifiant, motDePasse);
		return utilisateur;
	}
}
