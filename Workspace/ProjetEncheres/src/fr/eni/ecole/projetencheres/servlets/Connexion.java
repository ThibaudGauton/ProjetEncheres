package fr.eni.ecole.projetencheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.projetencheres.bll.ConnexionManager;
import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motdepasse");
		
		ConnexionManager connexionManager = new ConnexionManager();
		
		Utilisateur utilisateur = connexionManager.connexionUtilisateur(identifiant, motDePasse);
		if(utilisateur != null) {
			request.getSession().setAttribute("utilisateurConnecte", utilisateur);
			request.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}else {
			request.setAttribute("erreurConnexion", "L'identifiant et le mot de passe ne correspondent pas");
			request.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		}
	}

}
