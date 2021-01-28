package fr.eni.ecole.projetencheres.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.projetencheres.bll.CreationCompteManager;
import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/creationcompte")
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/creationcompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codepostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String motdepasse = request.getParameter("motdepasse");
		String confirmationmdp = request.getParameter("confirmationmdp");
		
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
		
		
		
		CreationCompteManager creationCompteManager = new CreationCompteManager();
		Map<String, String> verif = creationCompteManager.verif(request.getParameter("motdepasse"), request.getParameter("confirmationmdp"));
		System.out.println("test resultat : "+verif);
		
		if(verif.isEmpty()) {
			//enregistrer en bdd
			System.out.println("enregistrment en bdd");
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motdepasse);
			System.out.println("user créé");
			creationCompteManager.enregistrerRepas(utilisateur);
			System.out.println("user enregistré");
			request.getSession().setAttribute("utilisateurConnecte", utilisateur);
			request.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}else {
			//affichage des erreurs
			request.setAttribute("mapErreur", verif);
			request.getServletContext().getRequestDispatcher("/creationcompte.jsp").forward(request, response);
		}
		
	}

}
