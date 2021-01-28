package fr.eni.ecole.projetencheres.bll;

import java.util.HashMap;
import java.util.Map;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;
import fr.eni.ecole.projetencheres.dal.DAOFactory;

public class CreationCompteManager {
	public boolean verifMDP(String mdp, String confirmation) {
		if(mdp.equals(confirmation))
			return true;
		return false;
	}

	public Map<String, String> verif(String mdp, String confirmation) {
		HashMap<String, String> mapDErreur = new HashMap<String, String>();
		if(!verifMDP(mdp, confirmation)) {
			mapDErreur.put("motDePasse", "Les mots de passe ne correspondent pas");
		}
		return mapDErreur;
	}


	public void enregistrerRepas(Utilisateur utilisateur) {
		DAOFactory.getUtilisateurDAO().enregistrerUtilisateur(utilisateur);
	}
}
