package fr.eni.ecole.projetencheres.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.projetencheres.bll.CreerOuModifierProfilManager;
import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/modifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/modifierProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codepostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String nouveauMotDePasse = request.getParameter("motdepasse");
		String confirmationmdp = request.getParameter("confirmationmdp");
		if ("".equals(nouveauMotDePasse) && "".equals(confirmationmdp)) {
			nouveauMotDePasse=motDePasseActuel;
			confirmationmdp=motDePasseActuel;
		}
		Utilisateur utilisateurModifie = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, nouveauMotDePasse);
		Utilisateur utilisateurCourant = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		
		
		/*
		System.out.println(pseudo);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(email);
		System.out.println(telephone);
		System.out.println(rue);
		System.out.println(codepostal);
		System.out.println(ville);
		System.out.println(motdepasse);
		System.out.println(confirmationmdp);
		*/
		
		CreerOuModifierProfilManager modifierProfilManager = new CreerOuModifierProfilManager();
		Map<String, String> verif = modifierProfilManager.verif(utilisateurCourant, utilisateurModifie, confirmationmdp, motDePasseActuel);
		
		
		
		if(verif.isEmpty()) {
			//enregistrer en bdd
			modifierProfilManager.modifierUtilisateur(utilisateurCourant, utilisateurModifie);
			request.getSession().setAttribute("utilisateurConnecte", utilisateurModifie);
			request.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}else {
			//affichage des erreurs
			request.setAttribute("mapErreur", verif);
			request.getServletContext().getRequestDispatcher("/modifierProfil.jsp").forward(request, response);
		}
		
		
		//ajouter les infos du formulaire
		//${}
		//ajouter un attribut dans la session
		//request.getSession().setAttribute("message", "je suis un message de la servlet");
		//supprimer la session
		//request.getSession().invalidate();
		//supprimer un attribut dans la session
		//request.getSession().removeAttribute("nomattribut");
	}

}
