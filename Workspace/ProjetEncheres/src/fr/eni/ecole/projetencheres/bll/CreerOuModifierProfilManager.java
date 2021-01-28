package fr.eni.ecole.projetencheres.bll;

import java.util.HashMap;
import java.util.Map;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;
import fr.eni.ecole.projetencheres.dal.DAOFactory;

public class CreerOuModifierProfilManager {

	//vérifie si le mot de passe actuel et la confirmation du mot de passe sont égaux
	public boolean verifMDPEtConfirmation(String mdp, String confirmation) {
		if(mdp.equals(confirmation))
			return true;
		return false;
	}
	
	//Vérifie si le mot de passe actuel correspond bien au mot de passe en base de donnée.
	public boolean verifMDPActuel(String pseudo, String mdp) {
		if(DAOFactory.getUtilisateurDAO().getConnexion(pseudo, mdp) != null) {
			return true;
		}
		return false;
	}
	
	//Vérifie si le nouveau pseudo est différent de l'actuel et si oui vérifie si le nouveau pseudo n'existe pas dans la base.
	public boolean verifNouveauPseudoExisteDeja(String pseudoActuel, String pseudoNouveau) {
		if(!pseudoActuel.equals(pseudoNouveau)) {
			if(verifPseudoExisteDeja(pseudoNouveau)) {
				//le pseudo est différent de l'ancien et existe dans la base.
				return true;
			}
		}
		//le pseudo est le meme que l'ancien ou le pseudo n'existe pas dans la base
		return false;
	}
	public boolean verifPseudoExisteDeja(String pseudo) {
		return DAOFactory.getUtilisateurDAO().getUtilisateur(pseudo) != null;
	}
	
	public boolean verifNouveauEmailExisteDeja(String emailActuel, String emailNouveau) {
		if(!emailActuel.equals(emailNouveau)) {
			if(verifEmailExisteDeja(emailNouveau)) {
				//l'email est différent de l'ancien et existe dans la base.
				return true;
			}
		}
		//l'email est le meme que l'ancien ou l'email n'existe pas dans la base
		return false;
	}
	
	public boolean verifEmailExisteDeja(String email) {
		return DAOFactory.getUtilisateurDAO().getUtilisateur(email) != null;
	}
	

	public Map<String, String> verif(Utilisateur utilisateurCourant, Utilisateur utilisateurModifie, String confirmationmdp, String motDePasseActuel) {
		HashMap<String, String> mapDErreur = new HashMap<String, String>();
		if(!verifMDPEtConfirmation(utilisateurModifie.getMotdepasse(), confirmationmdp)) {
			mapDErreur.put("motDePasseConfirmation", "Les nouveaux mots de passe ne correspondent pas");
		}
		if(!verifMDPActuel(utilisateurCourant.getPseudo(), motDePasseActuel)) {
			mapDErreur.put("motDePasseActuel", "Le mot de passe actuel ne correspond pas au mot de passe enregistré.");
		}
		if(verifNouveauPseudoExisteDeja(utilisateurCourant.getPseudo(), utilisateurModifie.getPseudo())) {
			mapDErreur.put("pseudoExistant", "Le nouveau pseudo existe déjà dans la base.");
		}
		if(verifNouveauEmailExisteDeja(utilisateurCourant.getEmail(), utilisateurModifie.getEmail())) {
			mapDErreur.put("emailExistant", "Le nouvel email existe déjà dans la base.");
		}
		return mapDErreur;
	}

	public void modifierUtilisateur(Utilisateur utilisateurCourant, Utilisateur utilisateurModifie) {
		DAOFactory.getUtilisateurDAO().modifierUtilisateur(utilisateurCourant, utilisateurModifie);
		
	}
	
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		DAOFactory.getUtilisateurDAO().enregistrerUtilisateur(utilisateur);
	}

	public Map<String, String> verif(Utilisateur utilisateur, String confirmationMotDePasse) {
		HashMap<String, String> mapDErreur = new HashMap<String, String>();
		if(!verifMDPEtConfirmation(utilisateur.getMotdepasse(), confirmationMotDePasse)) {
			mapDErreur.put("motDePasseConfirmation", "Les mots de passe ne correspondent pas");
		}
		if(verifPseudoExisteDeja(utilisateur.getPseudo())) {
			mapDErreur.put("pseudoExistant", "Le pseudo existe déjà dans la base.");
		}
		if(verifEmailExisteDeja(utilisateur.getEmail())) {
			mapDErreur.put("emailExistant", "L'email existe déjà dans la base.");
		}
		return mapDErreur;
	}
}
